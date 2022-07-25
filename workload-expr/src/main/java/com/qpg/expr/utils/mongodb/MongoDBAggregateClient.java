package com.qpg.expr.utils.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
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

public class MongoDBAggregateClient extends DBClient {
  private static Logger logger = Logger.getLogger(MongoDBAggregateClient.class);

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

  public MongoDBAggregateClient(Properties p){
    this.properties = p;
    init();
  }

  public void cleanup(){
    try {
      mongoClient.close();
    } catch (final Exception e1) {
      logger.error("Could not close MongoDB connection pool: "
          + e1.toString());
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
        logger.error("Could not initialize MongoDB connection pool for Loader: " + e1.toString());
        return;
      }
  }


  /*private void constructAggregate(ExecPlan.QueryExecPlan query, List<Bson> pipeline,
                                  Document projection,
                                  Map<String, Object> values, int q_index){
    String table = query.getClass_name();
    List<String> eas = query.getEas();
   // List<String[]> ieas = query.getIeas();
   // List<String> oas =  query.getOas();
    List<String> fields = query.getPas();

    if(q_index > 0) { //join collection
      String table_as = table+"_join";
      pipeline.add(Aggregates.lookup(table, query.getAttrAlias(eas.get(0)), eas.get(0), table_as));
      if (fields != null) {
        for (String field : fields) {
          projection.put(table_as+"."+field, INCLUDE);
        }
      }
    }
    else{ // first collection
      List<Bson> filters = new ArrayList<>();
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
      pipeline.add(Aggregates.match(and(filters)));
      if (fields != null) {
        for (String field : fields) {
          projection.put(field, INCLUDE);
        }
      }
    }

  }
  @Override
  public void runEachQueryPlan(String test_name,
                               Map<String, Object> values, ExecPlan execPlan) {
    List<ExecPlan.QueryExecPlan> queries = execPlan.getQuery(test_name);

    ExecPlan.QueryExecPlan query = queries.get(0);//first query
    String table = query.getClass_name();
    MongoCollection<Document> collection = database.getCollection(table);

    List<Bson> pipeline = new ArrayList<Bson>();
    Document projection = new Document();
    for(int i = 0; i < queries.size(); i++) {
      ExecPlan.QueryExecPlan qp = queries.get(i);
      if (qp.isFilter()) {
      } else {
        constructAggregate(qp,  pipeline, projection, values, i);
      }
    }
    pipeline.add(Aggregates.project(projection));

    List<Document> results = collection.aggregate(pipeline).into(new ArrayList<>());
    logger.info("Test "+ test_name + "on class " +table + " get results "+ results.size()+".");
   // Joined.forEach(doc -> System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build())));
  }*/

  private Status read( ExecPlan.QueryExecPlan query, Map<String, Object> values,
                       List<Document> result){
    String table = query.getClass_name();
    List<String> eas = query.getEas();
    List<String[]> ieas = query.getIeas();
    List<String> oas =  query.getOas();
    List<String> fields = query.getPas();
    List<Bson> pipeline = new ArrayList<Bson>();
    try{
      MongoCollection<Document> collection = database.getCollection(table);
      Document projection = new Document();
      List<Bson> unwinds = new ArrayList<Bson>();
      List<String> processed_ea_ias = new ArrayList<>();
      if (fields != null) {
        for (String field : fields) {
          if(field.contains("$")){
            String uf = field.replace(".$", "");
            unwinds.add(Aggregates.unwind("$"+uf));
            List<Bson> filters = genFilters(query,values,uf, eas,ieas,processed_ea_ias);
            unwinds.add(Aggregates.match(and(filters)));
            projection.put(uf, INCLUDE);
          }else
            projection.put(field, INCLUDE);
        }
      }
      List<Bson> filters = genFilters(query,values,null, eas,ieas,processed_ea_ias);
      if(!filters.isEmpty())
        pipeline.add(Aggregates.match(and(filters)));
      pipeline.add(Aggregates.project(projection));
      if(!unwinds.isEmpty())
        pipeline.addAll(unwinds);

      if (oas != null) {
        Document orderby = new Document();
        for (String oa : oas) {
          orderby.put(oa, INCLUDE);
        }
        if(!oas.isEmpty())
          pipeline.add(Aggregates.sort(orderby));
      }

      result.addAll( collection.aggregate(pipeline).into(new ArrayList<>()));
      return !result.isEmpty()? Status.OK : Status.NOT_FOUND;
    } catch (Exception e) {
      logger.error(e.getStackTrace());
      return Status.ERROR;
    }
  }

