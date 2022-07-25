package com.qpg.cost_model;

import com.qpg.QPGRunner;
import com.qpg.model.qpg.QPGEdge;
import com.qpg.model.qpg.QPGNode;
import com.qpg.model.query.QueryStmt;

import java.util.HashMap;
import java.util.Map;

public class CostModel {
 // private Map<Object, Double> workload_freq;// (*QueryStmt, *UMLClass, *UMLREl) -> freq
  private Map<Object, Map<String, Double>> write_cost; //(QPGNode, QPGEdge) -> (agg_label- > value)
  private Map<Object, Map<String, Double>> read_cost; //(QueryStmt, QPGNode) -> (agg_label- > value)

  public CostModel(){
    write_cost = new HashMap<>();
    read_cost = new HashMap<>();
  }

  public void setWriteCost(Object o, String agg_label, double v){
    if(write_cost.get(o) == null)
      write_cost.put(o, new HashMap<>());
    write_cost.get(o).put(agg_label,v);
  }

  public double getWriteCost(Object o, String agg_label){
    assert write_cost.get(o) != null;
    if(write_cost.get(o)==null){
      return 0;
    }
    if(write_cost.get(o).get(agg_label) == null)
      return 0;
    else return write_cost.get(o).get(agg_label);
  }

  public void setReadCost(Object o, String agg_label, double v){
    if(read_cost.get(o) == null)
      read_cost.put(o, new HashMap<>());
    read_cost.get(o).put(agg_label,v);
  }

  public double getReadCost(Object o, String agg_label){
    assert read_cost.get(o) != null;
    if(read_cost.get(o) == null)
      return 0;
    if(read_cost.get(o).get(agg_label) == null)
      return 0;
    else return read_cost.get(o).get(agg_label);
  }

  public double totalCost(){
    double cost = 0.0;
    for(Object o: write_cost.keySet()){
      double cw = 0.0;
      for(String al: write_cost.get(o).keySet()){
        cw += write_cost.get(o).get(al);
      }
      if(o instanceof QPGEdge)
        cost += cw * QPGRunner.input.getWorkloadFreq(((QPGEdge) o).getUmlRel());
      else if(o instanceof QPGNode)
        cost += cw * QPGRunner.input.getWorkloadFreq(((QPGNode) o).getUmlClass());
    }

    for(Object o: read_cost.keySet()){
      if(!(o instanceof QueryStmt))
        continue;
      double cr = 0.0;
      for(String al: read_cost.get(o).keySet()){
        cr += read_cost.get(o).get(al);
      }
      cost += cr * QPGRunner.input.getWorkloadFreq(o);
    }
    return  cost;
  }

  public String print(){
    String str = "Write cost:\n";
    for(Object o: write_cost.keySet()){
      if(o instanceof QPGEdge)
        str += ((QPGEdge) o).getUmlRel().getName() +":{";
      else if(o instanceof QPGNode)
       str += ((QPGNode) o).getNodeName() +":{";
      for(String al: write_cost.get(o).keySet()){
        str += "("+al+","+write_cost.get(o).get(al)+"),";
      }
      str += "}\n";
    }

    str+="Query cost:\n";
    for(Object o: read_cost.keySet()){
      if((o instanceof QueryStmt))
        str += ((QueryStmt) o).getQueryName() +":{";
      if(o instanceof QPGNode)
        str += ((QPGNode) o).getNodeName() +":{";
      for(String al: read_cost.get(o).keySet()){
        str += "("+al+","+read_cost.get(o).get(al)+"),";
      }
      str += "}\n";
    }

    str += "total cost: "+ totalCost() +"\n";
    return str;
  }

  public void removeWriteCost(Object o, String new_agg) {
    write_cost.get(o).remove(new_agg);
  }

  public void setQueryReadCost(QPGNode part_node, String root_agg, String new_agg) {
    for(Object o: read_cost.keySet()){
      if(!(o instanceof QueryStmt))
        continue;
      if(read_cost.get(o).get(root_agg) == null)
        continue;
      read_cost.get(o).put(new_agg, getReadCost(part_node ,root_agg));
    }
  }
}
