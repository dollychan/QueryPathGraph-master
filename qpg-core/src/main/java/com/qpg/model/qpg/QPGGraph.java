package com.qpg.model.qpg;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QPGGraph {
  private static Logger logger = Logger.getLogger(QPGGraph.class);
  private Map<String, QPGNode> nodes; // (nodeName = class_name) -> QPGNode
  private List<QPGEdge> edges;

  public QPGGraph(){
    nodes = new HashMap<>();
    edges = new ArrayList<>();
  }

  public Map<String, QPGNode> getNodes(){return nodes;}
  public List<QPGEdge> getEdges(){return edges;}
  public boolean isExists(String class_name){return nodes.get(class_name) != null; }
  public void addNode(QPGNode node){
    this.nodes.put(node.getNodeName(), node);
  }
  public void addEdge(QPGEdge edge){ edges.add(edge);}
  public QPGNode getNode(String class_name){
    if(nodes.get(class_name) == null)
      logger.error("No node "+ class_name + " in QPG!");
    return nodes.get(class_name);}
  public QPGEdge getEdge(String name){
    for(QPGEdge e: edges) {
      if(e.getEdgeName().equalsIgnoreCase(name))
        return e;
    }
    logger.error("No edge "+ name + " in QPG!") ;
    return null;
  }

  public void initExecutionPlan(){
    for(String cn: nodes.keySet()){
      nodes.get(cn).setExecutionPlan();
    }
    for(QPGEdge edge: edges){
      edge.setExecutionPlan();
    }
  }

  public String printGraph(){
    String str ="";
    for(String nn: nodes.keySet())
      str += nodes.get(nn).printNode();
    for(QPGEdge edge: edges)
      str += edge.printEdge();
    return str;
  }
}
