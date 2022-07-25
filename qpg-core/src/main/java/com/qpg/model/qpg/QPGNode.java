package com.qpg.model.qpg;

import com.qpg.core.QPGGenerator;
import com.qpg.model.uml.UMLAttribute;
import com.qpg.model.uml.UMLClass;
import org.apache.log4j.Logger;

import java.util.*;

public class QPGNode {
  private static Logger logger = Logger.getLogger(QPGNode.class);
  private String class_alias; // for loop cases, one class appears more than once in one query pattern
  private UMLClass umlClass;
  private SASpecification sa_labels;

  private List<QPGEdge> out_edges;
  private List<QPGEdge> in_edges;

  //private Set<String> execution_plan; // shared with that used in ExecutionPlan

  public QPGNode(String class_alias, UMLClass umlclass){
    this.class_alias = class_alias;
    this.umlClass = umlclass;
    out_edges = new ArrayList<>();
    in_edges = new ArrayList<>();
    sa_labels = new SASpecification();
  }

  //non-primary key attribute is used in the aggregation al
  public boolean isStoredInAgg(String al){
    return  QPGGenerator.executionPlan.contains(umlClass, al);
  }

  //any attribute is used in the aggregation al
  public boolean involvedInAgg(String al){
    return sa_labels.isUsedInAgg(al);
  }
  public UMLClass getUmlClass(){return umlClass;}
  public QPGEdge getOutEdge(String rel_name, QPGNode endNode){
    for(QPGEdge e: out_edges){
      if(e.getEndNode() == endNode && e.getRelName().equalsIgnoreCase(rel_name))
        return e;
    }
    return null;
  }
  public QPGEdge getInEdge(String rel_name, QPGNode startNode){
    for(QPGEdge e: in_edges){
      if(e.getStartNode() == startNode && e.getRelName().equalsIgnoreCase(rel_name))
        return e;
    }
    return null;
  }
  public List<QPGEdge> getOutEdges(){return out_edges;}
  public List<QPGEdge> getInEdges(){return in_edges;}
  public void addEdge(QPGEdge edge){
    if(edge.getStartNode() == this)
      out_edges.add(edge);
    else if(edge.getEndNode() == this)
      in_edges.add(edge);
    else logger.error("Error when adding edges to wrong nodes!");
  }


  public String getNodeName(){
    return this.class_alias;
  }

  public void addEAattrs(String agg_label, String attr_name){
    sa_labels.addEAattrs(agg_label, umlClass.getAttr(attr_name));
  }
  public void addIAattrs(String agg_label, String attr_name){
    sa_labels.addIAattrs(agg_label, umlClass.getAttr(attr_name));
  }
  public void addOAattrs(String agg_label, String attr_name){
    sa_labels.addOAattrs(agg_label, umlClass.getAttr(attr_name));
  }
  public void addPAattrs(String agg_label, String attr_name){
    sa_labels.addPAattrs(agg_label, umlClass.getAttr(attr_name));
  }

  public void setExecutionPlan(){
    Set<String> execution_plan = sa_labels.getExecutionPlan();
    QPGGenerator.executionPlan.setExecutionPlan(umlClass, execution_plan);
  }

  public Set<UMLAttribute> getEAattrs(String agg_label){
    return sa_labels.getEAattrs(agg_label);
  }
  public Set<UMLAttribute> getIAattrs(String agg_label){
    return sa_labels.getIAattrs(agg_label);}
  public Set<UMLAttribute> getOAattrs(String agg_label){
    return sa_labels.getOAattrs(agg_label);}
  public Set<UMLAttribute> getPAattrs(String agg_label){
    return sa_labels.getPAattrs(agg_label);}

  public void addPKtoEA(String agg_label){
    sa_labels.addAttrsToEA(agg_label,umlClass.getPks());
  }
  public void addPKtoPA(String agg_label){
    sa_labels.addAttrsToPA(agg_label, umlClass.getPks());
  }
  public void changeAggLabel(String old_l, String new_l){
    sa_labels.changeAggLabel(old_l,new_l);
  }

  public String printNode(){
    String str = "QPG node: "+ class_alias + " of class "+ umlClass.getName() +"[ ";
    str += sa_labels.print();
    return str+"\n";
  }

}
