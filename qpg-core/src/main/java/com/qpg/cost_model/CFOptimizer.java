package com.qpg.cost_model;

import com.qpg.core.QPGGenerator;
import com.qpg.model.qpg.AggregationTree;
import com.qpg.model.qpg.QPGEdge;
import com.qpg.model.qpg.QPGNode;

import java.util.*;


public class CFOptimizer extends Optimizer {
  private List<CostChange> edge_costchange;
  private List<CostChange> node_costchange;

  @Override
  public void optimize(String al) {
    processEdges(al, al);

    List<NormalizePattern> nps = new ArrayList<>();
    processNode(al, al, nps);
    for(String new_agg: QPGGenerator.root_agg_new_aggs.get(al)){
      processNode(al, new_agg, nps);
    }
    for(NormalizePattern np: nps)
      np.normalize();
  }

  private void processEdges(String root_agg, String current_agg){
    updateEdgeCostChange(root_agg,current_agg);
    QPGEdge edge = getNextEdge(current_agg);
    if(edge != null){
      List<QPGEdge> el = new ArrayList<>();el.add(edge);
      NormalizePattern np = new NormalizePattern(root_agg,current_agg,
          edge.getStartNode(),el,false);
      String new_agg = np.normalize();
      processEdges(root_agg, current_agg);
      processEdges(root_agg, new_agg);
    }
  }

  private void processNode(String root_agg, String current_agg, List<NormalizePattern> nps){
      updateNodeCostChange(root_agg, current_agg);
      QPGNode node = null;
      while((node = getNextNode(current_agg)) != null){
        NormalizePattern np = new NormalizePattern(root_agg,current_agg,
            node,null,true);
        nps.add(np);
      }
  }

  private void updateEdgeCostChange(String root_ag,String al) {
    edge_costchange = new ArrayList<>();
    for(QPGEdge edge: QPGGenerator.graph.getEdges()){
      if (edge.isInAgg(al)) {
        double cost_change = calCostChange(edge,root_ag, al);
        edge_costchange.add(new CostChange(edge, cost_change));
        System.out.println(edge.getUmlRel().getName() +" cost change :" +cost_change);
      }
    }
  }

  private void updateNodeCostChange(String root_ag, String al) {
    node_costchange = new ArrayList<>();
    for(String nn: QPGGenerator.graph.getNodes().keySet()){
      QPGNode node = QPGGenerator.graph.getNode(nn);
      if(node.isStoredInAgg(al)) {
        double cost_change = calCostChange(node, root_ag, al);
        node_costchange.add(new CostChange(node, cost_change));
        System.out.println(node.getNodeName() +" cost change :" +cost_change);
      }
    }
  }

 private QPGEdge getNextEdge(String al){
    Collections.sort(edge_costchange);
    if(!edge_costchange.isEmpty() && edge_costchange.get(0).getCostChange() < 0)
      return (QPGEdge) edge_costchange.get(0).getObject();
    else return null;
 }

 private QPGNode getNextNode(String al){
   Collections.sort(node_costchange);
   if(!node_costchange.isEmpty() && node_costchange.get(0).getCostChange() < 0) {
     QPGNode node = (QPGNode) node_costchange.get(0).getObject();
     node_costchange.remove(0);
     return node;
   }
   else return null;
 }

 private double calCostChange(QPGEdge edge, String root_al,String al){
   double cost_change = calSubTreeWriteCostChange(edge, al)
       + calSuperTreeWriteCostChange(edge, al)
       + CostCalculator.calQueryCostChange(edge.getStartNode(), root_al);
   return cost_change;
 }

 private double calCostChange(QPGNode node, String root_al, String al){
   double cost_change = calSubTreeWriteCostChange(node, al)
       + calSuperTreeWriteCostChange(node, al)
       + CostCalculator.calQueryCostChange(node, root_al);
   return cost_change;
 }

  private  double calSubTreeWriteCostChange(QPGNode node, String agg_label){
    return CostCalculator.calSubTreeWriteCost(node,agg_label)
        *(1/ CostCalculator.calWeightOfSuperTree(node, agg_label) - 1);
  }
  private  double calSuperTreeWriteCostChange(QPGNode node, String agg_label){
    return CostCalculator.calSuperTreeWriteCost(node,agg_label)
        *( 1/ CostCalculator.calWeightOfSubTree(node, agg_label) -1);
  }
  private   double calSubTreeWriteCostChange(QPGEdge edge, String agg_label){
    return CostCalculator.calSubTreeWriteCost(edge,agg_label)
        *(1/ CostCalculator.calWeightOfSuperTree(edge.getStartNode(),edge, agg_label)-1);
  }
  private  double calSuperTreeWriteCostChange(QPGEdge edge, String agg_label){
    return CostCalculator.calSuperTreeWriteCost(edge.getStartNode(), edge,agg_label)
        *(1/ CostCalculator.calWeightOfSubTree(edge.getStartNode(),agg_label)-1);
  }

