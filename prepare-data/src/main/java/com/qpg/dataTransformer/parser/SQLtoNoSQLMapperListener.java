// Generated from SQLtoNoSQLMapper.g4 by ANTLR 4.9
 package com.qpg.dataTransformer.parser; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLtoNoSQLMapper}.
 */
public interface SQLtoNoSQLMapperListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLtoNoSQLMapper#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(SQLtoNoSQLMapper.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLtoNoSQLMapper#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(SQLtoNoSQLMapper.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLtoNoSQLMapper#tree}.
	 * @param ctx the parse tree
	 */
	void enterTree(SQLtoNoSQLMapper.TreeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLtoNoSQLMapper#tree}.
	 * @param ctx the parse tree
	 */
	void exitTree(SQLtoNoSQLMapper.TreeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLtoNoSQLMapper#tree_node}.
	 * @param ctx the parse tree
	 */
	void enterTree_node(SQLtoNoSQLMapper.Tree_nodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLtoNoSQLMapper#tree_node}.
	 * @param ctx the parse tree
	 */
	void exitTree_node(SQLtoNoSQLMapper.Tree_nodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLtoNoSQLMapper#node_name}.
	 * @param ctx the parse tree
	 */
	void enterNode_name(SQLtoNoSQLMapper.Node_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLtoNoSQLMapper#node_name}.
	 * @param ctx the parse tree
	 */
	void exitNode_name(SQLtoNoSQLMapper.Node_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLtoNoSQLMapper#children_node}.
	 * @param ctx the parse tree
	 */
	void enterChildren_node(SQLtoNoSQLMapper.Children_nodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLtoNoSQLMapper#children_node}.
	 * @param ctx the parse tree
	 */
	void exitChildren_node(SQLtoNoSQLMapper.Children_nodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLtoNoSQLMapper#bound_attrs}.
	 * @param ctx the parse tree
	 */
	void enterBound_attrs(SQLtoNoSQLMapper.Bound_attrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLtoNoSQLMapper#bound_attrs}.
	 * @param ctx the parse tree
	 */
	void exitBound_attrs(SQLtoNoSQLMapper.Bound_attrsContext ctx);
}