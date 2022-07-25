package com.qpg.expr.utils.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import com.qpg.expr.QPGWorkloadConfig;
import com.qpg.expr.execplan.ExecPlan;
import com.qpg.expr.utils.DBClient;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import site.ycsb.Status;

import java.text.SimpleDateFormat;
import java.util.*;

public class MongoDBClient extends DBClient {
  private static Logger logger = Logger.getLogger(MongoDBClient.class);

  /** Used to include a field in a response. */
  private final Integer INCLUDE = Integer.valueOf(1);

  private Properties properties;

  /** The connection to MongoDB. */
  private MongoClient mongoClient;

  /** The database to MongoDB. */
  private MongoDatabase database;

  /** The batch size to use for inserts. */
  //private static int batchSize;
  /** The bulk inserts pending for the thread. */
  //private final List<Document> bulkInserts = new ArrayList<Document>();

  public MongoDBClient(Properties p){
    this.properties = p;
    init();
  }

  public void cleanup(){
    try {
      mongoClient.close();
    } catch (final Exception e1) {
      e1.printStackTrace();
      logger.error("Could not close MongoDB connection pool: "
          + e1.getMessage());
      return;
    } finally {
      mongoClient = null;
      database = null;
    }
  }

  public void init() {
      if (mongoClient != null) {
        return;
      }
      //mongodb://localhost:27017/onlinestore_lima?w=1
      String url = "mongodb://"+properties.getProperty(QPGWorkloadConfig.DB_HOSTS_PROPERTY)
          +":"+properties.getProperty(QPGWorkloadConfig.DB_PORT_PROPERTY)
          +"/"+properties.getProperty(QPGWorkloadConfig.DB_DATABASE_PROPERTY)+"?w=1";
      if (!url.startsWith("mongodb://") && !url.startsWith("mongodb+srv://")) {
        System.err.println("ERROR: Invalid URL: '" + url + "'. Must be of the form "
            + "'mongodb://<host1>:<port1>,<host2>:<port2>/database?options' "
            + "or 'mongodb+srv://<host>/database?options'. "
            + "http://docs.mongodb.org/manual/reference/connection-string/");
        System.exit(1);
      }
      try {
        MongoClientURI uri = new MongoClientURI(url);

        String uriDb = uri.getDatabase();
        logger.info("Database name "+ uriDb);

        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase(uriDb);

        logger.info("mongo client connection created with " + url);
      } catch (Exception e1) {
        logger.error("Could not initialize MongoDB connection pool for Loader: " + e1.getMessage());
        return;
      }
  }

  private Status read( ExecPlan.QueryExecPlan query, Map<String, Object> values,
                     List<Document> result){
    String table = query.getClass_name();
    List<String> eas = query.getEas();
    List<String[]> ieas = query.getIeas();
    List<String> oas =  query.getOas();
    List<String> fields = query.getPas();
    try{
      List<Bson> filters = new ArrayList<>();
      MongoCollection<Document> collection = database.getCollection(table);
      for(String ea:eas) {
        Object v =(values.get(ea)!= null)? values.get(ea): values.get(query.getAttrAlias(ea));
        if(v == null){
          filters.add(Filters.eq(ea,query.getRandomQueryValue(ea)));
          continue;
        }
        if(v instanceof Set) {
            filters.add(Filters.in(ea, ((Set)v).toArray()));
        }else
          filters.add(Filters.eq(ea, v));
      }

      for(String[] a: ieas){
        Object o;
        if(values.get(a[0]) == null){
          o = query.getRandomQueryValue(a[0]);
        }else o = values.get(a[0]);
        if(o instanceof Date) {
          filters.add(Filters.gt(a[0], (new SimpleDateFormat("yyyy-mm-dd")).format(o)));
        }else
          filters.add(Filters.gt(a[0],o));
      }

      FindIterable<Document> findIterable = collection.find(Filters.and(filters));
      if (oas != null) {
        Document orderby = new Document();
        for (String oa : oas) {
          orderby.put(oa, INCLUDE);
        }
        findIterable.sort(orderby);
      }
      if (fields != null) {
        Document projection = new Document();
        for (String field : fields) {
          projection.put(field, INCLUDE);
        }
        findIterable.projection(projection);
      }

      Iterator<Document> dit = findIterable.iterator();
      while(dit.hasNext())
        result.add(dit.next());
      return !result.isEmpty()? Status.OK : Status.NOT_FOUND;
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Exception: ", e);
          return Status.ERROR;
     }
  }

