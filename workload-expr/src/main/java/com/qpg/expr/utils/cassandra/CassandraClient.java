package com.qpg.expr.utils.cassandra;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.qpg.expr.QPGWorkloadConfig;
import com.qpg.expr.execplan.ExecPlan;
import com.qpg.expr.utils.DBClient;
import org.apache.log4j.Logger;
import site.ycsb.Status;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;

public class CassandraClient extends DBClient {
  private static Logger logger = Logger.getLogger(CassandraClient.class);

  private Cluster cluster = null;
  private Session session = null;
  private String keyspace;
  private Properties properties;
  private KeyspaceMetadata ksmetadata;

  public CassandraClient(Properties p){
    this.properties = p;
    init();
  }

  @Override
  public void init() {
    if (cluster != null) {
        return;
      }
    String host = properties.getProperty(QPGWorkloadConfig.DB_HOSTS_PROPERTY);
    if(host == null)
        logger.error("Required property "+ QPGWorkloadConfig.DB_HOSTS_PROPERTY +" missing for CassandraClient");

    String[] hosts = host.split(",");
    String port = properties.getProperty(QPGWorkloadConfig.DB_PORT_PROPERTY);
    keyspace = properties.getProperty(QPGWorkloadConfig.DB_DATABASE_PROPERTY);

    cluster = Cluster.builder().withPort(Integer.valueOf(port))
        .addContactPoints(hosts).build();

    Metadata metadata = cluster.getMetadata();
    ksmetadata = metadata.getKeyspace(keyspace);
    logger.info("Connected to cluster: {" + metadata.getClusterName()+
        ", keyspace " + keyspace + "}\n" );

    for (Host discoveredHost : metadata.getAllHosts()) {
          logger.info("Datacenter: "+discoveredHost.getDatacenter()
                  +"; Host: {"+discoveredHost.getAddress()+"}; Rack: {"+discoveredHost.getRack()+"}\n");
        }
    session = cluster.connect(keyspace);
  }

  public KeyspaceMetadata getKsmetadata(){return ksmetadata;}

  @Override
  public void cleanup()  {
    session.close();
    cluster.close();
    cluster = null;
    session = null;
  }

  private Status read(ExecPlan.QueryExecPlan query,
                     Map<String, Object> values, List<Row> results) {
    String table = query.getClass_name();
    List<String> eas = query.getEas();
    List<String[]> ieas = query.getIeas();
    List<String> oas =  query.getOas();
    List<String> fields = query.getPas();

    Select.Builder selectBuilder = QueryBuilder.select();
    for (String col : fields) {
      ((Select.Selection) selectBuilder).column(col);
    }
    Select select = selectBuilder.from(table);

    if(!eas.isEmpty() || !ieas.isEmpty()) {
      Select.Where where = select.where();
      for(String a: eas){
        if(values.get(a) == null){
          where = where.and(QueryBuilder.eq(a, query.getRandomQueryValue(a)));
          continue;
        }
        if(values.get(a) instanceof  Set) {
          if(((Set) values.get(a)).toArray().length > 1)
            where = where.and(QueryBuilder.in(a, ((Set) values.get(a)).toArray()));
          else where = where.and(QueryBuilder.eq(a, ((Set) values.get(a)).toArray()[0]));
        }
        else where = where.and(QueryBuilder.eq(a, values.get(a)));
      }
      for(String[] a: ieas){
        Object v = values.get(a[0]);
        if(v == null){
           v = query.getRandomQueryValue(a[0]);
        }
        if(v instanceof Date) {
          where = where.and(QueryBuilder.gt(a[0], (new SimpleDateFormat("yyyy-mm-dd")).format(v)));
         // System.out.println("+++++++++"+where.toString());
        }
        else where = where.and(QueryBuilder.gt(a[0],v));
      }
    }

    if(!oas.isEmpty()){
      for(String o: oas)
        select.orderBy(QueryBuilder.asc(o));
    }
    return read(select,results);
  }

  private Status read(Statement stmt,List<Row> results){
    try{
      ResultSet rs = session.execute(stmt.toString());
      if (rs.isExhausted()) {
        logger.info("Succeed: "+ stmt.toString() + " with num of results: 0.");
        return Status.NOT_FOUND;
      }
      Iterator<Row> iter = rs.iterator();
      while(iter.hasNext()){
        results.add(iter.next());
      }
      logger.info("Succeed: "+ stmt.toString() + " with num of results: "+ results.size()+".");
      return Status.OK;
    }
    catch (Exception e) {
      e.printStackTrace();
      logger.error("Failed: " + stmt.toString() +"\n "+e.getMessage());
      return Status.ERROR;
    }
  }



