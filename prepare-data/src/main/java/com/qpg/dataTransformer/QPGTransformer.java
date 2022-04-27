package com.qpg.dataTransformer;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class QPGTransformer {
  public static final int TargetDB_CF = 0;
  public static final int TargetDB_DOC = 1;
  public static final int TargetDB_KV = 2;

  private int targetDB_type;
  private List<MapperTreeNode> mappers;

  public int getTargetDBType(){return targetDB_type;}
  public List<MapperTreeNode> getMappers(){return mappers;}

  public QPGTransformer(int targetDb){
    this.targetDB_type = targetDb;
    mappers = new ArrayList<>();
  }

  public void addMapper(MapperTreeNode tree){
    mappers.add(tree);
  }
}
