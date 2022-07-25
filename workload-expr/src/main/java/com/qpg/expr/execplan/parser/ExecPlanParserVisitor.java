// Generated from /Users/dollychen/Documents/qpg_workspace/QPG_experiment/lib/QueryPathGraph-master/workload-expr/src/main/antlr4/ExecPlanParser.g4 by ANTLR 4.9.2
 package com.qpg.expr.execplan.parser; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExecPlanParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExecPlanParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(ExecPlanParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(ExecPlanParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#data_range_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_range_stmt(ExecPlanParser.Data_range_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#data_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_range(ExecPlanParser.Data_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#data_type_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type_stmt(ExecPlanParser.Data_type_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#exec_query_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExec_query_stmt(ExecPlanParser.Exec_query_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#query_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_stmt(ExecPlanParser.Query_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#query_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_table(ExecPlanParser.Query_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#attr_lists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_lists(ExecPlanParser.Attr_listsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#ea_attrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEa_attrs(ExecPlanParser.Ea_attrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#ia_attrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIa_attrs(ExecPlanParser.Ia_attrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#oa_attrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOa_attrs(ExecPlanParser.Oa_attrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#pa_attrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPa_attrs(ExecPlanParser.Pa_attrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#exec_update_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExec_update_stmt(ExecPlanParser.Exec_update_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#update_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_stmt(ExecPlanParser.Update_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#update_stmt1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_stmt1(ExecPlanParser.Update_stmt1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#update_stmt2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_stmt2(ExecPlanParser.Update_stmt2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ExecPlanParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(ExecPlanParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#any_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_name(ExecPlanParser.Any_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#update_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_name(ExecPlanParser.Update_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#query_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_name(ExecPlanParser.Query_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(ExecPlanParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#attr_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_name(ExecPlanParser.Attr_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#min_num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMin_num(ExecPlanParser.Min_numContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExecPlanParser#max_num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMax_num(ExecPlanParser.Max_numContext ctx);
}