  private List<Bson> genFilters(ExecPlan.QueryExecPlan query, Map<String, Object> values,
                                String prefix,
                                List<String> eas, List<String[]> ieas,
                                List<String> processed_ea_ias){
    List<Bson> filters = new ArrayList<>();
    for(String ea:eas) {
      if(prefix != null && !ea.startsWith(prefix))
        continue;
      /*if(processed_ea_ias.contains(ea))
        continue;
      processed_ea_ias.add(ea);*/
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
      if(prefix != null && !a[0].startsWith(prefix))
        continue;
      /*if(processed_ea_ias.contains(a[0]))
        continue;
      processed_ea_ias.add(a[0]);*/
      Object o;
      if(values.get(a[0]) == null)
        o = query.getRandomQueryValue(a[0]);
      else
        o = values.get(a[0]);
      if(o instanceof Date) {
        filters.add(Filters.gt(a[0], (new SimpleDateFormat("yyyy-mm-dd")).format(o)));
      }else
        filters.add(Filters.gt(a[0],o));
    }
    return filters;
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
        logger.info("Update of "+ test_name + " on Collection "+
            u.getUpdateTable() +" modified "+ doc_ids.size() + " documents.");
        for(Document _id: doc_ids)
          update(_id, u, values);
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
      System.err.println(e.toString());
      return Status.ERROR;
    }
  }

  private Status update(Document id_doc, ExecPlan.UpdateExecPlan u, Map<String,Object> values) {
    try {
      if(u.getUpdateAttrs().isEmpty())
        return Status.OK;

      /*
       * db.customer.update({orders:{$elemMatch:{"items.item_id":586526}}},
       * {$set:{"orders.$[o].items.$[i].item_quantity":77777777777}},
       * {arrayFilters:[{"o.items.item_id":586526},{"i.item_id":586526}]});
       * */
      String table = u.getUpdateTable();
      MongoCollection<Document> collection = database.getCollection(table);

      Map<String, String> attr_path = new HashMap<>(); //variable
      Document query = new Document(id_doc);

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
      System.err.println(e.toString());
      return Status.ERROR;
    }
  }
/*

  private Status read( ExecPlan.UpdateExecPlan u, Map<String, Object> values,
                       List<Document> result){
    String table = u.getClass_name();
    List<String> eas = u.getQueryEAs();
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
      Document projection = new Document("_id",INCLUDE);
      findIterable.projection(projection);
      Iterator<Document> dit = findIterable.iterator();
      while(dit.hasNext())
        result.add(dit.next());
      return !result.isEmpty()? Status.OK : Status.NOT_FOUND;
    } catch (Exception e) {
      System.err.println(e.toString());
      return Status.ERROR;
    }
  }

  private Status update(Object _id, ExecPlan.UpdateExecPlan u, Map<String,Object> values) {
    try {
      if(u.getAttrs().isEmpty())
        return Status.OK;
      *//*
      * db.customer.update({orders:{$elemMatch:{"items.item_id":586526}}},
      * {$set:{"orders.$[o].items.$[i].item_quantity":77777777777}},
      * {arrayFilters:[{"o.items.item_id":586526},{"i.item_id":586526}]});
      * *//*
      String table = u.getClass_name();
      MongoCollection<Document> collection = database.getCollection(table);

      Map<String, String> attr_path = new HashMap<>(); //variable
      Document query = new Document("_id", _id);

      List<Document> filters = new ArrayList<>();
      for(String ea: u.getQueryEAs()){
        if(values.get(ea) == null)
          values.put(ea, u.getRandomQueryValue(ea)); //should not come here
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
      for (String av: u.getAttrs()) {
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
        logger.error("Nothing updated for table " + u.getClass_name() );
        return Status.NOT_FOUND;
      }
      return Status.OK;
    } catch (Exception e) {
      System.err.println(e.toString());
      return Status.ERROR;
    }
  }*/

}
