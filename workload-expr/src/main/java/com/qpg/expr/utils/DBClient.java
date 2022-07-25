package com.qpg.expr.utils;

import com.qpg.expr.execplan.ExecPlan;
import org.apache.log4j.Logger;

import java.util.*;

public abstract class DBClient {
  private static Logger logger = Logger.getLogger(DBClient.class);
  //private HashMap<String,  Long[]> timeCal = new HashMap<>(); //long[0] test_num, [1] total exec time, [2] total units fetched
  public abstract void init() ;
  public abstract void cleanup();

  public void runWorkload(boolean isQuery, String test_name, Map<String, Object> values,ExecPlan execPlan){
    if(isQuery)
      runEachQueryPlan(test_name, values, execPlan);
    else
      runEachUpdatePlan(test_name, values, execPlan);
  }

  public abstract void runEachQueryPlan(String test_name,
                                        Map<String, Object> values, ExecPlan execPlan);

  public abstract void runEachUpdatePlan(String test_name, Map<String, Object> values,ExecPlan execPlan);

  /*public void profileTestTime(String qname, long time){
    if(timeCal.get(qname) == null)
      timeCal.put(qname,new Long[]{1L, time, 0L});
    else {
      timeCal.get(qname)[0]++;
      timeCal.get(qname)[1] += time;
    }

  }

  public void profileTestResult(String qname, long result_num){
    if(timeCal.get(qname) == null)
      timeCal.put(qname,new Long[]{0L, 0L, result_num});
    else {
      timeCal.get(qname)[2] += result_num;
    }*/

}