  @Override
  public void runEachQueryPlan(String test_name,
                               Map<String, Object> values, ExecPlan execPlan) {
    List<Document> results = new ArrayList<>();
    ExecPlan.QueryExecPlan q = execPlan.getFirstQuery(test_name);
    Status status = read(q, values, results);
    logger.info("Test "+ test_name + "on class " + q.getClass_name() + " get results "+ results.size()+".");
    List<ExecPlan.QueryExecPlan> queries = execPlan.getQuery(test_name);
    for(int i = 1; i < queries.size(); i++) {
      List<Document> new_results = new ArrayList<>();
      ExecPlan.QueryExecPlan qp = queries.get(i);
      if (qp.isFilter()) {
        List<String[]> ieas = qp.getIeas();
        for (Document r : results) {
          for (String[] iea : ieas) {
           //ByteBuffer val = r.getBytesUnsafe(iea[0]);
           // if (val != null) {}
          }
        }
      } else {
        Map<String, Object> ea_values = new HashMap<>();
        for (Document r : results) {
          List<String> eas = qp.getEas();
         for (String a : eas) {
           String a_path = qp.getAttrAlias(a);
           a_path = (a_path != null)? a_path: a;
           getDocumentValue(r, a, a_path, ea_values);
          }
        }
        if(!ea_values.isEmpty())
          read(qp, ea_values, new_results);
        logger.info("Test "+ test_name + "on class " + qp.getClass_name() + " get results "+ new_results.size()+".");
      }
    }
  }

  private void getDocumentValue(Document doc,String attr, String path, Map<String, Object> ea_values){
    String[] a_path = path.split("\\.");
    getDocumentChild(doc, attr, a_path, 0, ea_values);
  }

  private void getDocumentChild(Document parent, String attr, String[] path,
                                int path_index, Map<String, Object> ea_values){
    if(path_index >= path.length)
      return;
    Object child = parent.get(path[path_index]);
    if(child instanceof Document)
      getDocumentChild((Document)child, attr, path, path_index+1,ea_values );
    else if(child instanceof ArrayList)
    {
      for(Object c: (ArrayList<Object>)child){
        if(c instanceof Document)
          getDocumentChild((Document)c, attr, path, path_index+1,ea_values );
        else{
          if (ea_values.get(attr) == null)
            ea_values.put(attr, new HashSet<>());
          ((Set)ea_values.get(attr)).add(child);
        }
      }
    }
    else{
      if (ea_values.get(attr) == null)
        ea_values.put(attr, new HashSet<>());
      ((Set)ea_values.get(attr)).add(child);
    }
  }

  @Override
  public void runEachUpdatePlan(String test_name,
                                Map<String, Object> values, ExecPlan execPlan) {
    List<ExecPlan.UpdateExecPlan> updates = execPlan.getUpdate(test_name);
    for(ExecPlan.UpdateExecPlan u: updates) {
      List<Document> results = new ArrayList<>();
      if (u.getQueryEAs() != null) {
        List<Document> doc_ids = new ArrayList<>();
        read(u, values, doc_ids);

        int updated_num = 0;
        for(Document _id: doc_ids) {
          if(u.getQueryAttrs() == null || u.getQueryAttrs().isEmpty()) {
            update(new Document("_id", _id.get("_id")), u, values);
            updated_num++;
          }else {
            for (String qpa : u.getQueryAttrs()) {
              String[] attr = qpa.split("\\.");
              if(attr.length >1) {
                String id_attr = attr[attr.length-1];
                Map<String,Object> id_values = new HashMap<>();
                getDocumentValue(_id,id_attr,qpa, id_values);
                if(id_values.get(id_attr) == null)
                  continue;
                if(id_values.get(id_attr) instanceof Set){
                  for(Object v: ((Set)id_values.get(id_attr)))
                  {
                    update(new Document(id_attr, v), u, values);
                    updated_num++;
                  }
                }
                else {
                  update(new Document(id_attr, id_values.get(qpa)), u, values);
                  updated_num++;
                }
              }
              else {
                update(new Document(qpa, _id.get(qpa)), u, values);
                updated_num++;
              }
            }
          }

        }
        logger.info("Update of "+ test_name + " on Collection "+
            u.getUpdateTable() +" modified "+ updated_num+ " documents.");
      }
    }
  }


