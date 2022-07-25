// Generated from /Users/dollychen/Documents/qpg_workspace/QPG_experiment/lib/QueryPathGraph-master/qpg-core/src/main/antlr4/WorkloadParser.g4 by ANTLR 4.9.2
 package com.qpg.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WorkloadParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WorkloadParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(WorkloadParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#card_ratio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCard_ratio(WorkloadParser.Card_ratioContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#class_attr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_attr(WorkloadParser.Class_attrContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#attr_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_type(WorkloadParser.Attr_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#any_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_name(WorkloadParser.Any_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(WorkloadParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#class_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_name(WorkloadParser.Class_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#attr_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_name(WorkloadParser.Attr_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#rel_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_name(WorkloadParser.Rel_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(WorkloadParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#freq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFreq(WorkloadParser.FreqContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#classStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassStmt(WorkloadParser.ClassStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#attr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_stmt(WorkloadParser.Attr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#attr_pk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_pk(WorkloadParser.Attr_pkContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#rel_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_stmt(WorkloadParser.Rel_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#queryStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryStmt(WorkloadParser.QueryStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#tablePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablePath(WorkloadParser.TablePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(WorkloadParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(WorkloadParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(WorkloadParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(WorkloadParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#orderEle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderEle(WorkloadParser.OrderEleContext ctx);
	/**
	 * Visit a parse tree produced by {@link WorkloadParser#asc_desc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsc_desc(WorkloadParser.Asc_descContext ctx);
}