// Generated from /Users/dollychen/Documents/qpg_workspace/QPG_experiment/lib/QueryPathGraph-master/workload-expr/src/main/antlr4/ExecPlanParser.g4 by ANTLR 4.9.2
 package com.qpg.expr.execplan.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExecPlanParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMA=2, LBRACKET=3, RBRACKET=4, LBRACE=5, RBRACE=6, LPAR=7, 
		RPAR=8, OP=9, DATA_=10, TYPE_=11, RANGE_=12, EXEC_=13, QUERY_=14, UPDATE_=15, 
		FILTER_=16, INSERT_=17, INT_=18, STRING_=19, DATE_=20, FLOAT_=21, ID=22, 
		NUMERIC_LITERAL=23, STRING_LITERAL=24, SINGLE_LINE_COMMENT=25, MULTILINE_COMMENT=26, 
		WS=27;
	public static final int
		RULE_input = 0, RULE_stmt = 1, RULE_data_range_stmt = 2, RULE_data_range = 3, 
		RULE_data_type_stmt = 4, RULE_exec_query_stmt = 5, RULE_query_stmt = 6, 
		RULE_query_table = 7, RULE_attr_lists = 8, RULE_ea_attrs = 9, RULE_ia_attrs = 10, 
		RULE_oa_attrs = 11, RULE_pa_attrs = 12, RULE_exec_update_stmt = 13, RULE_update_stmt = 14, 
		RULE_type = 15, RULE_keyword = 16, RULE_any_name = 17, RULE_update_name = 18, 
		RULE_query_name = 19, RULE_table_name = 20, RULE_attr_name = 21, RULE_min_num = 22, 
		RULE_max_num = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"input", "stmt", "data_range_stmt", "data_range", "data_type_stmt", "exec_query_stmt", 
			"query_stmt", "query_table", "attr_lists", "ea_attrs", "ia_attrs", "oa_attrs", 
			"pa_attrs", "exec_update_stmt", "update_stmt", "type", "keyword", "any_name", 
			"update_name", "query_name", "table_name", "attr_name", "min_num", "max_num"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "'['", "']'", "'{'", "'}'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COLON", "COMMA", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LPAR", 
			"RPAR", "OP", "DATA_", "TYPE_", "RANGE_", "EXEC_", "QUERY_", "UPDATE_", 
			"FILTER_", "INSERT_", "INT_", "STRING_", "DATE_", "FLOAT_", "ID", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "WS"
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
	public String getGrammarFileName() { return "ExecPlanParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExecPlanParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InputContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExecPlanParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitInput(this);
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
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DATA_ || _la==EXEC_) {
				{
				{
				setState(48);
				stmt();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(EOF);
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

	public static class StmtContext extends ParserRuleContext {
		public Data_type_stmtContext data_type_stmt() {
			return getRuleContext(Data_type_stmtContext.class,0);
		}
		public Data_range_stmtContext data_range_stmt() {
			return getRuleContext(Data_range_stmtContext.class,0);
		}
		public Exec_query_stmtContext exec_query_stmt() {
			return getRuleContext(Exec_query_stmtContext.class,0);
		}
		public Exec_update_stmtContext exec_update_stmt() {
			return getRuleContext(Exec_update_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				data_type_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				data_range_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				exec_query_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				exec_update_stmt();
				}
				break;
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

	public static class Data_range_stmtContext extends ParserRuleContext {
		public TerminalNode DATA_() { return getToken(ExecPlanParser.DATA_, 0); }
		public TerminalNode RANGE_() { return getToken(ExecPlanParser.RANGE_, 0); }
		public TerminalNode LBRACE() { return getToken(ExecPlanParser.LBRACE, 0); }
		public List<Data_rangeContext> data_range() {
			return getRuleContexts(Data_rangeContext.class);
		}
		public Data_rangeContext data_range(int i) {
			return getRuleContext(Data_rangeContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(ExecPlanParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ExecPlanParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExecPlanParser.COMMA, i);
		}
		public Data_range_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_range_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterData_range_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitData_range_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitData_range_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_range_stmtContext data_range_stmt() throws RecognitionException {
		Data_range_stmtContext _localctx = new Data_range_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data_range_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(DATA_);
			setState(63);
			match(RANGE_);
			setState(64);
			match(LBRACE);
			setState(65);
			data_range();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(66);
				match(COMMA);
				setState(67);
				data_range();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
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

	public static class Data_rangeContext extends ParserRuleContext {
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ExecPlanParser.COLON, 0); }
		public TerminalNode LBRACKET() { return getToken(ExecPlanParser.LBRACKET, 0); }
		public Min_numContext min_num() {
			return getRuleContext(Min_numContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ExecPlanParser.COMMA, 0); }
		public Max_numContext max_num() {
			return getRuleContext(Max_numContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(ExecPlanParser.RBRACKET, 0); }
		public Data_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterData_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitData_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitData_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_rangeContext data_range() throws RecognitionException {
		Data_rangeContext _localctx = new Data_rangeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_data_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			attr_name();
			setState(76);
			match(COLON);
			setState(77);
			match(LBRACKET);
			setState(78);
			min_num();
			setState(79);
			match(COMMA);
			setState(80);
			max_num();
			setState(81);
			match(RBRACKET);
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

	public static class Data_type_stmtContext extends ParserRuleContext {
		public TerminalNode DATA_() { return getToken(ExecPlanParser.DATA_, 0); }
		public TerminalNode TYPE_() { return getToken(ExecPlanParser.TYPE_, 0); }
		public TerminalNode LBRACE() { return getToken(ExecPlanParser.LBRACE, 0); }
		public List<Attr_nameContext> attr_name() {
			return getRuleContexts(Attr_nameContext.class);
		}
		public Attr_nameContext attr_name(int i) {
			return getRuleContext(Attr_nameContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(ExecPlanParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ExecPlanParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExecPlanParser.COMMA, i);
		}
		public Data_type_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterData_type_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitData_type_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitData_type_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_type_stmtContext data_type_stmt() throws RecognitionException {
		Data_type_stmtContext _localctx = new Data_type_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_data_type_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(DATA_);
			setState(84);
			match(TYPE_);
			setState(85);
			match(LBRACE);
			setState(86);
			attr_name();
			setState(87);
			type();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(88);
				match(COMMA);
				setState(89);
				attr_name();
				setState(90);
				type();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
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

	public static class Exec_query_stmtContext extends ParserRuleContext {
		public TerminalNode EXEC_() { return getToken(ExecPlanParser.EXEC_, 0); }
		public TerminalNode QUERY_() { return getToken(ExecPlanParser.QUERY_, 0); }
		public Query_nameContext query_name() {
			return getRuleContext(Query_nameContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ExecPlanParser.LBRACE, 0); }
		public List<Query_stmtContext> query_stmt() {
			return getRuleContexts(Query_stmtContext.class);
		}
		public Query_stmtContext query_stmt(int i) {
			return getRuleContext(Query_stmtContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(ExecPlanParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ExecPlanParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExecPlanParser.COMMA, i);
		}
		public Exec_query_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exec_query_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterExec_query_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitExec_query_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitExec_query_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exec_query_stmtContext exec_query_stmt() throws RecognitionException {
		Exec_query_stmtContext _localctx = new Exec_query_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exec_query_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(EXEC_);
			setState(100);
			match(QUERY_);
			setState(101);
			query_name();
			setState(102);
			match(LBRACE);
			setState(103);
			query_stmt();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(104);
				match(COMMA);
				setState(105);
				query_stmt();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
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

	public static class Query_stmtContext extends ParserRuleContext {
		public Query_tableContext query_table() {
			return getRuleContext(Query_tableContext.class,0);
		}
		public TerminalNode FILTER_() { return getToken(ExecPlanParser.FILTER_, 0); }
		public Ia_attrsContext ia_attrs() {
			return getRuleContext(Ia_attrsContext.class,0);
		}
		public Query_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterQuery_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitQuery_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitQuery_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Query_stmtContext query_stmt() throws RecognitionException {
		Query_stmtContext _localctx = new Query_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_query_stmt);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_:
			case RANGE_:
			case EXEC_:
			case QUERY_:
			case UPDATE_:
			case INSERT_:
			case ID:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				query_table();
				}
				break;
			case FILTER_:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(114);
				match(FILTER_);
				setState(115);
				ia_attrs();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Query_tableContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Ea_attrsContext ea_attrs() {
			return getRuleContext(Ea_attrsContext.class,0);
		}
		public Ia_attrsContext ia_attrs() {
			return getRuleContext(Ia_attrsContext.class,0);
		}
		public Oa_attrsContext oa_attrs() {
			return getRuleContext(Oa_attrsContext.class,0);
		}
		public Pa_attrsContext pa_attrs() {
			return getRuleContext(Pa_attrsContext.class,0);
		}
		public List<Attr_nameContext> attr_name() {
			return getRuleContexts(Attr_nameContext.class);
		}
		public Attr_nameContext attr_name(int i) {
			return getRuleContext(Attr_nameContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(ExecPlanParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ExecPlanParser.COLON, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExecPlanParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExecPlanParser.COMMA, i);
		}
		public Query_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterQuery_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitQuery_table(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitQuery_table(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Query_tableContext query_table() throws RecognitionException {
		Query_tableContext _localctx = new Query_tableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_query_table);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			table_name();
			setState(119);
			ea_attrs();
			setState(120);
			ia_attrs();
			setState(121);
			oa_attrs();
			setState(122);
			pa_attrs();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATA_) | (1L << RANGE_) | (1L << EXEC_) | (1L << QUERY_) | (1L << UPDATE_) | (1L << INSERT_) | (1L << ID) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(123);
				attr_name();
				setState(124);
				match(COLON);
				setState(125);
				attr_name();
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(126);
						match(COMMA);
						setState(127);
						attr_name();
						setState(128);
						match(COLON);
						setState(129);
						attr_name();
						}
						} 
					}
					setState(135);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
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

	public static class Attr_listsContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ExecPlanParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ExecPlanParser.RBRACKET, 0); }
		public List<Attr_nameContext> attr_name() {
			return getRuleContexts(Attr_nameContext.class);
		}
		public Attr_nameContext attr_name(int i) {
			return getRuleContext(Attr_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExecPlanParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExecPlanParser.COMMA, i);
		}
		public Attr_listsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_lists; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterAttr_lists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitAttr_lists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitAttr_lists(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_listsContext attr_lists() throws RecognitionException {
		Attr_listsContext _localctx = new Attr_listsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attr_lists);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(LBRACKET);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATA_) | (1L << RANGE_) | (1L << EXEC_) | (1L << QUERY_) | (1L << UPDATE_) | (1L << INSERT_) | (1L << ID) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(139);
				attr_name();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(140);
					match(COMMA);
					setState(141);
					attr_name();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(149);
			match(RBRACKET);
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

	public static class Ea_attrsContext extends ParserRuleContext {
		public Attr_listsContext attr_lists() {
			return getRuleContext(Attr_listsContext.class,0);
		}
		public Ea_attrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ea_attrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterEa_attrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitEa_attrs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitEa_attrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ea_attrsContext ea_attrs() throws RecognitionException {
		Ea_attrsContext _localctx = new Ea_attrsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ea_attrs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			attr_lists();
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

	public static class Ia_attrsContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ExecPlanParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ExecPlanParser.RBRACKET, 0); }
		public List<Attr_nameContext> attr_name() {
			return getRuleContexts(Attr_nameContext.class);
		}
		public Attr_nameContext attr_name(int i) {
			return getRuleContext(Attr_nameContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(ExecPlanParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(ExecPlanParser.OP, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExecPlanParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExecPlanParser.COMMA, i);
		}
		public Ia_attrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ia_attrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterIa_attrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitIa_attrs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitIa_attrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ia_attrsContext ia_attrs() throws RecognitionException {
		Ia_attrsContext _localctx = new Ia_attrsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ia_attrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(LBRACKET);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATA_) | (1L << RANGE_) | (1L << EXEC_) | (1L << QUERY_) | (1L << UPDATE_) | (1L << INSERT_) | (1L << ID) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(154);
				attr_name();
				setState(155);
				match(OP);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(156);
					match(COMMA);
					setState(157);
					attr_name();
					setState(158);
					match(OP);
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(167);
			match(RBRACKET);
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

	public static class Oa_attrsContext extends ParserRuleContext {
		public Attr_listsContext attr_lists() {
			return getRuleContext(Attr_listsContext.class,0);
		}
		public Oa_attrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oa_attrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterOa_attrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitOa_attrs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitOa_attrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Oa_attrsContext oa_attrs() throws RecognitionException {
		Oa_attrsContext _localctx = new Oa_attrsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_oa_attrs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			attr_lists();
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

	public static class Pa_attrsContext extends ParserRuleContext {
		public Attr_listsContext attr_lists() {
			return getRuleContext(Attr_listsContext.class,0);
		}
		public Pa_attrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pa_attrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterPa_attrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitPa_attrs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitPa_attrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pa_attrsContext pa_attrs() throws RecognitionException {
		Pa_attrsContext _localctx = new Pa_attrsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pa_attrs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			attr_lists();
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

	public static class Exec_update_stmtContext extends ParserRuleContext {
		public TerminalNode EXEC_() { return getToken(ExecPlanParser.EXEC_, 0); }
		public TerminalNode UPDATE_() { return getToken(ExecPlanParser.UPDATE_, 0); }
		public Update_nameContext update_name() {
			return getRuleContext(Update_nameContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ExecPlanParser.LBRACE, 0); }
		public List<Update_stmtContext> update_stmt() {
			return getRuleContexts(Update_stmtContext.class);
		}
		public Update_stmtContext update_stmt(int i) {
			return getRuleContext(Update_stmtContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(ExecPlanParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ExecPlanParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExecPlanParser.COMMA, i);
		}
		public Exec_update_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exec_update_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterExec_update_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitExec_update_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitExec_update_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exec_update_stmtContext exec_update_stmt() throws RecognitionException {
		Exec_update_stmtContext _localctx = new Exec_update_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exec_update_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(EXEC_);
			setState(174);
			match(UPDATE_);
			setState(175);
			update_name();
			setState(176);
			match(LBRACE);
			setState(177);
			update_stmt();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(178);
				match(COMMA);
				setState(179);
				update_stmt();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
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

	public static class Update_stmtContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(ExecPlanParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ExecPlanParser.RBRACKET, 0); }
		public TerminalNode UPDATE_() { return getToken(ExecPlanParser.UPDATE_, 0); }
		public TerminalNode INSERT_() { return getToken(ExecPlanParser.INSERT_, 0); }
		public TerminalNode QUERY_() { return getToken(ExecPlanParser.QUERY_, 0); }
		public Ea_attrsContext ea_attrs() {
			return getRuleContext(Ea_attrsContext.class,0);
		}
		public List<Attr_nameContext> attr_name() {
			return getRuleContexts(Attr_nameContext.class);
		}
		public Attr_nameContext attr_name(int i) {
			return getRuleContext(Attr_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExecPlanParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExecPlanParser.COMMA, i);
		}
		public Update_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterUpdate_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitUpdate_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitUpdate_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_stmtContext update_stmt() throws RecognitionException {
		Update_stmtContext _localctx = new Update_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_update_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			table_name();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUERY_) {
				{
				setState(188);
				match(QUERY_);
				setState(189);
				ea_attrs();
				}
			}

			setState(192);
			_la = _input.LA(1);
			if ( !(_la==UPDATE_ || _la==INSERT_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(193);
			match(LBRACKET);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATA_) | (1L << RANGE_) | (1L << EXEC_) | (1L << QUERY_) | (1L << UPDATE_) | (1L << INSERT_) | (1L << ID) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(194);
				attr_name();
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(195);
					match(COMMA);
					setState(196);
					attr_name();
					}
					}
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(204);
			match(RBRACKET);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT_() { return getToken(ExecPlanParser.INT_, 0); }
		public TerminalNode DATE_() { return getToken(ExecPlanParser.DATE_, 0); }
		public TerminalNode STRING_() { return getToken(ExecPlanParser.STRING_, 0); }
		public TerminalNode FLOAT_() { return getToken(ExecPlanParser.FLOAT_, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_) | (1L << STRING_) | (1L << DATE_) | (1L << FLOAT_))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode DATA_() { return getToken(ExecPlanParser.DATA_, 0); }
		public TerminalNode RANGE_() { return getToken(ExecPlanParser.RANGE_, 0); }
		public TerminalNode EXEC_() { return getToken(ExecPlanParser.EXEC_, 0); }
		public TerminalNode QUERY_() { return getToken(ExecPlanParser.QUERY_, 0); }
		public TerminalNode UPDATE_() { return getToken(ExecPlanParser.UPDATE_, 0); }
		public TerminalNode INSERT_() { return getToken(ExecPlanParser.INSERT_, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATA_) | (1L << RANGE_) | (1L << EXEC_) | (1L << QUERY_) | (1L << UPDATE_) | (1L << INSERT_))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExecPlanParser.ID, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(ExecPlanParser.STRING_LITERAL, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitAny_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitAny_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_any_name);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(ID);
				}
				break;
			case DATA_:
			case RANGE_:
			case EXEC_:
			case QUERY_:
			case UPDATE_:
			case INSERT_:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				keyword();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Update_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Update_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterUpdate_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitUpdate_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitUpdate_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_nameContext update_name() throws RecognitionException {
		Update_nameContext _localctx = new Update_nameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_update_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			any_name();
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

	public static class Query_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Query_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterQuery_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitQuery_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitQuery_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Query_nameContext query_name() throws RecognitionException {
		Query_nameContext _localctx = new Query_nameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_query_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			any_name();
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

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			any_name();
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

	public static class Attr_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Attr_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterAttr_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitAttr_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitAttr_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_nameContext attr_name() throws RecognitionException {
		Attr_nameContext _localctx = new Attr_nameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_attr_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			any_name();
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

	public static class Min_numContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(ExecPlanParser.NUMERIC_LITERAL, 0); }
		public Min_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_min_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterMin_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitMin_num(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitMin_num(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Min_numContext min_num() throws RecognitionException {
		Min_numContext _localctx = new Min_numContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_min_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(NUMERIC_LITERAL);
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

	public static class Max_numContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(ExecPlanParser.NUMERIC_LITERAL, 0); }
		public Max_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).enterMax_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExecPlanParserListener ) ((ExecPlanParserListener)listener).exitMax_num(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExecPlanParserVisitor ) return ((ExecPlanParserVisitor<? extends T>)visitor).visitMax_num(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Max_numContext max_num() throws RecognitionException {
		Max_numContext _localctx = new Max_numContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_max_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(NUMERIC_LITERAL);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00e6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3?\n\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6_\n\6\f\6\16\6b"+
		"\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3\7"+
		"\3\7\3\b\3\b\3\b\5\bw\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\7\t\u0086\n\t\f\t\16\t\u0089\13\t\5\t\u008b\n\t\3\n\3\n\3\n\3"+
		"\n\7\n\u0091\n\n\f\n\16\n\u0094\13\n\5\n\u0096\n\n\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00a3\n\f\f\f\16\f\u00a6\13\f\5\f\u00a8"+
		"\n\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u00b7\n\17\f\17\16\17\u00ba\13\17\3\17\3\17\3\20\3\20\3\20\5\20\u00c1"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\7\20\u00c8\n\20\f\20\16\20\u00cb\13\20"+
		"\5\20\u00cd\n\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\5\23\u00d8"+
		"\n\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31"+
		"\2\2\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\5\4\2\21"+
		"\21\23\23\3\2\24\27\5\2\f\f\16\21\23\23\2\u00e1\2\65\3\2\2\2\4>\3\2\2"+
		"\2\6@\3\2\2\2\bM\3\2\2\2\nU\3\2\2\2\fe\3\2\2\2\16v\3\2\2\2\20x\3\2\2\2"+
		"\22\u008c\3\2\2\2\24\u0099\3\2\2\2\26\u009b\3\2\2\2\30\u00ab\3\2\2\2\32"+
		"\u00ad\3\2\2\2\34\u00af\3\2\2\2\36\u00bd\3\2\2\2 \u00d0\3\2\2\2\"\u00d2"+
		"\3\2\2\2$\u00d7\3\2\2\2&\u00d9\3\2\2\2(\u00db\3\2\2\2*\u00dd\3\2\2\2,"+
		"\u00df\3\2\2\2.\u00e1\3\2\2\2\60\u00e3\3\2\2\2\62\64\5\4\3\2\63\62\3\2"+
		"\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2"+
		"\289\7\2\2\39\3\3\2\2\2:?\5\n\6\2;?\5\6\4\2<?\5\f\7\2=?\5\34\17\2>:\3"+
		"\2\2\2>;\3\2\2\2><\3\2\2\2>=\3\2\2\2?\5\3\2\2\2@A\7\f\2\2AB\7\16\2\2B"+
		"C\7\7\2\2CH\5\b\5\2DE\7\4\2\2EG\5\b\5\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2"+
		"HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\b\2\2L\7\3\2\2\2MN\5,\27\2NO\7\3\2"+
		"\2OP\7\5\2\2PQ\5.\30\2QR\7\4\2\2RS\5\60\31\2ST\7\6\2\2T\t\3\2\2\2UV\7"+
		"\f\2\2VW\7\r\2\2WX\7\7\2\2XY\5,\27\2Y`\5 \21\2Z[\7\4\2\2[\\\5,\27\2\\"+
		"]\5 \21\2]_\3\2\2\2^Z\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2"+
		"b`\3\2\2\2cd\7\b\2\2d\13\3\2\2\2ef\7\17\2\2fg\7\20\2\2gh\5(\25\2hi\7\7"+
		"\2\2in\5\16\b\2jk\7\4\2\2km\5\16\b\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3"+
		"\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7\b\2\2r\r\3\2\2\2sw\5\20\t\2tu\7\22\2\2"+
		"uw\5\26\f\2vs\3\2\2\2vt\3\2\2\2w\17\3\2\2\2xy\5*\26\2yz\5\24\13\2z{\5"+
		"\26\f\2{|\5\30\r\2|\u008a\5\32\16\2}~\5,\27\2~\177\7\3\2\2\177\u0087\5"+
		",\27\2\u0080\u0081\7\4\2\2\u0081\u0082\5,\27\2\u0082\u0083\7\3\2\2\u0083"+
		"\u0084\5,\27\2\u0084\u0086\3\2\2\2\u0085\u0080\3\2\2\2\u0086\u0089\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008b\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u008a}\3\2\2\2\u008a\u008b\3\2\2\2\u008b\21\3\2\2\2\u008c"+
		"\u0095\7\5\2\2\u008d\u0092\5,\27\2\u008e\u008f\7\4\2\2\u008f\u0091\5,"+
		"\27\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u008d\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7\6\2\2\u0098"+
		"\23\3\2\2\2\u0099\u009a\5\22\n\2\u009a\25\3\2\2\2\u009b\u00a7\7\5\2\2"+
		"\u009c\u009d\5,\27\2\u009d\u00a4\7\13\2\2\u009e\u009f\7\4\2\2\u009f\u00a0"+
		"\5,\27\2\u00a0\u00a1\7\13\2\2\u00a1\u00a3\3\2\2\2\u00a2\u009e\3\2\2\2"+
		"\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u009c\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\7\6\2\2\u00aa\27\3\2\2\2\u00ab\u00ac\5\22\n"+
		"\2\u00ac\31\3\2\2\2\u00ad\u00ae\5\22\n\2\u00ae\33\3\2\2\2\u00af\u00b0"+
		"\7\17\2\2\u00b0\u00b1\7\21\2\2\u00b1\u00b2\5&\24\2\u00b2\u00b3\7\7\2\2"+
		"\u00b3\u00b8\5\36\20\2\u00b4\u00b5\7\4\2\2\u00b5\u00b7\5\36\20\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7\b\2\2\u00bc"+
		"\35\3\2\2\2\u00bd\u00c0\5*\26\2\u00be\u00bf\7\20\2\2\u00bf\u00c1\5\24"+
		"\13\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c3\t\2\2\2\u00c3\u00cc\7\5\2\2\u00c4\u00c9\5,\27\2\u00c5\u00c6\7\4"+
		"\2\2\u00c6\u00c8\5,\27\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cc\u00c4\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\7\6\2\2\u00cf\37\3\2\2\2\u00d0\u00d1\t\3\2\2\u00d1!\3\2\2\2\u00d2"+
		"\u00d3\t\4\2\2\u00d3#\3\2\2\2\u00d4\u00d8\7\30\2\2\u00d5\u00d8\5\"\22"+
		"\2\u00d6\u00d8\7\32\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8%\3\2\2\2\u00d9\u00da\5$\23\2\u00da\'\3\2\2\2\u00db"+
		"\u00dc\5$\23\2\u00dc)\3\2\2\2\u00dd\u00de\5$\23\2\u00de+\3\2\2\2\u00df"+
		"\u00e0\5$\23\2\u00e0-\3\2\2\2\u00e1\u00e2\7\31\2\2\u00e2/\3\2\2\2\u00e3"+
		"\u00e4\7\31\2\2\u00e4\61\3\2\2\2\23\65>H`nv\u0087\u008a\u0092\u0095\u00a4"+
		"\u00a7\u00b8\u00c0\u00c9\u00cc\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}