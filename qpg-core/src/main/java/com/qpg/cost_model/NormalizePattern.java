package com.qpg.cost_model;

import com.qpg.core.QPGGenerator;
import com.qpg.model.qpg.QPGEdge;
import com.qpg.model.qpg.QPGNode;
import org.apache.log4j.Logger;

import java.util.List;

public class NormalizePattern {
  private static Logger logger = Logger.getLogger(NormalizePattern.class);
  private String root_agg;
  private String current_agg;
  private QPGNode subtree_root;
  private List<QPGEdge> edges;
  private boolean root_normalized;

  private String new_agg;

  public NormalizePattern(String root_agg, String current_agg,
                          QPGNode subtree_root,
                           List<QPGEdge> edges,
                           boolean root_normalized){
    this.root_agg = root_agg;
    this.current_agg = current_agg;
    this.subtree_root = subtree_root;
    assert subtree_root.isStoredInAgg(current_agg);
    this.edges = edges;
    if(edges == null || edges.isEmpty())
      root_normalized = true;
    this.root_normalized = root_normalized;
  }

  public String normalize(){
    logger.info("Normalize " + subtree_root.getNodeName() + " from " + current_agg+ ".");

    new_agg = getNewSubAgg();
    if(root_normalized){
      subtree_root.changeAggLabel(current_agg,new_agg);
      subtree_root.addPKtoPA(current_agg);
      QPGGenerator.executionPlan.changeExecutionPlan(subtree_root, current_agg,new_agg);
    }
    subtree_root.addPKtoEA(new_agg);

    QPGGenerator.agg_ap.put(new_agg, subtree_root);

    if(edges != null) {
      for (QPGEdge edge : edges) {
        if (!edge.isInAgg(current_agg))
          continue;
        edge.changeAggLabel(current_agg, new_agg);
        QPGGenerator.executionPlan.changeExecutionPlan(edge, current_agg, new_agg);
        normalizeSubTree(edge.getEndNode());
      }
    }
    updateQueryExecPlanCost();
    updateCostModel();
    return new_agg;
  }

  private void normalizeSubTree(QPGNode node){
    node.changeAggLabel(current_agg,new_agg);
    QPGGenerator.executionPlan.changeExecutionPlan(node, current_agg, new_agg);
    for(QPGEdge edge : node.getOutEdges()){
      if(!edge.isInAgg(current_agg))
        continue;
      edge.changeAggLabel(current_agg,new_agg);
      QPGGenerator.executionPlan.changeExecutionPlan(edge, current_agg, new_agg);
      normalizeSubTree(edge.getEndNode());
    }
  }

  private void updateQueryExecPlanCost(){
    QPGGenerator.executionPlan.addQueryExecPlan(current_agg,new_agg);
    QPGGenerator.costModel.setQueryReadCost(subtree_root, root_agg, new_agg);
  }

  private void updateCostModel(){
    for(String nn: QPGGenerator.graph.getNodes().keySet()){
      if(QPGGenerator.graph.getNode(nn).isStoredInAgg(new_agg)) {
        //set cost in new_agg
          QPGGenerator.costModel.setWriteCost(QPGGenerator.graph.getNode(nn), new_agg,
              CostCalculator.calCw(QPGGenerator.graph.getNode(nn), new_agg));
          //remove that in current_agg
          QPGGenerator.costModel.removeWriteCost(QPGGenerator.graph.getNode(nn), current_agg);
      }
      else if(QPGGenerator.graph.getNode(nn).isStoredInAgg(current_agg)) {
        //update cost in the current_agg
        QPGGenerator.costModel.setWriteCost(QPGGenerator.graph.getNode(nn), current_agg,
            CostCalculator.calCw(QPGGenerator.graph.getNode(nn), current_agg));
      }
    }
    for(QPGEdge edge: QPGGenerator.graph.getEdges()){
      if (edge.isInAgg(new_agg)) {
        QPGGenerator.costModel.setWriteCost(edge, new_agg, CostCalculator.calCw(edge, new_agg));
        QPGGenerator.costModel.removeWriteCost(edge,current_agg);
      }else if (edge.isInAgg(current_agg)) {
        QPGGenerator.costModel.setWriteCost(edge, current_agg, CostCalculator.calCw(edge, current_agg));
      }
    }


  }

  private String getNewSubAgg(){
    if(QPGGenerator.root_agg_new_aggs.get(root_agg) == null)
      logger.error("Init root_agg_new_agg error: "+ root_agg );
    String new_al = root_agg+"_"+(QPGGenerator.root_agg_new_aggs.get(root_agg).size()+1);
    QPGGenerator.root_agg_new_aggs.get(root_agg).add(new_al);
    return new_al;
  }
}
