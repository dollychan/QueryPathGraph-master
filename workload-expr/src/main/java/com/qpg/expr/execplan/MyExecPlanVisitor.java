package com.qpg.expr.execplan;

import com.qpg.expr.execplan.parser.ExecPlanParser;
import com.qpg.expr.execplan.parser.ExecPlanParserBaseVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyExecPlanVisitor extends ExecPlanParserBaseVisitor<Object> {
  private ExecPlan execPlan;
  public MyExecPlanVisitor(){execPlan = new ExecPlan();}

  public ExecPlan getExecPlan(){return execPlan;}

  @Override
  public Object visitInput(ExecPlanParser.InputContext ctx) {
    for(int i = 0; i < ctx.stmt().size(); i++)
    {
      visitStmt(ctx.stmt(i));
    }
    return null;
  }

  @Override
  public Object visitData_range_stmt(ExecPlanParser.Data_range_stmtContext ctx) {
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
  public Object visitExec_query_stmt(ExecPlanParser.Exec_query_stmtContext ctx) {
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
  public Object visitAttr_lists(ExecPlanParser.Attr_listsContext ctx) {
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
  public Object visitExec_update_stmt(ExecPlanParser.Exec_update_stmtContext ctx) {
    for(int i = 0; i < ctx.update_stmt().size(); i++){
      if(ctx.update_stmt(i).update_stmt1() != null) {
        ExecPlanParser.Update_stmt1Context uctx = ctx.update_stmt(i).update_stmt1();
        String table_name = uctx.table_name().getText();
        List<String> query_eas = null;
        if (uctx.QUERY_() != null) {
          query_eas = (List<String>) visitAttr_lists(uctx.ea_attrs().attr_lists());
        }
        List<String>  attrs = (List<String>) visitAttr_lists(uctx.attr_lists());
        char update_type = 0;
        if (uctx.UPDATE_() != null)
          update_type = ExecPlan.EXECPLAN_UPDATE_TYPE_MODIFY;
        if (uctx.INSERT_() != null)
          update_type = ExecPlan.EXECPLAN_UPDATE_TYPE_ADD;
        execPlan.addUpdateExecPlan(ctx.update_name().getText(), table_name, table_name,
            query_eas, query_eas, null, attrs, update_type);
      }else{
        ExecPlanParser.Update_stmt2Context uctx = ctx.update_stmt(i).update_stmt2();
        String query_table = uctx.table_name(0).getText(),
            update_table =  uctx.table_name(1).getText();
        List<String>  query_eas = (List<String>) visitAttr_lists(uctx.ea_attrs(0).attr_lists()),
            update_eas = (List<String>) visitAttr_lists(uctx.ea_attrs(1).attr_lists());
        List<String>  query_attrs = (List<String>) visitAttr_lists(uctx.attr_lists(0)),
            update_attrs = (List<String>) visitAttr_lists(uctx.attr_lists(1));

        char update_type = 0;
        if (uctx.UPDATE_() != null)
          update_type = ExecPlan.EXECPLAN_UPDATE_TYPE_MODIFY;
        if (uctx.INSERT_() != null)
          update_type = ExecPlan.EXECPLAN_UPDATE_TYPE_ADD;
        execPlan.addUpdateExecPlan(ctx.update_name().getText(), query_table, update_table,
            query_eas, update_eas, query_attrs, update_attrs, update_type);
      }
    }
    return null;
  }
}
