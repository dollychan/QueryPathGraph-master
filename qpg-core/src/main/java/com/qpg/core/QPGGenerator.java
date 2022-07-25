package com.qpg.core;

import com.qpg.QPGRunner;
import com.qpg.cost_model.CostCalculator;
import com.qpg.cost_model.CostModel;
import com.qpg.cost_model.Optimizer;
import com.qpg.model.qpg.ExecutionPlan;
import com.qpg.model.qpg.QPGEdge;
import com.qpg.model.qpg.QPGGraph;
import com.qpg.model.qpg.QPGNode;
import com.qpg.model.query.QueryStmt;
import org.apache.log4j.Logger;

import java.util.*;

public class QPGGenerator {
  private static Logger logger = Logger.getLogger(QPGGenerator.class);

  public static QPGGraph graph;
  public static Map<String,List<String>> root_agg_new_aggs; // initial agg_label (static) -> newly split
  public static ExecutionPlan executionPlan;
  public static CostModel costModel;
  public static Map<String, QPGNode> agg_ap; //aggregation label-> access point class name

  public void init(){
    if(graph != null)
      return;
    graph = new QPGGraph();
    executionPlan = new ExecutionPlan();
    costModel = new CostModel();
    root_agg_new_aggs = new HashMap<>();
    agg_ap = new HashMap<>();

    List<QueryStmt> queries = QPGRunner.input.getQueryList();
    for(int i = 0;i < queries.size(); i++){
      String al = (i+1)+"";
      root_agg_new_aggs.put(al, new ArrayList<>());
      initQPG(queries.get(i), al);
      executionPlan.addExecutionPlan(queries.get(i), al);
      costModel.setReadCost(queries.get(i), al, 1);
    }
    graph.initExecutionPlan();
    setAllCosts();
  }

  private void initQPG(QueryStmt query, String agg_label){
    query.genOptimalQueryPath(QPGRunner.input);// determine the access point
    QPGNode ap = query.mapToQPG(agg_label);
    assert ap != null;
    agg_ap.put(agg_label,ap);
  }

  public void setAllCosts(){
    for(String nn: graph.getNodes().keySet()){
      for(String agg_label: agg_ap.keySet())
      {
        if(graph.getNode(nn).isStoredInAgg(agg_label)) {
          costModel.setWriteCost(graph.getNode(nn), agg_label,
              CostCalculator.calCw(graph.getNode(nn), agg_label));
          costModel.setReadCost(graph.getNode(nn), agg_label,
              CostCalculator.calCr(graph.getNode(nn), agg_label));
        }
      }
    }
    for(QPGEdge edge: graph.getEdges()){
      for(String agg_label: agg_ap.keySet()) {
        if (edge.isInAgg(agg_label))
          costModel.setWriteCost(edge, agg_label, CostCalculator.calCw(edge,agg_label));
      }
    }
  }

  public List<List<String>> optimize() {
    for(String l: root_agg_new_aggs.keySet())
      Optimizer.getOptimizer().optimize(l);

   List<List<String>> agg_groups = Optimizer.getOptimizer().merge();
    return agg_groups;
  }

  public void print(){
    logger.info(graph.printGraph());
    logger.info(executionPlan.print());
    logger.info(costModel.print());
  }
}
