package com.qpg.model.nosql;

import com.qpg.model.qpg.QPGNode;

import java.util.List;

public abstract class NoSQLDataUnit {

  public abstract void map(QPGNode root, List<String> agg_labels);
  public abstract String genNoSQLScript();
  public abstract String print();
  public abstract String getName();
}
