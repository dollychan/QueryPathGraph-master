package com.qpg.cost_model;

import com.qpg.QPGRunner;
import com.qpg.core.QPGGenerator;
import com.qpg.model.common.Keyword;
import com.qpg.model.qpg.QPGEdge;
import com.qpg.model.qpg.QPGNode;
import com.qpg.model.query.QueryStmt;
import org.apache.log4j.Logger;

import java.util.List;

public class CostCalculator {
  private static Logger logger = Logger.getLogger(CostCalculator.class);

  public static double calCw(Object o, String agg_label){
    if(QPGRunner.nosql_type == Keyword.TARGET_NOSQL_TYPE_CF
        || QPGRunner.nosql_type == Keyword.TARGET_NOSQL_TYPE_KV){
      return calCwCF(o, agg_label);
    }else if (QPGRunner.nosql_type == Keyword.TARGET_NOSQL_TYPE_DOC)
      return calCwDoc(o, agg_label);
    logger.error("Unknown nosql type "+ QPGRunner.nosql_type);
    return 0;
  }
  private static double calCwCF(Object o, String agg_label){
    if(o instanceof QPGNode){
      double w = calWeightOfSubTree((QPGNode) o, agg_label);
      w = w* calWeightOfSuperTree((QPGNode) o, agg_label);
      return w;
    }else if(o instanceof QPGEdge){
      //double w = calWeightOfSubTree(((QPGEdge) o).getEndNode(), agg_label);
      //w = w * calWeightOfSuperTree(((QPGEdge) o).getStartNode(), agg_label);
     double w= QPGGenerator.costModel.getWriteCost(((QPGEdge) o).getEndNode(),agg_label);
     /*if(w== 0){
       w=calCwCF(((QPGEdge) o).getEndNode(),agg_label);
     }*/
     w = w/((QPGEdge)o).getCard(((QPGEdge)o).getStartNode());
      return w;
    }else{
      logger.error("Unknown object type in calCsCF!");
      return 0;
    }
  }
  private static double calCwDoc(Object o, String agg_label){
    if(o instanceof QPGNode){
      double w =calWeightToRoot((QPGNode) o, agg_label);
      return w;
    }else if(o instanceof QPGEdge){
      double w =calWeightToRoot(((QPGEdge) o).getStartNode(), agg_label);
      return w;
    }else{
      logger.error("Unknown object type in calCsDoc!");
      return 0;
    }
  }

  ////////////////////////////////////////////////////////
  // root a -> .. c -> node
  public static double calWeightToRoot(QPGNode node, String agg_label){
    double w = 1;
    for(QPGEdge edge: node.getInEdges()){
      if(edge.isInAgg(agg_label)){
        w = w * edge.getCard(edge.getStartNode()); //card at the start node
        w = w* calWeightToRoot(edge.getStartNode(), agg_label);
      }
    }
    return w;
  }

  // root -> a...->c node
  private static double calWeightFromRoot(QPGNode node, String agg_label){
    double w = 1;
    for(QPGEdge edge: node.getInEdges()){
      if(edge.isInAgg(agg_label)){
        w = w * edge.getCard(node); //card at the end node
        w = w* calWeightFromRoot(edge.getStartNode(), agg_label);
      }
    }
    return w;
  }

  // node {->a cnode1 {-> ...},  ->b cnode2 ) to all descendants
  public static double calWeightOfSubTree(QPGNode node, String agg_label){
    double w = 1;
    for(QPGEdge edge: node.getOutEdges()){
      if(edge.isInAgg(agg_label)){
        w = w * edge.getCard(edge.getEndNode());
        w = w * calWeightOfSubTree(edge.getEndNode(), agg_label);
      }
    }
    return w;
  }

  // root {->a cnode1 {-> ...},  ->b node ) all parents and parents' out-edge of  node
  public static double calWeightOfSuperTree(QPGNode node, String agg_label){
    double w = 1;
    for(QPGEdge edge: node.getInEdges()){
      if(edge.isInAgg(agg_label)){//should be only 1 in-edge of agg_label
        w = w * edge.getCard(edge.getStartNode());
        w = w* calWeightOfSuperTree(edge.getStartNode(), edge, agg_label);
      }
    }
    return w;
  }
  public static double calWeightOfSuperTree(QPGNode node,
                                             QPGEdge partition_edge, String agg_label){
    double w = 1;
    for(QPGEdge edge: node.getInEdges()){
      if(edge != partition_edge && edge.isInAgg(agg_label) ){
        w = w * edge.getCard(edge.getStartNode());
        w = w* calWeightOfSuperTree(edge.getStartNode(), edge,agg_label);
      }
    }
    for(QPGEdge edge: node.getOutEdges() ){
      if(edge != partition_edge && edge.isInAgg(agg_label) ){
        w = w * edge.getCard(edge.getEndNode());
        w = w* calWeightOfSuperTree(edge.getEndNode(), edge,agg_label);
      }
    }
    return w;
  }

