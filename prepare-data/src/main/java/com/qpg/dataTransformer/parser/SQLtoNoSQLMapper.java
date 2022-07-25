// Generated from SQLtoNoSQLMapper.g4 by ANTLR 4.9
 package com.qpg.dataTransformer.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLtoNoSQLMapper extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMA=2, LBRACE=3, RBRACE=4, LPAR=5, RPAR=6, ASSIGN=7, QUESTION_MARK=8, 
		TARGET_=9, CF_=10, DOC_=11, KV_=12, SQL_=13, ISLIST_=14, ID=15, NUMERIC_LITERAL=16, 
		STRING_LITERAL=17, SINGLE_LINE_COMMENT=18, MULTILINE_COMMENT=19, WS=20;
	public static final int
		RULE_input = 0, RULE_tree = 1, RULE_tree_node = 2, RULE_node_name = 3, 
		RULE_children_node = 4, RULE_bound_attrs = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"input", "tree", "tree_node", "node_name", "children_node", "bound_attrs"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "'{'", "'}'", "'('", "')'", "'='", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COLON", "COMMA", "LBRACE", "RBRACE", "LPAR", "RPAR", "ASSIGN", 
			"QUESTION_MARK", "TARGET_", "CF_", "DOC_", "KV_", "SQL_", "ISLIST_", 
			"ID", "NUMERIC_LITERAL", "STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SQLtoNoSQLMapper.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLtoNoSQLMapper(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InputContext extends ParserRuleContext {
		public TerminalNode TARGET_() { return getToken(SQLtoNoSQLMapper.TARGET_, 0); }
		public TerminalNode COLON() { return getToken(SQLtoNoSQLMapper.COLON, 0); }
		public TerminalNode CF_() { return getToken(SQLtoNoSQLMapper.CF_, 0); }
		public TerminalNode DOC_() { return getToken(SQLtoNoSQLMapper.DOC_, 0); }
		public TerminalNode KV_() { return getToken(SQLtoNoSQLMapper.KV_, 0); }
		public List<TreeContext> tree() {
			return getRuleContexts(TreeContext.class);
		}
		public TreeContext tree(int i) {
			return getRuleContext(TreeContext.class,i);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLtoNoSQLMapperVisitor ) return ((SQLtoNoSQLMapperVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(TARGET_);
			setState(13);
			match(COLON);
			setState(14);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CF_) | (1L << DOC_) | (1L << KV_))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(15);
				tree();
				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TreeContext extends ParserRuleContext {
		public Tree_nodeContext tree_node() {
			return getRuleContext(Tree_nodeContext.class,0);
		}
		public TreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tree; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).enterTree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).exitTree(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLtoNoSQLMapperVisitor ) return ((SQLtoNoSQLMapperVisitor<? extends T>)visitor).visitTree(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TreeContext tree() throws RecognitionException {
		TreeContext _localctx = new TreeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			tree_node();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tree_nodeContext extends ParserRuleContext {
		public Node_nameContext node_name() {
			return getRuleContext(Node_nameContext.class,0);
		}
		public TerminalNode SQL_() { return getToken(SQLtoNoSQLMapper.SQL_, 0); }
		public TerminalNode COLON() { return getToken(SQLtoNoSQLMapper.COLON, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLtoNoSQLMapper.STRING_LITERAL, 0); }
		public TerminalNode ISLIST_() { return getToken(SQLtoNoSQLMapper.ISLIST_, 0); }
		public Bound_attrsContext bound_attrs() {
			return getRuleContext(Bound_attrsContext.class,0);
		}
		public Children_nodeContext children_node() {
			return getRuleContext(Children_nodeContext.class,0);
		}
		public Tree_nodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tree_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).enterTree_node(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).exitTree_node(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLtoNoSQLMapperVisitor ) return ((SQLtoNoSQLMapperVisitor<? extends T>)visitor).visitTree_node(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tree_nodeContext tree_node() throws RecognitionException {
		Tree_nodeContext _localctx = new Tree_nodeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tree_node);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			node_name();
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ISLIST_) {
				{
				setState(24);
				match(ISLIST_);
				}
			}

			{
			setState(27);
			match(SQL_);
			setState(28);
			match(COLON);
			setState(29);
			match(STRING_LITERAL);
			}
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(31);
				bound_attrs();
				}
			}

			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(34);
				children_node();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Node_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLtoNoSQLMapper.ID, 0); }
		public Node_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).enterNode_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).exitNode_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLtoNoSQLMapperVisitor ) return ((SQLtoNoSQLMapperVisitor<? extends T>)visitor).visitNode_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Node_nameContext node_name() throws RecognitionException {
		Node_nameContext _localctx = new Node_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_node_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Children_nodeContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(SQLtoNoSQLMapper.LBRACE, 0); }
		public List<Tree_nodeContext> tree_node() {
			return getRuleContexts(Tree_nodeContext.class);
		}
		public Tree_nodeContext tree_node(int i) {
			return getRuleContext(Tree_nodeContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(SQLtoNoSQLMapper.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLtoNoSQLMapper.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLtoNoSQLMapper.COMMA, i);
		}
		public Children_nodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_children_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).enterChildren_node(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).exitChildren_node(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLtoNoSQLMapperVisitor ) return ((SQLtoNoSQLMapperVisitor<? extends T>)visitor).visitChildren_node(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Children_nodeContext children_node() throws RecognitionException {
		Children_nodeContext _localctx = new Children_nodeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_children_node);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(LBRACE);
			setState(40);
			tree_node();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(41);
				match(COMMA);
				setState(42);
				tree_node();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bound_attrsContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(SQLtoNoSQLMapper.LPAR, 0); }
		public List<TerminalNode> ID() { return getTokens(SQLtoNoSQLMapper.ID); }
		public TerminalNode ID(int i) {
			return getToken(SQLtoNoSQLMapper.ID, i);
		}
		public TerminalNode RPAR() { return getToken(SQLtoNoSQLMapper.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLtoNoSQLMapper.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLtoNoSQLMapper.COMMA, i);
		}
		public Bound_attrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bound_attrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).enterBound_attrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLtoNoSQLMapperListener ) ((SQLtoNoSQLMapperListener)listener).exitBound_attrs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLtoNoSQLMapperVisitor ) return ((SQLtoNoSQLMapperVisitor<? extends T>)visitor).visitBound_attrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bound_attrsContext bound_attrs() throws RecognitionException {
		Bound_attrsContext _localctx = new Bound_attrsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bound_attrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(LPAR);
			setState(51);
			match(ID);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(52);
				match(COMMA);
				setState(53);
				match(ID);
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\7\2\23\n\2\f\2\16\2"+
		"\26\13\2\3\3\3\3\3\4\3\4\5\4\34\n\4\3\4\3\4\3\4\3\4\3\4\5\4#\n\4\3\4\5"+
		"\4&\n\4\3\5\3\5\3\6\3\6\3\6\3\6\7\6.\n\6\f\6\16\6\61\13\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\7\79\n\7\f\7\16\7<\13\7\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\3"+
		"\3\2\f\16\2?\2\16\3\2\2\2\4\27\3\2\2\2\6\31\3\2\2\2\b\'\3\2\2\2\n)\3\2"+
		"\2\2\f\64\3\2\2\2\16\17\7\13\2\2\17\20\7\3\2\2\20\24\t\2\2\2\21\23\5\4"+
		"\3\2\22\21\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\3\3\2"+
		"\2\2\26\24\3\2\2\2\27\30\5\6\4\2\30\5\3\2\2\2\31\33\5\b\5\2\32\34\7\20"+
		"\2\2\33\32\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7\17\2\2\36\37\7"+
		"\3\2\2\37 \7\23\2\2 \"\3\2\2\2!#\5\f\7\2\"!\3\2\2\2\"#\3\2\2\2#%\3\2\2"+
		"\2$&\5\n\6\2%$\3\2\2\2%&\3\2\2\2&\7\3\2\2\2\'(\7\21\2\2(\t\3\2\2\2)*\7"+
		"\5\2\2*/\5\6\4\2+,\7\4\2\2,.\5\6\4\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/"+
		"\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\6\2\2\63\13\3\2\2\2\64\65"+
		"\7\7\2\2\65:\7\21\2\2\66\67\7\4\2\2\679\7\21\2\28\66\3\2\2\29<\3\2\2\2"+
		":8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7\b\2\2>\r\3\2\2\2\b\24\33"+
		"\"%/:";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}