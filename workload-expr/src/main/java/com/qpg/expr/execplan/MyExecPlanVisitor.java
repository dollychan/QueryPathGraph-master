package com.qpg.expr.execplan;

import com.qpg.expr.execplan.parser.ExecPlanParser;
import com.qpg.expr.execplan.parser.ExecPlanParserBaseVisitor;
import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyExecPlanVisitor extends ExecPlanParserBaseVisitor<Object> {
  private ExecPlan execPlan;
  public MyExecPlanVisitor(){execPlan = new ExecPlan();}

  public ExecPlan getExecPlan(){return execPlan;}

  @Override
  public Object visitInput(com.qpg.expr.execplan.parser.ExecPlanParser.InputContext ctx) {
    for(int i = 0; i < ctx.stmt().size(); i++)
    {
      visitStmt(ctx.stmt(i));
    }
    return null;
  }

  @Override
  public Object visitData_range_stmt(com.qpg.expr.execplan.parser.ExecPlanParser.Data_range_stmtContext ctx) {
    for(int i = 0; i < ctx.data_range().size(); i++){
      execPlan.addDataRange(ctx.data_range(i).attr_name().getText(),
          Integer.parseInt(ctx.data_range(i).min_num().getText()),
          Integer.parseInt(ctx.data_range(i).max_num().getText()));
    }
    return null;
  }

  @Override public Object visitData_type_stmt(ExecPlanParser.Data_type_stmtContext ctx) {
    for(int i = 0 ; i < ctx.attr_name().size(); i++) {
      String at = ctx.type(i).getText();
      if (at.equalsIgnoreCase("int"))
        at = ExecPlan.EXECPLAN_ATTR_TYPE_INT;
      else if (at.equalsIgnoreCase("date"))
        at = ExecPlan.EXECPLAN_ATTR_TYPE_DATE;
      else if (at.equalsIgnoreCase("string"))
        at = ExecPlan.EXECPLAN_ATTR_TYPE_STRING;
      else if (at.equalsIgnoreCase("float"))
        at = ExecPlan.EXECPLAN_ATTR_TYPE_FLOAT;
      execPlan.addDataType(ctx.attr_name(i).getText(), at);
    }
    return null;
  }
  @Override
  public Object visitExec_query_stmt(com.qpg.expr.execplan.parser.ExecPlanParser.Exec_query_stmtContext ctx) {
    for(int i = 0; i < ctx.query_stmt().size(); i++) {
      if(ctx.query_stmt(i).FILTER_() != null){
        execPlan.addQueryExecPlan(ctx.query_name().getText(),(List<String[]>) visitIa_attrs(ctx.query_stmt(i).ia_attrs()));
      }else {
        ExecPlanParser.Query_tableContext qtCtx = ctx.query_stmt(i).query_table();
        Map<String,String> attr_alias = null;
        if(qtCtx.attr_name() != null)
        {
          attr_alias = new HashMap<>();
          for(int j = 0 ; j< qtCtx.attr_name().size();)
            attr_alias.put(qtCtx.attr_name(j++).getText(), qtCtx.attr_name(j++).getText());
        }
        execPlan.addQueryExecPlan(ctx.query_name().getText(), qtCtx.table_name().getText(),
            (List<String>) visitAttr_lists(qtCtx.ea_attrs().attr_lists()),
            (List<String[]>) visitIa_attrs(qtCtx.ia_attrs()),
            (List<String>) visitAttr_lists(qtCtx.oa_attrs().attr_lists()),
            (List<String>) visitAttr_lists(qtCtx.pa_attrs().attr_lists()),attr_alias);
      }
    }
    return null;
  }

  @Override public Object visitIa_attrs(ExecPlanParser.Ia_attrsContext ctx) {
    List<String[]> attr_list = new ArrayList<>();
    for(int i = 0; i < ctx.attr_name().size(); i++){
      attr_list.add(new String[]{ctx.attr_name(i).getText(), ctx.OP(i).getText()});
    }
    return attr_list;
  }

  @Override
  public Object visitAttr_lists(com.qpg.expr.execplan.parser.ExecPlanParser.Attr_listsContext ctx) {
    List<String> attr_list = new ArrayList<>();
    for(int i = 0; i < ctx.attr_name().size(); i++){
      String an =ctx.attr_name(i).getText() ;
      if(ctx.attr_name(i).any_name().STRING_LITERAL()!= null)
        an =an.substring(1,an.length()-1);
      attr_list.add(an);
    }
    return attr_list;
  }

  @Override
  public Object visitExec_update_stmt(com.qpg.expr.execplan.parser.ExecPlanParser.Exec_update_stmtContext ctx) {
    List<String[]> table_list = new ArrayList<>();
    for(int i = 0; i < ctx.update_stmt().size(); i++){
      ExecPlanParser.Update_stmtContext uctx = ctx.update_stmt(i);
      String table_name = uctx.table_name().getText();
      List<String> query_eas = null;
      if(uctx.QUERY_() != null){
        query_eas = (List<String>) visitAttr_lists(uctx.ea_attrs().attr_lists());
      }
      List<String> attrs = new ArrayList<>();
      for(int j = 0; j < uctx.attr_name().size(); j++)
      {
        attrs.add(uctx.attr_name(j).getText());
      }
      char update_type = 0;
      if(uctx.UPDATE_() != null)
        update_type = ExecPlan.EXECPLAN_UPDATE_TYPE_MODIFY;
      if(uctx.INSERT_() != null)
        update_type = ExecPlan.EXECPLAN_UPDATE_TYPE_ADD;
      execPlan.addUpdateExecPlan(ctx.update_name().getText(), table_name, query_eas, update_type, attrs);
    }
    return null;
  }


}
