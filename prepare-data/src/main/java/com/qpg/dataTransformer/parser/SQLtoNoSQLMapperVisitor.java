// Generated from SQLtoNoSQLMapper.g4 by ANTLR 4.9
 package com.qpg.dataTransformer.parser; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLtoNoSQLMapper}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLtoNoSQLMapperVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SQLtoNoSQLMapper#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(SQLtoNoSQLMapper.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLtoNoSQLMapper#tree}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTree(SQLtoNoSQLMapper.TreeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLtoNoSQLMapper#tree_node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTree_node(SQLtoNoSQLMapper.Tree_nodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLtoNoSQLMapper#node_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode_name(SQLtoNoSQLMapper.Node_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLtoNoSQLMapper#children_node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildren_node(SQLtoNoSQLMapper.Children_nodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLtoNoSQLMapper#bound_attrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBound_attrs(SQLtoNoSQLMapper.Bound_attrsContext ctx);
}