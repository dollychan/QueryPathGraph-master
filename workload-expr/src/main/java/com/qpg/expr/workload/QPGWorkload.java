package com.qpg.expr.workload;

import java.util.Map;

public class QPGWorkload {
  private Map<String, Integer> query_workloads; // reference to ExecPlan; update command -> number of commands
  private Map<String, Integer> update_workloads; // reference to ExecPlan; update command -> number of commands


  public QPGWorkload(Map<String,Integer> query_workloads,Map<String,Integer> update_workloads){
    this.query_workloads = query_workloads;
    this.update_workloads = update_workloads;
  }

  public Map<String, Integer> getQuery_workloads(){return query_workloads;}
  public Map<String, Integer> getUpdate_workloads(){return update_workloads;}
}
