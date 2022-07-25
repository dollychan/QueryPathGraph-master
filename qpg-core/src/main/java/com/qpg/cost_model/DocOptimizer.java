package com.qpg.cost_model;

import com.qpg.core.QPGGenerator;
import com.qpg.model.qpg.QPGNode;

import java.util.*;

public class DocOptimizer extends Optimizer {
  private List<CostChange> node_costchange;


  @Override
  public void optimize(String al) {
    System.out.println("Start optimization for aggregation "+ al );
    paritionTree(al, al);
  }

  private void paritionTree(String root_agg, String current_agg ){
    updateNodeCostChange(root_agg, current_agg);
    QPGNode node = getNextNode();
    if(node != null){
      NormalizePattern np = new NormalizePattern(root_agg,current_agg,node,node.getOutEdges(),true);
      String new_agg = np.normalize();
      paritionTree(root_agg,new_agg);
      paritionTree(root_agg,current_agg);
    }
  }

  private void updateNodeCostChange(String root_ag,String al) {
    node_costchange = new ArrayList<>();
    for(String nn: QPGGenerator.graph.getNodes().keySet()){
      QPGNode node = QPGGenerator.graph.getNode(nn);
      if(node.isStoredInAgg(al)) {
        double cost_change = calSubTreeWriteCostChange(node, al)
            + CostCalculator.calQueryCostChange(node, root_ag);
        node_costchange.add(new CostChange(node, cost_change));
        System.out.println(node.getNodeName() +" cost change :" +cost_change);
      }}
  }

  private  double calSubTreeWriteCostChange(QPGNode node, String agg_label){
    return CostCalculator.calSubTreeWriteCost(node,agg_label)
        *(1/ CostCalculator.calWeightToRoot(node, agg_label) - 1);
  }
  private QPGNode getNextNode(){
    Collections.sort(node_costchange);
    if(!node_costchange.isEmpty() && node_costchange.get(0).getCostChange() < 0)
      return (QPGNode) node_costchange.get(0).getObject();
    else return null;
  }

  public List< List<String>> merge(){
    Map<QPGNode, List<String>> ap_aggs = new HashMap<>();
    for(String al: QPGGenerator.agg_ap.keySet()){
      QPGNode ap = QPGGenerator.agg_ap.get(al);
      if(ap_aggs.get(ap) == null)
        ap_aggs.put(ap, new ArrayList<>());
      ap_aggs.get(ap).add(al);
    }
    List<List<String>> agg_groups = new ArrayList<>();
    for(QPGNode n: ap_aggs.keySet()){
      agg_groups.add(ap_aggs.get(n));
    }
   return agg_groups;
  }

}
