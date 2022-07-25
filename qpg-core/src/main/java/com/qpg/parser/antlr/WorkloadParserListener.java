// Generated from /Users/dollychen/Documents/qpg_workspace/QPG_experiment/lib/QueryPathGraph-master/qpg-core/src/main/antlr4/WorkloadParser.g4 by ANTLR 4.9.2
 package com.qpg.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WorkloadParser}.
 */
public interface WorkloadParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(WorkloadParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(WorkloadParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#card_ratio}.
	 * @param ctx the parse tree
	 */
	void enterCard_ratio(WorkloadParser.Card_ratioContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#card_ratio}.
	 * @param ctx the parse tree
	 */
	void exitCard_ratio(WorkloadParser.Card_ratioContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#class_attr}.
	 * @param ctx the parse tree
	 */
	void enterClass_attr(WorkloadParser.Class_attrContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#class_attr}.
	 * @param ctx the parse tree
	 */
	void exitClass_attr(WorkloadParser.Class_attrContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void enterAttr_type(WorkloadParser.Attr_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void exitAttr_type(WorkloadParser.Attr_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#any_name}.
	 * @param ctx the parse tree
	 */
	void enterAny_name(WorkloadParser.Any_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#any_name}.
	 * @param ctx the parse tree
	 */
	void exitAny_name(WorkloadParser.Any_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(WorkloadParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(WorkloadParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#class_name}.
	 * @param ctx the parse tree
	 */
	void enterClass_name(WorkloadParser.Class_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#class_name}.
	 * @param ctx the parse tree
	 */
	void exitClass_name(WorkloadParser.Class_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void enterAttr_name(WorkloadParser.Attr_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void exitAttr_name(WorkloadParser.Attr_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#rel_name}.
	 * @param ctx the parse tree
	 */
	void enterRel_name(WorkloadParser.Rel_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#rel_name}.
	 * @param ctx the parse tree
	 */
	void exitRel_name(WorkloadParser.Rel_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(WorkloadParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(WorkloadParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#freq}.
	 * @param ctx the parse tree
	 */
	void enterFreq(WorkloadParser.FreqContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#freq}.
	 * @param ctx the parse tree
	 */
	void exitFreq(WorkloadParser.FreqContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#classStmt}.
	 * @param ctx the parse tree
	 */
	void enterClassStmt(WorkloadParser.ClassStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#classStmt}.
	 * @param ctx the parse tree
	 */
	void exitClassStmt(WorkloadParser.ClassStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#attr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAttr_stmt(WorkloadParser.Attr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#attr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAttr_stmt(WorkloadParser.Attr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#attr_pk}.
	 * @param ctx the parse tree
	 */
	void enterAttr_pk(WorkloadParser.Attr_pkContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#attr_pk}.
	 * @param ctx the parse tree
	 */
	void exitAttr_pk(WorkloadParser.Attr_pkContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#rel_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRel_stmt(WorkloadParser.Rel_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#rel_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRel_stmt(WorkloadParser.Rel_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#queryStmt}.
	 * @param ctx the parse tree
	 */
	void enterQueryStmt(WorkloadParser.QueryStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#queryStmt}.
	 * @param ctx the parse tree
	 */
	void exitQueryStmt(WorkloadParser.QueryStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#tablePath}.
	 * @param ctx the parse tree
	 */
	void enterTablePath(WorkloadParser.TablePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#tablePath}.
	 * @param ctx the parse tree
	 */
	void exitTablePath(WorkloadParser.TablePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(WorkloadParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(WorkloadParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(WorkloadParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(WorkloadParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(WorkloadParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(WorkloadParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(WorkloadParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(WorkloadParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#orderEle}.
	 * @param ctx the parse tree
	 */
	void enterOrderEle(WorkloadParser.OrderEleContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#orderEle}.
	 * @param ctx the parse tree
	 */
	void exitOrderEle(WorkloadParser.OrderEleContext ctx);
	/**
	 * Enter a parse tree produced by {@link WorkloadParser#asc_desc}.
	 * @param ctx the parse tree
	 */
	void enterAsc_desc(WorkloadParser.Asc_descContext ctx);
	/**
	 * Exit a parse tree produced by {@link WorkloadParser#asc_desc}.
	 * @param ctx the parse tree
	 */
	void exitAsc_desc(WorkloadParser.Asc_descContext ctx);
}