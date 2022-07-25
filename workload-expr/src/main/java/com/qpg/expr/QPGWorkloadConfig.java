package com.qpg.expr;


public class QPGWorkloadConfig {
  public static final String TEST_NOSQL_CASSANDRA = "test.cassandra";
  public static final String TEST_NOSQL_MONGO = "test.mongodb";
  public static final String TEST_NOSQL_MONGO_AGGREGATE = "test.mongodb.aggregate";
  public static  final String DB_HOSTS_PROPERTY = "db.hosts";
  public static  final String DB_PORT_PROPERTY = "db.port";
  public static  final String DB_DATABASE_PROPERTY = "db.database";
  public static final String EXEC_PLAN_DIR_PROPERTY = "exec_plan.dir";
  protected static final String WORKLOAD_QUERY_PROPERTY = "workload.query";
  protected static final String WORKLOAD_QUERY_EVEN_PROPERTY = "workload.query.even";
  protected static final String WORKLOAD_UPDATE_PROPERTY = "workload.update";
  protected static final String WORKLOAD_SCALE="workload.scale";
  protected static final String WORKLOAD_WARM_UP_PROPERTY = "warmup.num";
  protected static final String WORKLOAD_MEASURE_PROPERTY = "measure.time";

}
