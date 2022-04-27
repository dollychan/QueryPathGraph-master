package com.qpg.dataTransformer;

import com.qpg.dataTransformer.parser.SQLtoNoSQLMapper;
import com.qpg.dataTransformer.parser.SQLtoNoSQLMapperBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class QPGTransformerVisitor extends SQLtoNoSQLMapperBaseVisitor<Object> {
  private QPGTransformer transformer = null;

  public QPGTransformer getTransformer(){return transformer;}

  @Override
  public Object visitInput(SQLtoNoSQLMapper.InputContext ctx) {
    if(ctx.CF_() != null)
      transformer = new QPGTransformer(QPGTransformer.TargetDB_CF);
    else if(ctx.DOC_() != null)
      transformer = new QPGTransformer(QPGTransformer.TargetDB_DOC);
    else if(ctx.KV_() != null)
      transformer = new QPGTransformer(QPGTransformer.TargetDB_KV);

    for(int i = 0; i < ctx.tree().size(); i++){
      transformer.addMapper((MapperTreeNode)visitTree(ctx.tree(i)) );
    }
    return null;
  }

  @Override
  public Object visitTree_node(SQLtoNoSQLMapper.Tree_nodeContext ctx) {
    String sql_stmt = ctx.STRING_LITERAL().getText();
    MapperTreeNode tn = new MapperTreeNode(ctx.node_name().getText(), sql_stmt.substring(1,sql_stmt.length()-1), (ctx.ISLIST_()!=null));
    if(ctx.bound_attrs() != null)
      tn.setBoundAttrs((List<String>)visitBound_attrs(ctx.bound_attrs()));
    if(ctx.children_node() != null){
      for(int i = 0 ; i < ctx.children_node().tree_node().size(); i++) {
        MapperTreeNode c = (MapperTreeNode) visitTree_node(ctx.children_node().tree_node(i));
        tn.addChild(c);
      }
    }
    return tn; }

  @Override
  public Object visitBound_attrs(SQLtoNoSQLMapper.Bound_attrsContext ctx) {
    List<String> bound_attrs = new ArrayList<>();
    for(int i = 0; i < ctx.ID().size(); i++)
    {
      bound_attrs.add(ctx.ID(i).getText());
    }
    return bound_attrs;
  }

}
