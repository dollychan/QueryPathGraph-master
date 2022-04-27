package com.qpg.model.qpg;

import com.qpg.model.query.QueryStmt;
import com.qpg.model.uml.UMLClass;
import com.qpg.model.uml.UMLRelationship;

import java.util.*;
import java.util.jar.JarEntry;

public class ExecutionPlan {

  private Map<Object, Set<String>> execution_plan; // (*QueryStmt, *UMLClass, *UMLREl) -> a set of aggregation labels

  public ExecutionPlan(){
    execution_plan = new HashMap<>();
  }

  private void check(Object o){
    assert (o instanceof UMLClass || o instanceof UMLRelationship || o instanceof QueryStmt )
        : "Wrong object in Execution plan ";
  }

  public void setExecutionPlan(Object o, Set<String> labels){
    check(o);
    if(execution_plan.get(o) != null)
      execution_plan.get(o).addAll(labels);
    else
       execution_plan.put(o, labels);
  }

  public void addExecutionPlan(Object o, String al){
    check(o);
    if(execution_plan.get(o) == null)
      execution_plan.put(o, new HashSet<>());
    execution_plan.get(o).add(al);
  }

  private void changeExecutionPlan(Object o, String old_l, String new_l){
    check(o);
    if(execution_plan.get(o) == null)
      execution_plan.put(o, new HashSet<>());
    if(execution_plan.get(o).contains(old_l)) {
      execution_plan.get(o).remove(old_l);
      execution_plan.get(o).add(new_l);
    }
  }

  public void changeExecutionPlan(QPGNode node, String old_l, String new_l){
    Object o = node.getUmlClass();
    changeExecutionPlan(o, old_l, new_l);
  }
  public void changeExecutionPlan(QPGEdge edge, String old_l, String new_l){
    Object o = edge.getUmlRel();
    changeExecutionPlan(o, old_l, new_l);
  }

  public String print(){
    String str = "Execution Plan: \n";
    for(Object o: execution_plan.keySet()){
      if(o instanceof QueryStmt)
        str += ((QueryStmt) o).getQueryName() ;
      else if (o instanceof UMLClass)
        str += ((UMLClass)o).getName();
      else if(o instanceof UMLRelationship)
        str +=((UMLRelationship)o).getName();
      str += "->{" +execution_plan.get(o).toString()+"}\n";
    }
    return str;
  }

  public List<QueryStmt> getQueries(String agg_label){
    List<QueryStmt> queries = new ArrayList<>();
    for(Object o : execution_plan.keySet()){
      if(o instanceof QueryStmt)
      {
        if(execution_plan.get(o).contains(agg_label))
          queries.add((QueryStmt) o);
      }
    }
    return queries;
  }

  public void addQueryExecPlan(String current_agg, String new_agg){
    for(Object o : execution_plan.keySet()){
      if(o instanceof QueryStmt)
      {
        if(execution_plan.get(o).contains(current_agg))
          execution_plan.get(o).add(new_agg);
      }
    }
  }

  public boolean contains(Object o, String al) {
    check(o);
    return execution_plan.get(o).contains(al);
  }
}