  @Override
  public void runEachQueryPlan(String test_name,
                               Map<String, Object> values, ExecPlan execPlan){
    List<Row> results = new ArrayList<>();
    ExecPlan.QueryExecPlan q = execPlan.getFirstQuery(test_name);
    Status status = read(q,values, results);
    List<List<Row>> results_list = new ArrayList<>();
    results_list.add(results);
    List<ExecPlan.QueryExecPlan> queries = execPlan.getQuery(test_name);
    for(int i = 1; i < queries.size(); i++) {
      ExecPlan.QueryExecPlan qp = queries.get(i);
      if (qp.isFilter()) {
        List<String[]> ieas = qp.getIeas();
        for(List<Row> result: results_list) {
          if(result.isEmpty())
            continue;
          for (String[] iea : ieas) {
            Row r1 = result.get(0);
            if(!r1.getColumnDefinitions().contains(iea[0]))
              continue;
            for (Row r : result) {
              ByteBuffer val = r.getBytesUnsafe(iea[0]);
              if (val != null) {}
            }
          }
        }
      } else {
        Map<String,Object> ea_values = new HashMap<>();
        List<String> eas = qp.getEas();
        for(List<Row> result:results_list) {
          if(result.isEmpty())
            continue;
          for (String a : eas) {
            Row r1 = result.get(0);
            if(!r1.getColumnDefinitions().contains(a))
              continue;
            for (Row r : result) {
              Object bf = r.getInt(a);
              if (ea_values.get(a) == null)
                ea_values.put(a, new HashSet<>());
              ((Set) ea_values.get(a)).add(bf);
            }
          }
        }
        List<Row> new_results = new ArrayList<>();
        read( qp, ea_values, new_results);
        results_list.add( new_results);
      }
    }
  }

  private Object readColValue(Row r, String attr_name, DataType dt){
    if(dt.getName() == DataType.Name.TIMESTAMP)
      return r.getTimestamp(attr_name);
    if(dt.getName() == DataType.Name.INT)
      return r.getInt(attr_name);
    if(dt.getName() == DataType.Name.TEXT)
      return r.getString(attr_name);
    if(dt.getName() == DataType.Name.FLOAT)
      return r.getFloat(attr_name);
    logger.error("Cassandra data type "+ dt.getName() + "Not considered!");
    return null;
  }
  public Status read( String table, List<String> eas,
                      Map<String, Object> values, List<Row> results){
    Select.Builder selectBuilder = QueryBuilder.select().all();
    Select select = selectBuilder.from(table);
    Select.Where where = select.where();
    for(String v: eas){
      where = where.and(QueryBuilder.eq(v, values.get(v)));
    }
    return read(where, results);
  }

  public Status insert(String table, Map<String, Object> values) {
    try {
      Insert insertStmt = QueryBuilder.insertInto(table);
      for(String a: values.keySet()) {
        insertStmt.value(a, values.get(a));
      }
      logger.info(insertStmt);
      session.execute(insertStmt);
      return Status.OK;
    } catch (Exception e) {
      logger.error("Error inserting table: "+table+ "," + e);
    }
    return Status.ERROR;
  }

  @Override
  public void runEachUpdatePlan(String test_name,
                                Map<String, Object> values, ExecPlan execPlan){
    List<ExecPlan.UpdateExecPlan> updates = execPlan.getUpdate(test_name);
    for(ExecPlan.UpdateExecPlan u: updates){
      List<Row> results = new ArrayList<>();
      if(u.getQueryEAs() != null){
        read( u.getQueryTable(), u.getQueryEAs(), values,results);
      }
      for(Row r : results){
        List<ColumnMetadata> columns = ksmetadata.getTable(u.getQueryTable()).getColumns();
        Map<String, Object> new_values = new HashMap<>();
        for(ColumnMetadata cm : columns){
          if(values.get(cm.getName()) != null)
            new_values.put(cm.getName(),values.get(cm.getName()));
          else
            new_values.put(cm.getName(), readColValue(r, cm.getName(), cm.getType()));
        }
        insert(u.getUpdateTable(), new_values);
      }
    }
  }

}
