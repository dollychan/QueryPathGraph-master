// Generated from /Users/dollychen/Documents/qpg_workspace/QPG_experiment/lib/QueryPathGraph-master/workload-expr/src/main/antlr4/ExecPlanParser.g4 by ANTLR 4.9.2
 package com.qpg.expr.execplan.parser; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExecPlanParser}.
 */
public interface ExecPlanParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(ExecPlanParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(ExecPlanParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(ExecPlanParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(ExecPlanParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#data_range_stmt}.
	 * @param ctx the parse tree
	 */
	void enterData_range_stmt(ExecPlanParser.Data_range_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#data_range_stmt}.
	 * @param ctx the parse tree
	 */
	void exitData_range_stmt(ExecPlanParser.Data_range_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#data_range}.
	 * @param ctx the parse tree
	 */
	void enterData_range(ExecPlanParser.Data_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#data_range}.
	 * @param ctx the parse tree
	 */
	void exitData_range(ExecPlanParser.Data_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#data_type_stmt}.
	 * @param ctx the parse tree
	 */
	void enterData_type_stmt(ExecPlanParser.Data_type_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#data_type_stmt}.
	 * @param ctx the parse tree
	 */
	void exitData_type_stmt(ExecPlanParser.Data_type_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#exec_query_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExec_query_stmt(ExecPlanParser.Exec_query_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#exec_query_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExec_query_stmt(ExecPlanParser.Exec_query_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#query_stmt}.
	 * @param ctx the parse tree
	 */
	void enterQuery_stmt(ExecPlanParser.Query_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#query_stmt}.
	 * @param ctx the parse tree
	 */
	void exitQuery_stmt(ExecPlanParser.Query_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#query_table}.
	 * @param ctx the parse tree
	 */
	void enterQuery_table(ExecPlanParser.Query_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#query_table}.
	 * @param ctx the parse tree
	 */
	void exitQuery_table(ExecPlanParser.Query_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#attr_lists}.
	 * @param ctx the parse tree
	 */
	void enterAttr_lists(ExecPlanParser.Attr_listsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#attr_lists}.
	 * @param ctx the parse tree
	 */
	void exitAttr_lists(ExecPlanParser.Attr_listsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#ea_attrs}.
	 * @param ctx the parse tree
	 */
	void enterEa_attrs(ExecPlanParser.Ea_attrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#ea_attrs}.
	 * @param ctx the parse tree
	 */
	void exitEa_attrs(ExecPlanParser.Ea_attrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#ia_attrs}.
	 * @param ctx the parse tree
	 */
	void enterIa_attrs(ExecPlanParser.Ia_attrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#ia_attrs}.
	 * @param ctx the parse tree
	 */
	void exitIa_attrs(ExecPlanParser.Ia_attrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#oa_attrs}.
	 * @param ctx the parse tree
	 */
	void enterOa_attrs(ExecPlanParser.Oa_attrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#oa_attrs}.
	 * @param ctx the parse tree
	 */
	void exitOa_attrs(ExecPlanParser.Oa_attrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#pa_attrs}.
	 * @param ctx the parse tree
	 */
	void enterPa_attrs(ExecPlanParser.Pa_attrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#pa_attrs}.
	 * @param ctx the parse tree
	 */
	void exitPa_attrs(ExecPlanParser.Pa_attrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#exec_update_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExec_update_stmt(ExecPlanParser.Exec_update_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#exec_update_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExec_update_stmt(ExecPlanParser.Exec_update_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#update_stmt}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_stmt(ExecPlanParser.Update_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#update_stmt}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_stmt(ExecPlanParser.Update_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#update_stmt1}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_stmt1(ExecPlanParser.Update_stmt1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#update_stmt1}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_stmt1(ExecPlanParser.Update_stmt1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#update_stmt2}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_stmt2(ExecPlanParser.Update_stmt2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#update_stmt2}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_stmt2(ExecPlanParser.Update_stmt2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ExecPlanParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ExecPlanParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(ExecPlanParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(ExecPlanParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#any_name}.
	 * @param ctx the parse tree
	 */
	void enterAny_name(ExecPlanParser.Any_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#any_name}.
	 * @param ctx the parse tree
	 */
	void exitAny_name(ExecPlanParser.Any_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#update_name}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_name(ExecPlanParser.Update_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#update_name}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_name(ExecPlanParser.Update_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#query_name}.
	 * @param ctx the parse tree
	 */
	void enterQuery_name(ExecPlanParser.Query_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#query_name}.
	 * @param ctx the parse tree
	 */
	void exitQuery_name(ExecPlanParser.Query_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(ExecPlanParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(ExecPlanParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void enterAttr_name(ExecPlanParser.Attr_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void exitAttr_name(ExecPlanParser.Attr_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#min_num}.
	 * @param ctx the parse tree
	 */
	void enterMin_num(ExecPlanParser.Min_numContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#min_num}.
	 * @param ctx the parse tree
	 */
	void exitMin_num(ExecPlanParser.Min_numContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExecPlanParser#max_num}.
	 * @param ctx the parse tree
	 */
	void enterMax_num(ExecPlanParser.Max_numContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExecPlanParser#max_num}.
	 * @param ctx the parse tree
	 */
	void exitMax_num(ExecPlanParser.Max_numContext ctx);
}