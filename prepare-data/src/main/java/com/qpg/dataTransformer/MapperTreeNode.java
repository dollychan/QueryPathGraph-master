package com.qpg.dataTransformer;

import java.util.ArrayList;
import java.util.List;

public class MapperTreeNode {
  private String node_name;//cf_name or a (embedded) doc name
  private String sql_stmt;
  private boolean isList = false;
  private List<MapperTreeNode> children;
  private List<String> bound_attrs; //bound query parameters from the results of parent

  public MapperTreeNode(String nn, String sql, boolean isList){
    this.node_name = nn;
    this.sql_stmt = sql;
    this.children = new ArrayList<>();
    this.isList = isList;
  }

  public List<MapperTreeNode> getChildren() {
    return children;
  }

  public String getSql_stmt() {
    return sql_stmt;
  }

  public String getNode_name() {
    return node_name;
  }

  public boolean isList(){return isList;}

  public void setBoundAttrs(List<String> ba){this.bound_attrs = ba;}

  public List<String> getBoundAttrs(){return bound_attrs;}

  public void addChild(MapperTreeNode c){
    children.add(c);
  }
}