  public List<List<String>> merge(){
    Map<QPGNode, List<String>> ap_aggs = new HashMap<>();
    for(String al: QPGGenerator.agg_ap.keySet()){
      QPGNode ap = QPGGenerator.agg_ap.get(al);
      if(ap_aggs.get(ap) == null)
        ap_aggs.put(ap, new ArrayList<>());
      ap_aggs.get(ap).add(al);
    }

    List<List<String>> agg_groups = new ArrayList<>();
    for(QPGNode root: ap_aggs.keySet()){
      if(ap_aggs.get(root).size() == 1) {
        agg_groups.add(ap_aggs.get(root));
        continue;
      }

     Map<String, Map<String,Boolean>> compatible_map = new HashMap<>();
      for(int i = 0; i < ap_aggs.get(root).size(); i++){
        String agg1 = ap_aggs.get(root).get(i);
        for(int j = i+1; j <ap_aggs.get(root).size(); j++){
          String agg2 = ap_aggs.get(root).get(j);
          if(isCompatible(agg1, agg2, root)) {
            if(compatible_map.get(agg1) == null)
              compatible_map.put(agg1,new HashMap<>());
            compatible_map.get(agg1).put(agg2, true);
            if(compatible_map.get(agg2) == null)
              compatible_map.put(agg2,new HashMap<>());
            compatible_map.get(agg2).put(agg1, true);
          }
        }
        if(compatible_map.get(agg1) == null){//No compatible
          List<String> gs = new ArrayList<>();gs.add(agg1);
          agg_groups.add(gs);
        }
      }
      List<String> checked = combineCompatibleAggs(agg_groups, compatible_map);
      for(String a: compatible_map.keySet()){
        if(!checked.contains(a)){
          List<String> gs = new ArrayList<>();gs.add(a);agg_groups.add(gs);
        }
      }
    }
    return agg_groups;
  }

  private List<String> combineCompatibleAggs(List<List<String>> agg_groups,
                                     Map<String, Map<String,Boolean>> compatible_map) {
    List<String> checked = new ArrayList<>();
    for(String a1: compatible_map.keySet()){
      if(checked.contains(a1)) continue;
      if(compatible_map.get(a1).keySet().size() == 1){
        List<String> group = new ArrayList<>();
        group.add(a1);
        String a2 = (String) compatible_map.get(a1).keySet().toArray()[0];
        group.add(a2);
        agg_groups.add(group);
        checked.add(a1);checked.add(a2);
      }else{
        List<String> gs = new ArrayList<>();
        gs.add(a1);
        checked.add(a1);
        for(String a2: compatible_map.get(a1).keySet()){
          if(isCompatible(a2, gs, compatible_map)){
            gs.add(a2);
            checked.add(a2);
          }
        }
        agg_groups.add(gs);
      }
    }
    return checked;
  }

  private boolean isCompatible(String new_al, List<String> gs,
                               Map<String, Map<String,Boolean>> compatible_map){
    for(String a: gs){
      if(!compatible_map.get(new_al).get(a))
        return false;
    }
    return true;
  }

  /*private List<String> getCompatibleAggs(){

  }*/

  private boolean isCompatible(String agg1, String agg2, QPGNode shared_root){
    boolean flag = true;
    flag = flag && isSiblingCompatible(agg1, agg2, shared_root);
    flag = flag && isKeyCompatible(agg1, agg2, shared_root);
    return flag;
  }

  private boolean isSiblingCompatible(String agg1,
                                      String agg2, QPGNode node){
    boolean flag = true;
    List<QPGEdge> nonOverlap1 = new ArrayList<>();
    List<QPGEdge> nonOverlap2 = new ArrayList<>();
    List<QPGEdge> sharedEdges = new ArrayList<>();

    for(QPGEdge edge: node.getOutEdges()){
      if(edge.isInAgg(agg1) && edge.isInAgg(agg2))
        sharedEdges.add(edge);
      else if (edge.isInAgg(agg1) && ! edge.isInAgg(agg2))
        nonOverlap1.add(edge);
      else if (! edge.isInAgg(agg1) && edge.isInAgg(agg2))
        nonOverlap2.add(edge);
    }

    for(QPGEdge edge: nonOverlap1){
      if(edge.getCard(edge.getEndNode()) != 1)
        return false;
      if(CostCalculator.calWeightOfSubTree(edge.getEndNode(), agg1) != 1)
        return false;
    }
    for(QPGEdge edge: nonOverlap2){
      if(edge.getCard(edge.getEndNode()) != 1)
        return false;
      if(CostCalculator.calWeightOfSubTree(edge.getEndNode(), agg2) != 1)
        return false;
    }

    for(QPGEdge edge: sharedEdges){
      flag = flag && isSiblingCompatible(agg1, agg2, edge.getEndNode());
      if(!flag) return flag;
    }
    return flag;
  }


  private boolean isKeyCompatible(String agg1,
                                  String agg2, QPGNode node){
    AggregationTree tree1 = new AggregationTree(agg1);
    AggregationTree tree2 = new AggregationTree(agg2);
    return tree1.isKeyCompatible(tree2);
  }

}
