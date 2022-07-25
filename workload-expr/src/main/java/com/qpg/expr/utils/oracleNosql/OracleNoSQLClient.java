package com.qpg.expr.utils.oracleNosql;

import com.qpg.expr.execplan.ExecPlan;
import com.qpg.expr.utils.DBClient;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import org.apache.log4j.Logger;

import java.util.Map;

public class OracleNoSQLClient extends DBClient {
  private static Logger logger = Logger.getLogger(OracleNoSQLClient.class);

  private KVStore kvStore;
  @Override
  public void init() {
    String[] hhosts = {"n1.example.org:5088", "n2.example.org:4129"};
    KVStoreConfig kconfig = new KVStoreConfig("exampleStore", hhosts);
     kvStore = KVStoreFactory.getStore(kconfig);

  }

  @Override
  public void cleanup() {

  }

  @Override
  public void runEachQueryPlan(String test_name, Map<String, Object> values, ExecPlan execPlan) {

  }

  @Override
  public void runEachUpdatePlan(String test_name, Map<String, Object> values, ExecPlan execPlan) {

  }
}
