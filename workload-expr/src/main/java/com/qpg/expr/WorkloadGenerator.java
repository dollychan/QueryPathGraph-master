package com.qpg.expr;

import com.qpg.expr.execplan.ExecPlan;
import com.qpg.expr.workload.QPGWorkload;
import com.qpg.expr.workload.WorkloadCase;
import org.apache.log4j.Logger;

import java.util.*;

public class WorkloadGenerator {
  private static Logger logger = Logger.getLogger(WorkloadGenerator.class);

  private static WorkloadGenerator instance =null;
  private List<EachTest> workload_instance = null;
  private QPGWorkload workload_plan = null;

  public static WorkloadGenerator getInstance(){
    if(instance == null)
      instance = new WorkloadGenerator();
    return instance;
  }


  private void initWorkload(Properties properties, ExecPlan exec_plan) {
    if(workload_plan != null)
      return;
    String even_workload = properties.getProperty(QPGWorkloadConfig.WORKLOAD_QUERY_EVEN_PROPERTY);
    Map<String, Integer> wk_query_plan = new HashMap<>();
    Map<String, Integer> wk_update_plan = new HashMap<>();
    int even_query = 0;
    if (even_workload != null && (even_query = Integer.parseInt(even_workload)) != 0) {
      Iterator<String> iter = exec_plan.getQueries().keySet().iterator();
      while(iter.hasNext()){
        wk_query_plan.put(iter.next(), even_query);
      }
      iter = exec_plan.getUpdates().keySet().iterator();
      while (iter.hasNext()){
        wk_update_plan.put(iter.next(), even_query);
      }
    } else {
      assert properties.getProperty(QPGWorkloadConfig.WORKLOAD_SCALE) != null;
      double workload_scale = Double.parseDouble(properties.getProperty(QPGWorkloadConfig.WORKLOAD_SCALE));
      String query_workload = properties.getProperty(QPGWorkloadConfig.WORKLOAD_QUERY_PROPERTY);
      if(query_workload != null) {
        String[] query_num = query_workload.split(";");
        for (int i = 0; i < query_num.length; i++) {
          String[] q_n = query_num[i].split(":");
          assert q_n.length == 2;
          wk_query_plan.put(q_n[0], (int)(Double.parseDouble(q_n[1])*workload_scale));
        }
      }

      String update_workload = properties.getProperty(QPGWorkloadConfig.WORKLOAD_UPDATE_PROPERTY);
      if(update_workload != null) {
        String[] query_num = update_workload.split(";");
        for (int i = 0; i < query_num.length; i++) {
          String[] q_n = query_num[i].split(":");
          assert q_n.length == 2;
          wk_update_plan.put(q_n[0], (int)(Double.parseDouble(q_n[1])*workload_scale));
        }
      }
    }
    workload_plan = new QPGWorkload(wk_query_plan, wk_update_plan);
  }

  private List<EachTest> genWorkload(Properties properties, ExecPlan execPlan) {
    if (workload_instance != null)
      return workload_instance;

    initWorkload(properties, execPlan);
    workload_instance = new ArrayList<EachTest>();

    //gen query tests
    Iterator<String> query_iter = workload_plan.getQuery_workloads().keySet().iterator();
    while (query_iter.hasNext()) {
      String qname = query_iter.next();
      int qn = workload_plan.getQuery_workloads().get(qname);
      while (qn > 0) {
        ExecPlan.QueryExecPlan q = execPlan.getFirstQuery(qname);
        Map<String, Object> ea_values = q.genRandomQueryValues();
        workload_instance.add(new EachTest(true, qname, ea_values));
        qn--;
      }
    }

    //gen udate tests
    Iterator<String> update_iter = workload_plan.getUpdate_workloads().keySet().iterator();
    while(update_iter.hasNext()){
      String uname = update_iter.next();
      int un = workload_plan.getUpdate_workloads().get(uname);
      while(un > 0)
      {
        ExecPlan.UpdateExecPlan u = execPlan.getFirstUpdate(uname);
        workload_instance.add(new EachTest(false,uname,u.genRandomUpdateValues()));
        un--;
      }
    }
    return workload_instance;
  }

  private class EachTest{
    private boolean isQuery; // true: query; false: update
    private String test_name; //query name or update name in ExecPlan
    private Map<String, Object> attr_value; // simulate random values for cols needed

    private EachTest(boolean isQuery, String test_name, Map<String,Object> av){
      this.isQuery = isQuery;
      this.test_name = test_name;
      this.attr_value = av;
    }

    public boolean isQuery(){return isQuery;}
    public String getTest_name(){return test_name;}
    public Map<String, Object> getValues(){return attr_value;}
  }

  /*public void runWorkload(Properties properties, WorkloadCase workload_case){
    genWorkload(properties, workload_case.getExecPlan());
    int warmup_num = Integer.parseInt(properties.getProperty(QPGWorkloadConfig.WORKLOAD_WARM_UP_PROPERTY, "0"));
    int measure_num = Integer.parseInt(properties.getProperty(QPGWorkloadConfig.WORKLOAD_MEASURE_PROPERTY, "1"));
    for(EachTest t: workload_instance){
      logger.info("Begin test case of "+ t.test_name+ ":");
      for(int i =0; i < warmup_num; i++)
        workload_case.runTestCase(true, t.isQuery, t.test_name, t.attr_value);
      for(int i =0; i < measure_num; i++)
        workload_case.runTestCase(false, t.isQuery, t.test_name, t.attr_value);
    }
    workload_case.report();
  }*/

  public void runWorkload(Properties properties, WorkloadCase workload_case, boolean isWarmUp){
    genWorkload(properties, workload_case.getExecPlan());
    for(EachTest t: workload_instance){
      logger.info("Begin test case of "+ t.test_name+ ":");
      workload_case.runTestCase(isWarmUp, t.isQuery, t.test_name, t.attr_value);
    }
  }

}