  private Status read( ExecPlan.UpdateExecPlan u, Map<String, Object> values,
                       List<Document> result){
    String table = u.getQueryTable();
    List<String> eas = u.getQueryEAs();
    List<String> fields = u.getQueryAttrs();
    try{
      List<Bson> filters = new ArrayList<>();
      MongoCollection<Document> collection = database.getCollection(table);
      for(String ea:eas) {
        if(values.get(ea) == null) {
          String[] attr = ea.split("\\.");
          if(values.get( attr[attr.length-1]) != null)
            values.put(ea, values.get( attr[attr.length-1]));
          else values.put(ea, u.getRandomQueryValue(ea));
        }
        filters.add(Filters.eq(ea,values.get(ea)));
      }
      FindIterable<Document> findIterable = collection.find(Filters.and(filters));

      Document projection = new Document();
      if (fields != null && !fields.isEmpty()) {
        for (String field : fields) {
          projection.put(field, INCLUDE);
        }
      }else{projection.put("_id", INCLUDE);}

      findIterable.projection(projection);
      Iterator<Document> dit = findIterable.iterator();
      while(dit.hasNext())
        result.add(dit.next());
      return !result.isEmpty()? Status.OK : Status.NOT_FOUND;
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return Status.ERROR;
    }
  }

  private Status update(Document query, ExecPlan.UpdateExecPlan u, Map<String,Object> values) {
    try {
      if(u.getUpdateAttrs().isEmpty())
        return Status.OK;

   //   logger.error(query.toString()+" ==+++++++++++++++++");

      /*
      * db.customer.update({orders:{$elemMatch:{"items.item_id":586526}}},
      * {$set:{"orders.$[o].items.$[i].item_quantity":77777777777}},
      * {arrayFilters:[{"o.items.item_id":586526},{"i.item_id":586526}]});
      * */
      String table = u.getUpdateTable();
      MongoCollection<Document> collection = database.getCollection(table);

      Map<String, String> attr_path = new HashMap<>(); //variable
      List<Document> filters = new ArrayList<>();
      for(String ea: u.getUpdateEAs()){
        if(values.get(ea) == null) {
          String[] attr = ea.split("\\.");
          if(values.get( attr[attr.length-1]) != null)
            values.put(ea, values.get( attr[attr.length-1]));
          else values.put(ea, u.getRandomQueryValue(ea));
        }
        Document parent = query;
        String[] path = ea.split("\\.");
        if(path.length <= 1) {
          parent.append(ea, values.get(ea));
          continue;
        }

        for(int i = 0; i < path.length-1; i++){
          Document child = new Document();
          parent.append(path[i], new Document("$elemMatch",child));
          parent = child;
          if(attr_path.get(path[i]) == null) {
            attr_path.put(path[i], "v"+i); //variable
          }
          String f_path=attr_path.get(path[i]); //get variable
          for(int j= i+1; j<path.length;j++)
            f_path += "."+path[j];
          filters.add(new Document(f_path, values.get(ea)));
        }
        parent.append(path[path.length-1], values.get(ea));
      }

      Document fieldsToSet = new Document();
      for (String av: u.getUpdateAttrs()) {
        if(values.get(av) == null)
          values.put(av, u.getRandomQueryValue(av));
        String[] path = av.split("\\.");
        if(path.length <= 1)
          fieldsToSet.put(av, values.get(av));
        else{
          String a_path = path[0] + ((attr_path.get(path[0])!= null)? (".$["+ attr_path.get(path[0]))+"]":"");
          for(int i = 1; i < path.length; i++){
            a_path += "."+path[i] + ((attr_path.get(path[i])!= null)? (".$["+ attr_path.get(path[i]))+"]":"");
          }
          fieldsToSet.append(a_path,values.get(av));
        }
      }
      Document update = new Document("$set", fieldsToSet);

      UpdateResult result = collection.updateOne(query, update, new UpdateOptions().arrayFilters(filters));
      if (result.wasAcknowledged() && result.getMatchedCount() == 0) {
        logger.error("Nothing updated for table " + u.getUpdateTable() );
        return Status.NOT_FOUND;
      }
      return Status.OK;
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Exception: ", e);
      return Status.ERROR;
    }
  }

}
