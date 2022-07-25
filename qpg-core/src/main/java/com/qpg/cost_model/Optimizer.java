package com.qpg.cost_model;

import com.qpg.QPGRunner;
import com.qpg.model.common.Keyword;
import org.apache.log4j.Logger;

import java.util.List;

public abstract class Optimizer {
  private static Logger logger = Logger.getLogger(Optimizer.class);
  private static Optimizer optimizer = null;


  public  static Optimizer getOptimizer(){
    if(optimizer == null) {
      if(QPGRunner.nosql_type == Keyword.TARGET_NOSQL_TYPE_DOC)
        optimizer  = new DocOptimizer();
      else if(QPGRunner.nosql_type == Keyword.TARGET_NOSQL_TYPE_CF
      || QPGRunner.nosql_type == Keyword.TARGET_NOSQL_TYPE_KV)
        optimizer = new CFOptimizer();
    }
    return optimizer;
  }

  public abstract void optimize(String al);


  public abstract List<List<String>> merge();

  protected class CostChange implements Comparable<CostChange>{
    private Object o;// QPGNode or QPGEdge
    private double cost_change;

    protected CostChange(Object o, double cc){
      this.o = o;
      this.cost_change = cc;
    }
    protected Object getObject(){return o;}
    protected double getCostChange(){return cost_change;}

    @Override
    public int compareTo(CostChange o) {
      if(cost_change> o.getCostChange())
        return 1;
      else if (cost_change == o.getCostChange()) return 0;
      else return -1;
    }
  }


}