  ////////////////////////////////////////////////////////////
  /*c_r of a node in this aggregation tree if normalization
   * CF and Doc are the same
   * */
  public static double calCr(QPGNode node, String agg_label){
    return calWeightFromRoot(node, agg_label);
  }

  ////////////////////////////////////////////////////////////
  public static double calSubTreeWriteCost(QPGNode node, String agg_label){
    if(!node.isStoredInAgg(agg_label))
      return  0;
    double cost = QPGGenerator.costModel.getWriteCost(node,agg_label)
        * QPGRunner.input.getWorkloadFreq(node.getUmlClass());
    for(QPGEdge edge: node.getOutEdges()){
      if(edge.isInAgg(agg_label)){
        cost += QPGGenerator.costModel.getWriteCost(edge,agg_label)
            * QPGRunner.input.getWorkloadFreq(edge.getUmlRel());
        cost += calSubTreeWriteCost(edge.getEndNode(), agg_label);
      }
    }
    return cost;
  }
  public static double calSubTreeWriteCost(QPGEdge root_edge, String agg_label){
    if(!root_edge.isInAgg(agg_label))
      return 0;
    double cost = QPGGenerator.costModel.getWriteCost(root_edge.getStartNode(),agg_label)
        * QPGRunner.input.getWorkloadFreq(root_edge.getStartNode().getUmlClass());
    cost += QPGGenerator.costModel.getWriteCost(root_edge,agg_label)
        * QPGRunner.input.getWorkloadFreq(root_edge.getUmlRel());
    cost += calSubTreeWriteCost(root_edge.getEndNode(), agg_label);
    return cost;
  }
  public static double calSuperTreeWriteCost(QPGNode node, String agg_label){
    double cost = 0;
    for(QPGEdge edge: node.getInEdges()){
      if(edge.isInAgg(agg_label)){//should be only 1 in-edge of agg_label
        cost += QPGGenerator.costModel.getWriteCost(edge,agg_label)
            * QPGRunner.input.getWorkloadFreq(edge.getUmlRel());

        cost  += calSuperTreeWriteCost(edge.getStartNode(), edge, agg_label);
      }
    }
    return cost;
  }
  public static double calSuperTreeWriteCost(QPGNode node,
                                             QPGEdge partition_edge, String agg_label){
    double cost = QPGGenerator.costModel.getWriteCost(node,agg_label)
        * QPGRunner.input.getWorkloadFreq(node.getUmlClass());

    for(QPGEdge edge: node.getInEdges()){
      if(edge != partition_edge && edge.isInAgg(agg_label) ){
        cost += QPGGenerator.costModel.getWriteCost(edge,agg_label)
            * QPGRunner.input.getWorkloadFreq(edge.getUmlRel());
        cost += calSuperTreeWriteCost(edge.getStartNode(), edge,agg_label);
      }
    }
    for(QPGEdge edge: node.getOutEdges() ){
      if(edge != partition_edge && edge.isInAgg(agg_label) ){
        cost += QPGGenerator.costModel.getWriteCost(edge,agg_label)
            * QPGRunner.input.getWorkloadFreq(edge.getUmlRel());
        cost += calSuperTreeWriteCost(edge.getEndNode(), edge,agg_label);
      }
    }
    return cost;
  }


  //parition Aggregation tree on node, the change of cost
  public static double calQueryCostChange(QPGNode node, String root_agg_label){
    List<QueryStmt> queries = QPGGenerator.executionPlan.getQueries(root_agg_label);
    double increased_query = QPGGenerator.costModel.getReadCost(node,root_agg_label);
    double cost = 0;
    for(QueryStmt q: queries){
      cost += (QPGGenerator.costModel.getReadCost(q, root_agg_label)
          * increased_query)
          * QPGRunner.input.getWorkloadFreq(q) ;
    }
    return cost;
  }

}
