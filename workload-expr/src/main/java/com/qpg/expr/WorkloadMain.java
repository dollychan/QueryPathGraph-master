package com.qpg.expr;

import com.qpg.expr.workload.WorkloadCase;
import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WorkloadMain {

  private static Logger logger = Logger.getLogger(WorkloadMain.class);

  public static void main(String[] args) {
    try {
      String config_file;
      if (args.length > 0)
        config_file = args[0];
      else config_file = "exec_workspace/OnlineStore_DOC_Lima/workload.config";

      InputStream in = new BufferedInputStream(new FileInputStream(new File(config_file)));
      Properties properties = new Properties();
      properties.load(in);

      String db_databases = properties.getProperty(QPGWorkloadConfig.DB_DATABASE_PROPERTY);
      String[] db_dbs = db_databases.split(";");
      String execplan_dirs = properties.getProperty(QPGWorkloadConfig.EXEC_PLAN_DIR_PROPERTY);
      String[] execplan = execplan_dirs.split(";");
      assert db_dbs.length == execplan.length;

      List<WorkloadCase> cases = new ArrayList<>();
      for (int i = 0; i < db_dbs.length; i++) {
        Properties p = new Properties();
        p.put(QPGWorkloadConfig.TEST_NOSQL_MONGO, properties.getProperty(QPGWorkloadConfig.TEST_NOSQL_MONGO, "0"));
        p.put(QPGWorkloadConfig.TEST_NOSQL_MONGO_AGGREGATE, properties.getProperty(QPGWorkloadConfig.TEST_NOSQL_MONGO_AGGREGATE, "0"));
        p.put(QPGWorkloadConfig.TEST_NOSQL_CASSANDRA, properties.getProperty(QPGWorkloadConfig.TEST_NOSQL_CASSANDRA, "0"));
        p.put(QPGWorkloadConfig.DB_HOSTS_PROPERTY, properties.getProperty(QPGWorkloadConfig.DB_HOSTS_PROPERTY));
        p.put(QPGWorkloadConfig.DB_PORT_PROPERTY, properties.getProperty(QPGWorkloadConfig.DB_PORT_PROPERTY));
        p.put(QPGWorkloadConfig.DB_DATABASE_PROPERTY, db_dbs[i]);
        p.put(QPGWorkloadConfig.EXEC_PLAN_DIR_PROPERTY, execplan[i]);
        p.put(QPGWorkloadConfig.WORKLOAD_WARM_UP_PROPERTY,
            properties.getProperty(QPGWorkloadConfig.WORKLOAD_WARM_UP_PROPERTY, "10"));
        WorkloadCase workload = new WorkloadCase(p);
        cases.add(workload);
      }
      logger.error("======================= Start Test " + config_file + " =======================");
      int warmup_num = Integer.parseInt(properties.getProperty(QPGWorkloadConfig.WORKLOAD_WARM_UP_PROPERTY, "0"));
      int measure_num = Integer.parseInt(properties.getProperty(QPGWorkloadConfig.WORKLOAD_MEASURE_PROPERTY, "1"));
      logger.error("start warm up: " );
      Long st = System.currentTimeMillis();
      for(int i =0; i < warmup_num; i++) {
        for (WorkloadCase workloadCase : cases) {
          WorkloadGenerator.getInstance().runWorkload(properties, workloadCase, true);
        }
      }
      logger.error("End "+warmup_num +" warm ups" + " time total " + (System.currentTimeMillis() - st) + "ms.");

      for (WorkloadCase workloadCase : cases) {
        logger.error("Start test database: " + workloadCase.getCaseLabel() );
        st = System.currentTimeMillis();
        for(int i =0; i < measure_num; i++) {
          WorkloadGenerator.getInstance().runWorkload(properties, workloadCase, false);
        }
        workloadCase.report();
        logger.error("End test database" + workloadCase.getCaseLabel() + " time total " + (System.currentTimeMillis() - st) + "ms.");
      }
      logger.error("======================= End Test " + config_file + " =======================");
      for (WorkloadCase workloadCase : cases) {
        workloadCase.close();
      }
    }catch (Exception e) {
      e.printStackTrace();
      logger.error("Exception: ", e);
    }
  }
}
