package com.qpg.expr.workload;

import com.qpg.expr.QPGWorkloadConfig;
import com.qpg.expr.execplan.ExecPlan;
import com.qpg.expr.execplan.QPGExecPlanParser;
import com.qpg.expr.utils.DBClient;
import com.qpg.expr.utils.cassandra.CassandraClient;
import com.qpg.expr.utils.mongodb.MongoDBAggregateClient;
import com.qpg.expr.utils.mongodb.MongoDBClient;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WorkloadCase {
  private static Logger logger = Logger.getLogger(WorkloadCase.class);

  private String case_label;
  private DBClient client = null;
  private ExecPlan exec_plan = null;
  private Properties properties;
  private Map<String,  Long[]> timeCal = new HashMap<>();

  public WorkloadCase(Properties p){
    properties = p;
    if(!properties.getProperty(QPGWorkloadConfig.TEST_NOSQL_CASSANDRA) .equalsIgnoreCase("0"))
      client =  new CassandraClient(properties);
    if(!properties.getProperty(QPGWorkloadConfig.TEST_NOSQL_MONGO)  .equalsIgnoreCase("0"))
      client = new MongoDBClient(properties);
    if(!properties.getProperty(QPGWorkloadConfig.TEST_NOSQL_MONGO_AGGREGATE)  .equalsIgnoreCase("0"))
      client = new MongoDBAggregateClient(properties);
    case_label = p.getProperty(QPGWorkloadConfig.DB_DATABASE_PROPERTY)
        +"_"+properties.getProperty(QPGWorkloadConfig.EXEC_PLAN_DIR_PROPERTY);
  }

  public String getCaseLabel(){return case_label;}

  private void initExecPlan(){
    try {
      String file = properties.getProperty(QPGWorkloadConfig.EXEC_PLAN_DIR_PROPERTY);
      logger.info("start init exec_pan "+ file);
      exec_plan = QPGExecPlanParser.run(file);
      logger.info("Succeed init exec_pan "+ file);
    }catch (Exception e){logger.error(e.getMessage());}
  }

  public ExecPlan getExecPlan(){
    if(exec_plan == null)
      initExecPlan();
    return exec_plan;
  }

  public void runTestCase(boolean iswarmUp, boolean isQuery, String test_name, Map<String, Object> values){
    Long st = System.currentTimeMillis();
    client.runWorkload(isQuery, test_name, values, exec_plan);
    if(!iswarmUp)
      profileTestTime(test_name, (System.currentTimeMillis() - st));
  }

  public void close() {
    client.cleanup();
  }

  private void profileTestTime(String qname, long time){
    if(timeCal.get(qname) == null)
      timeCal.put(qname,new Long[]{1L, time});
    else {
      timeCal.get(qname)[0]++;
      timeCal.get(qname)[1] += time;
    }
  }

  public void report(){
    for(String test: timeCal.keySet()){
      logger.error("Total " + timeCal.get(test)[0]
          + " tests of " + test +" takes "
          +timeCal.get(test)[1] + "ms.");
    }
  }
}
