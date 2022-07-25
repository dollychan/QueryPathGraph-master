package com.qpg.model.qpg;

import com.qpg.core.QPGGenerator;
import com.qpg.model.uml.UMLAttribute;
import com.qpg.model.uml.UMLRelationship;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QPGEdge {
  private String edge_name;
  private QPGNode startNode;
  private QPGNode endNode;

  private Set<String> agg_labels;
  private UMLRelationship umlRel;
  private SASpecification sa_labels;

  public void addEAattrs(String agg_label, String attr_name){
    sa_labels.addEAattrs(agg_label, umlRel.getAttr(attr_name));
  }
  public void addIAattrs(String agg_label, String attr_name){
    sa_labels.addIAattrs(agg_label, umlRel.getAttr(attr_name));
  }
  public void addOAattrs(String agg_label, String attr_name){
    sa_labels.addOAattrs(agg_label, umlRel.getAttr(attr_name));
  }
  public void addPAattrs(String agg_label, String attr_name){
    sa_labels.addPAattrs(agg_label, umlRel.getAttr(attr_name));
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


public String getEdgeName(){return edge_name;}
  public QPGNode getStartNode(){return startNode;}
  public QPGNode getEndNode(){return endNode;}
  public String getRelName(){
    return umlRel.getName();
  }
  public Set<String> getAggLabels(){return  agg_labels;}

  public QPGEdge(String name, QPGNode src, QPGNode tgt, String aggre_label, UMLRelationship rel){
    this.edge_name = name;
    this.startNode = src;
    this.endNode = tgt;
    agg_labels = new HashSet<>();
    agg_labels.add(aggre_label);
    assert rel != null;
    this.umlRel = rel;
    sa_labels = new SASpecification();
  }
 public UMLRelationship getUmlRel(){return umlRel;}
  public void addAggLabel(String al){
    this.agg_labels.add(al);}
  public boolean isInAgg(String al){return agg_labels.contains(al);}
  public boolean isInAgg(List<String> als){
    for(String al:als) {
      if(agg_labels.contains(al)) return true;
    }
    return false;
  }
  public int getCard(QPGNode node){
    return umlRel.getCardRatio(node.getUmlClass().getName());
  }

  public void setExecutionPlan(){
    Set<String> exec_plan = new HashSet<>();exec_plan.addAll(agg_labels);
    QPGGenerator.executionPlan.setExecutionPlan(umlRel, exec_plan);
  }

  public void changeAggLabel(String old_l, String new_l){
    assert agg_labels.contains(old_l);
    agg_labels.remove(old_l);
    agg_labels.add(new_l);
    sa_labels.changeAggLabel(old_l,new_l);
  }

  public String printEdge(){
    String str = "QPG edge: " + startNode.getNodeName() + "->" + endNode.getNodeName()
        + "("+umlRel.getName()+") {";
    for(String al: agg_labels)
      str += al+", ";
    str += "}";
    str += sa_labels.print();
    return str+"\n";
  }

}
