package com.qpg.model.qpg;

import com.qpg.core.DatabaseGenerator;
import com.qpg.core.QPGGenerator;
import com.qpg.model.query.QueryStmt;
import com.qpg.model.uml.UMLAttribute;
import com.qpg.model.uml.UMLClass;
import com.qpg.model.uml.UMLRelationship;

import java.util.*;

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

  public String printNoSQLPlan(){
    String str = "Execution Plan on NoSQL schemas: \n";
    for(Object o: execution_plan.keySet()){
      if(o instanceof QueryStmt)
        str += "EXEC QUERY "+((QueryStmt) o).getQueryName() ;
      else if (o instanceof UMLClass)
        str += "EXEC UPDATE "+((UMLClass)o).getName();
      else if(o instanceof UMLRelationship)
        str += "EXEC UPDATE "+ ((UMLRelationship)o).getName();
      str += " {";
      Set<String> nosqlDU = new HashSet<>();
      int indent = 0;
      for(String al: execution_plan.get(o)){
        String du = DatabaseGenerator.agg_nosql.get(al);
        if(nosqlDU.contains(du))
          continue;
        nosqlDU.add(du);
        indent++;
        if(indent >1)
          str += ",";
        if(o instanceof QueryStmt){
          str+="\n";
          str += du + getExecutionPlan(al) ;
        }else
          str += du;
      }
      str+="}\n";
    }
    return str;

  }

  private String getExecutionPlan(String al){
    String[] stmts = new String[]{"","","",""};
    QPGNode root = QPGGenerator.agg_ap.get(al);
    getExecutionPlan(al, root, null, stmts);
    if(stmts[0].length() -1 >=0)
      stmts[0] = stmts[0].substring(0, stmts[0].length()-1);
    if(stmts[1].length()-1 >=0)
      stmts[1] = stmts[1].substring(0, stmts[1].length()-1);
    if(stmts[2].length()-1 >=0)
      stmts[2] = stmts[2].substring(0, stmts[2].length()-1);
    if(stmts[3].length()-1 >=0)
      stmts[3] = stmts[3].substring(0, stmts[3].length()-1);
   return "["+ stmts[0]+"][" +stmts[1]+"][" +stmts[2]+"]["+stmts[3]+"]";
}

  private void getExecutionPlan(String al, QPGNode node, QPGEdge in_edge, String[] stmts){
    String cn = node.getUmlClass().getName().toLowerCase(Locale.ROOT);
    for(UMLAttribute a: node.getEAattrs(al))
      stmts[0] += cn+"_"+a.getName() +",";
    for(UMLAttribute a: node.getIAattrs(al))
      stmts[1] += cn+"_"+a.getName() +",";
    for(UMLAttribute a: node.getOAattrs(al))
      stmts[2] += cn +"_"+a.getName() +",";
    for(UMLAttribute a: node.getPAattrs(al))
      stmts[3] += cn +"_"+a.getName() +",";
    if(in_edge != null)
    {
      String rn = in_edge.getEdgeName().toLowerCase(Locale.ROOT);
      for(UMLAttribute a: in_edge.getEAattrs(al))
        stmts[0] += rn +"_"+a.getName() +",";
      for(UMLAttribute a: in_edge.getIAattrs(al))
        stmts[1] += rn +"_"+a.getName() +",";
      for(UMLAttribute a: in_edge.getOAattrs(al))
        stmts[2] += rn +"_"+a.getName() +",";
      for(UMLAttribute a: in_edge.getPAattrs(al))
        stmts[3] += rn+"_"+a.getName() +",";
    }

    for(QPGEdge edge: node.getOutEdges()){
      if(edge.isInAgg(al)){
        getExecutionPlan(al, edge.getEndNode(), edge,stmts);
      }
    }
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
