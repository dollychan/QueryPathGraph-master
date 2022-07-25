package com.qpg.parser;

import com.qpg.model.QPGInput;
import com.qpg.model.common.Keyword;
import com.qpg.model.query.QueryStmt;
import com.qpg.model.uml.UMLAttribute;
import com.qpg.model.uml.UMLClass;
import com.qpg.model.uml.UMLRelationship;
import com.qpg.parser.antlr.WorkloadParser;
import com.qpg.parser.antlr.WorkloadParserBaseVisitor;

public class QPGWorkloadVisitor extends WorkloadParserBaseVisitor<Object> {
  private QPGInput qpgInput;

  public QPGWorkloadVisitor(){
    qpgInput = new QPGInput();
  }

  public QPGInput getQpgInput(){return qpgInput;}

  @Override
  public Object visitInput(WorkloadParser.InputContext ctx) {
    for(int i = 0; i < ctx.stmt().size(); i++)
    {
      visitStmt(ctx.stmt(i));
    }
    return null;
  }

  @Override
  public Object visitClassStmt(WorkloadParser.ClassStmtContext ctx) {
   // System.out.println("ClassStmt: " + ctx.getText());
    UMLClass c = new UMLClass(ctx.class_name().any_name().getText());
    if(ctx.NUMERIC_LITERAL() != null){
      qpgInput.addClassSize(c, (Double.parseDouble(ctx.NUMERIC_LITERAL().getText())));
    }
    for(int i = 0; i < ctx.attr_stmt().size();i++){

        c.addAttr((UMLAttribute) visitAttr_stmt(ctx.attr_stmt(i)));
    }
    qpgInput.addClass(c);
    if(ctx.freq() != null)
      qpgInput.addWorkloadFreq(c,Double.parseDouble(ctx.freq().NUMERIC_LITERAL().getText()));
    return null;
  }

  @Override public Object visitAttr_stmt(WorkloadParser.Attr_stmtContext ctx) {
  //  System.out.println("Attribute " + ctx.getText());
    String name = ctx.attr_name().any_name().getText();
    String type = ctx.attr_type().getText();
    if("int".equalsIgnoreCase(type))
      type = Keyword.ATTR_TYPE_INT;
    if("float".equalsIgnoreCase(type))
      type = Keyword.ATTR_TYPE_FLOAT;
    if("string".equalsIgnoreCase(type))
      type = Keyword.ATTR_TYPE_STRING;
    if("date".equalsIgnoreCase(type))
      type = Keyword.ATTR_TYPE_DATE;
    boolean isPK = false;
    if(ctx.attr_pk() != null)
      isPK = true;
    boolean isMultiValue = false;
    if(ctx.STAR() != null)
      isMultiValue = true;
    UMLAttribute attr = new UMLAttribute(name, type, isPK, isMultiValue);
    return attr;
  }

  @Override public Object visitRel_stmt(WorkloadParser.Rel_stmtContext ctx) {
   // System.out.println("Relationship " + ctx.getText());
    String name = ctx.rel_name().any_name().getText();
    String class1 = ctx.class_name(0).any_name().getText();
    int card_ratio1 = 1;
    if(ctx.card_ratio(0).NUMERIC_LITERAL()!= null)
      card_ratio1 = Integer.parseInt(ctx.card_ratio(0).NUMERIC_LITERAL().getText());
    if(ctx.card_ratio(0).STAR() != null)
      card_ratio1 = Keyword.REL_CARD_RATIO_MANY;
    String class2 = ctx.class_name(1).any_name().getText();
    int card_ratio2 = 1;
    if(ctx.card_ratio(1).NUMERIC_LITERAL()!= null)
      card_ratio2 = Integer.parseInt(ctx.card_ratio(1).NUMERIC_LITERAL().getText());
    if(ctx.card_ratio(1).STAR() != null)
      card_ratio2 = Keyword.REL_CARD_RATIO_MANY;
    UMLRelationship rel = new UMLRelationship(name, class1, card_ratio1, class2,card_ratio2);
    for(int i = 0; i< ctx.attr_stmt().size(); i++){
      rel.addAttr((UMLAttribute) visitAttr_stmt(ctx.attr_stmt(i)));
    }
    if(ctx.freq() != null)
      qpgInput.addWorkloadFreq(rel,Double.parseDouble(ctx.freq().NUMERIC_LITERAL().getText()));
    qpgInput.addRel(rel);
    return null;
  }

  @Override public Object visitQueryStmt(WorkloadParser.QueryStmtContext ctx) {
   // System.out.println("Query:" + ctx.getText());
    QueryStmt q = new QueryStmt();

    for(int i = 0; i < ctx.class_attr().size(); i++){
      q.addSelectPro(ctx.class_attr(i).class_name().any_name().getText(),
          ctx.class_attr(i).attr_name().any_name().getText());
    }

    int eid = 1;
    for(int i = 0; i < ctx.tablePath().size(); i++) {
      WorkloadParser.TablePathContext tpctx = ctx.tablePath(i);
      String[] class_alias = (String[]) visitTable_name(tpctx.table_name(0));
      q.addAliasClass(class_alias);
      String src = class_alias[1];
      int j = 1;
      for (; j <= tpctx.rel_name().size(); j++) {
        String[] target = (String[]) visitTable_name(tpctx.table_name(j));
        q.addAliasClass(target);
        q.addPath(eid++, tpctx.rel_name(j - 1).any_name().getText(), src, target[1]);
        src = target[1];
      }
    }

    if(ctx.whereClause() != null){
      for(int i = 0; i < ctx.whereClause().expr().size(); i++){
        WorkloadParser.ExprContext ectx = ctx.whereClause().expr(i);
        if(ectx.ASSIGN()!= null){
          q.addEqualityPro(ectx.class_attr().class_name().any_name().getText(),
              ectx.class_attr().attr_name().any_name().getText());
        }else
        {
          q.addInequalityPro(ectx.class_attr().class_name().any_name().getText(),
              ectx.class_attr().attr_name().any_name().getText());
        }
      }
    }

    if(ctx.orderByClause() != null){
      for(int i = 0; i < ctx.orderByClause().orderEle().size(); i++)
      {
        String asc_desc = Keyword.QUERY_ORDER_ASC;
        if(ctx.orderByClause().orderEle(i).asc_desc()!= null)
          asc_desc = ctx.orderByClause().orderEle(i).asc_desc().getText();
        q.addOrderPro(ctx.orderByClause().orderEle(i).class_attr().class_name().any_name().getText(),
            ctx.orderByClause().orderEle(i).class_attr().attr_name().any_name().getText(), asc_desc);
      }
    }
    if(ctx.freq()!= null)
      qpgInput.addWorkloadFreq(q, Double.parseDouble(ctx.freq().NUMERIC_LITERAL().getText()));

    qpgInput.addQuery(q);
    return null;
  }

  @Override public Object visitTable_name(WorkloadParser.Table_nameContext ctx) {
    String[] tn = new String[2];
    tn[0] = ctx.any_name().getText();
    if(ctx.class_name() != null) //alias
      tn[1] = ctx.class_name().any_name().getText();
    else
      tn[1] = tn[0];
    return tn; }


}
