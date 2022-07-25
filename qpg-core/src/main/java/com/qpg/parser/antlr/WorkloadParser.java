// Generated from /Users/dollychen/Documents/qpg_workspace/QPG_experiment/lib/QueryPathGraph-master/qpg-core/src/main/antlr4/WorkloadParser.g4 by ANTLR 4.9.2
 package com.qpg.parser.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WorkloadParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, COMMA=2, COLON=3, SEMICOLON=4, OPEN_PAR=5, CLOSE_PAR=6, ASSIGN=7, 
		STAR=8, PLUS=9, MINUS=10, TILDE=11, PIPE2=12, DIV=13, MOD=14, LT2=15, 
		GT2=16, AMP=17, PIPE=18, LT=19, LT_EQ=20, GT=21, GT_EQ=22, EQ=23, NOT_EQ1=24, 
		NOT_EQ2=25, QUESTION_MARK=26, LBRACE=27, RBRACE=28, LBRACKET=29, RBRACKET=30, 
		SELECT=31, FROM=32, WHERE=33, REL=34, ORDER=35, BY=36, AND=37, CLASS=38, 
		DESC_=39, ASC_=40, INT_=41, STRING_=42, DATE_=43, FLOAT_=44, K_=45, HW_=46, 
		ID=47, NUMERIC_LITERAL=48, STRING_LITERAL=49, SINGLE_LINE_COMMENT=50, 
		MULTILINE_COMMENT=51, WS=52;
	public static final int
		RULE_input = 0, RULE_card_ratio = 1, RULE_class_attr = 2, RULE_attr_type = 3, 
		RULE_any_name = 4, RULE_keyword = 5, RULE_class_name = 6, RULE_attr_name = 7, 
		RULE_rel_name = 8, RULE_stmt = 9, RULE_freq = 10, RULE_classStmt = 11, 
		RULE_attr_stmt = 12, RULE_attr_pk = 13, RULE_rel_stmt = 14, RULE_queryStmt = 15, 
		RULE_tablePath = 16, RULE_table_name = 17, RULE_whereClause = 18, RULE_expr = 19, 
		RULE_orderByClause = 20, RULE_orderEle = 21, RULE_asc_desc = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"input", "card_ratio", "class_attr", "attr_type", "any_name", "keyword", 
			"class_name", "attr_name", "rel_name", "stmt", "freq", "classStmt", "attr_stmt", 
			"attr_pk", "rel_stmt", "queryStmt", "tablePath", "table_name", "whereClause", 
			"expr", "orderByClause", "orderEle", "asc_desc"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "','", "':'", "';'", "'('", "')'", "'='", "'*'", "'+'", 
			"'-'", "'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", "'|'", "'<'", 
			"'<='", "'>'", "'>='", "'=='", "'!='", "'<>'", "'?'", "'{'", "'}'", "'['", 
			"']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "COMMA", "COLON", "SEMICOLON", "OPEN_PAR", "CLOSE_PAR", 
			"ASSIGN", "STAR", "PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", 
			"GT2", "AMP", "PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", 
			"NOT_EQ2", "QUESTION_MARK", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", 
			"SELECT", "FROM", "WHERE", "REL", "ORDER", "BY", "AND", "CLASS", "DESC_", 
			"ASC_", "INT_", "STRING_", "DATE_", "FLOAT_", "K_", "HW_", "ID", "NUMERIC_LITERAL", 
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
	public String getGrammarFileName() { return "WorkloadParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WorkloadParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InputContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(WorkloadParser.EOF, 0); }
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
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitInput(this);
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
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << REL) | (1L << CLASS))) != 0)) {
				{
				{
				setState(46);
				stmt();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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

	public static class Card_ratioContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(WorkloadParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(WorkloadParser.RBRACKET, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(WorkloadParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STAR() { return getToken(WorkloadParser.STAR, 0); }
		public Card_ratioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_card_ratio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterCard_ratio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitCard_ratio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitCard_ratio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Card_ratioContext card_ratio() throws RecognitionException {
		Card_ratioContext _localctx = new Card_ratioContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_card_ratio);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(LBRACKET);
			setState(55);
			_la = _input.LA(1);
			if ( !(_la==STAR || _la==NUMERIC_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(56);
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

	public static class Class_attrContext extends ParserRuleContext {
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(WorkloadParser.DOT, 0); }
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public Class_attrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterClass_attr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitClass_attr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitClass_attr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_attrContext class_attr() throws RecognitionException {
		Class_attrContext _localctx = new Class_attrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_attr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			class_name();
			setState(59);
			match(DOT);
			setState(60);
			attr_name();
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

	public static class Attr_typeContext extends ParserRuleContext {
		public TerminalNode INT_() { return getToken(WorkloadParser.INT_, 0); }
		public TerminalNode STRING_() { return getToken(WorkloadParser.STRING_, 0); }
		public TerminalNode FLOAT_() { return getToken(WorkloadParser.FLOAT_, 0); }
		public TerminalNode DATE_() { return getToken(WorkloadParser.DATE_, 0); }
		public Attr_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterAttr_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitAttr_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitAttr_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_typeContext attr_type() throws RecognitionException {
		Attr_typeContext _localctx = new Attr_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
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

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WorkloadParser.ID, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(WorkloadParser.STRING_LITERAL, 0); }
		public TerminalNode OPEN_PAR() { return getToken(WorkloadParser.OPEN_PAR, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(WorkloadParser.CLOSE_PAR, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitAny_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitAny_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_any_name);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(ID);
				}
				break;
			case SELECT:
			case FROM:
			case WHERE:
			case REL:
			case ORDER:
			case BY:
			case AND:
			case CLASS:
			case INT_:
			case STRING_:
			case DATE_:
			case FLOAT_:
			case HW_:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				keyword();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(STRING_LITERAL);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				match(OPEN_PAR);
				setState(68);
				any_name();
				setState(69);
				match(CLOSE_PAR);
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

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(WorkloadParser.SELECT, 0); }
		public TerminalNode FROM() { return getToken(WorkloadParser.FROM, 0); }
		public TerminalNode WHERE() { return getToken(WorkloadParser.WHERE, 0); }
		public TerminalNode REL() { return getToken(WorkloadParser.REL, 0); }
		public TerminalNode ORDER() { return getToken(WorkloadParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(WorkloadParser.BY, 0); }
		public TerminalNode AND() { return getToken(WorkloadParser.AND, 0); }
		public TerminalNode CLASS() { return getToken(WorkloadParser.CLASS, 0); }
		public TerminalNode INT_() { return getToken(WorkloadParser.INT_, 0); }
		public TerminalNode STRING_() { return getToken(WorkloadParser.STRING_, 0); }
		public TerminalNode DATE_() { return getToken(WorkloadParser.DATE_, 0); }
		public TerminalNode FLOAT_() { return getToken(WorkloadParser.FLOAT_, 0); }
		public TerminalNode HW_() { return getToken(WorkloadParser.HW_, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << WHERE) | (1L << REL) | (1L << ORDER) | (1L << BY) | (1L << AND) | (1L << CLASS) | (1L << INT_) | (1L << STRING_) | (1L << DATE_) | (1L << FLOAT_) | (1L << HW_))) != 0)) ) {
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

	public static class Class_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Class_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterClass_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitClass_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitClass_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
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
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterAttr_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitAttr_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitAttr_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_nameContext attr_name() throws RecognitionException {
		Attr_nameContext _localctx = new Attr_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attr_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
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

	public static class Rel_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Rel_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterRel_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitRel_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitRel_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_nameContext rel_name() throws RecognitionException {
		Rel_nameContext _localctx = new Rel_nameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rel_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
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

	public static class StmtContext extends ParserRuleContext {
		public ClassStmtContext classStmt() {
			return getRuleContext(ClassStmtContext.class,0);
		}
		public Rel_stmtContext rel_stmt() {
			return getRuleContext(Rel_stmtContext.class,0);
		}
		public QueryStmtContext queryStmt() {
			return getRuleContext(QueryStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stmt);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				classStmt();
				}
				break;
			case REL:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				rel_stmt();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				queryStmt();
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

	public static class FreqContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(WorkloadParser.NUMERIC_LITERAL, 0); }
		public FreqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_freq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterFreq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitFreq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitFreq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FreqContext freq() throws RecognitionException {
		FreqContext _localctx = new FreqContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_freq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
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

	public static class ClassStmtContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(WorkloadParser.CLASS, 0); }
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(WorkloadParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(WorkloadParser.RBRACE, 0); }
		public List<Attr_stmtContext> attr_stmt() {
			return getRuleContexts(Attr_stmtContext.class);
		}
		public Attr_stmtContext attr_stmt(int i) {
			return getRuleContext(Attr_stmtContext.class,i);
		}
		public TerminalNode NUMERIC_LITERAL() { return getToken(WorkloadParser.NUMERIC_LITERAL, 0); }
		public List<TerminalNode> COMMA() { return getTokens(WorkloadParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WorkloadParser.COMMA, i);
		}
		public FreqContext freq() {
			return getRuleContext(FreqContext.class,0);
		}
		public ClassStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterClassStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitClassStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitClassStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassStmtContext classStmt() throws RecognitionException {
		ClassStmtContext _localctx = new ClassStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(CLASS);
			setState(89);
			class_name();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMERIC_LITERAL) {
				{
				setState(90);
				match(NUMERIC_LITERAL);
				}
			}

			setState(93);
			match(LBRACE);
			{
			setState(94);
			attr_stmt();
			}
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(95);
				match(COMMA);
				setState(96);
				attr_stmt();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(RBRACE);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMERIC_LITERAL) {
				{
				setState(103);
				freq();
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

	public static class Attr_stmtContext extends ParserRuleContext {
		public Attr_typeContext attr_type() {
			return getRuleContext(Attr_typeContext.class,0);
		}
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public TerminalNode STAR() { return getToken(WorkloadParser.STAR, 0); }
		public Attr_pkContext attr_pk() {
			return getRuleContext(Attr_pkContext.class,0);
		}
		public Attr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterAttr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitAttr_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitAttr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_stmtContext attr_stmt() throws RecognitionException {
		Attr_stmtContext _localctx = new Attr_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attr_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			attr_type();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(107);
				match(STAR);
				}
			}

			setState(110);
			attr_name();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(111);
				attr_pk();
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

	public static class Attr_pkContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(WorkloadParser.LBRACKET, 0); }
		public TerminalNode K_() { return getToken(WorkloadParser.K_, 0); }
		public TerminalNode RBRACKET() { return getToken(WorkloadParser.RBRACKET, 0); }
		public Attr_pkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_pk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterAttr_pk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitAttr_pk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitAttr_pk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_pkContext attr_pk() throws RecognitionException {
		Attr_pkContext _localctx = new Attr_pkContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_attr_pk);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(LBRACKET);
			setState(115);
			match(K_);
			setState(116);
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

	public static class Rel_stmtContext extends ParserRuleContext {
		public TerminalNode REL() { return getToken(WorkloadParser.REL, 0); }
		public Rel_nameContext rel_name() {
			return getRuleContext(Rel_nameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(WorkloadParser.COLON, 0); }
		public List<Class_nameContext> class_name() {
			return getRuleContexts(Class_nameContext.class);
		}
		public Class_nameContext class_name(int i) {
			return getRuleContext(Class_nameContext.class,i);
		}
		public List<Card_ratioContext> card_ratio() {
			return getRuleContexts(Card_ratioContext.class);
		}
		public Card_ratioContext card_ratio(int i) {
			return getRuleContext(Card_ratioContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WorkloadParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WorkloadParser.COMMA, i);
		}
		public TerminalNode SEMICOLON() { return getToken(WorkloadParser.SEMICOLON, 0); }
		public TerminalNode LBRACKET() { return getToken(WorkloadParser.LBRACKET, 0); }
		public List<Attr_stmtContext> attr_stmt() {
			return getRuleContexts(Attr_stmtContext.class);
		}
		public Attr_stmtContext attr_stmt(int i) {
			return getRuleContext(Attr_stmtContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(WorkloadParser.RBRACKET, 0); }
		public FreqContext freq() {
			return getRuleContext(FreqContext.class,0);
		}
		public Rel_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterRel_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitRel_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitRel_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_stmtContext rel_stmt() throws RecognitionException {
		Rel_stmtContext _localctx = new Rel_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rel_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(REL);
			setState(119);
			rel_name();
			setState(120);
			match(COLON);
			setState(121);
			class_name();
			setState(122);
			card_ratio();
			setState(123);
			match(COMMA);
			setState(124);
			class_name();
			setState(125);
			card_ratio();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(126);
				match(LBRACKET);
				setState(127);
				attr_stmt();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(128);
					match(COMMA);
					setState(129);
					attr_stmt();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(RBRACKET);
				}
			}

			setState(139);
			match(SEMICOLON);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMERIC_LITERAL) {
				{
				setState(140);
				freq();
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

	public static class QueryStmtContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(WorkloadParser.SELECT, 0); }
		public List<Class_attrContext> class_attr() {
			return getRuleContexts(Class_attrContext.class);
		}
		public Class_attrContext class_attr(int i) {
			return getRuleContext(Class_attrContext.class,i);
		}
		public TerminalNode FROM() { return getToken(WorkloadParser.FROM, 0); }
		public List<TablePathContext> tablePath() {
			return getRuleContexts(TablePathContext.class);
		}
		public TablePathContext tablePath(int i) {
			return getRuleContext(TablePathContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(WorkloadParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(WorkloadParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WorkloadParser.COMMA, i);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public FreqContext freq() {
			return getRuleContext(FreqContext.class,0);
		}
		public QueryStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterQueryStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitQueryStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitQueryStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryStmtContext queryStmt() throws RecognitionException {
		QueryStmtContext _localctx = new QueryStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_queryStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(SELECT);
			setState(144);
			class_attr();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(145);
				match(COMMA);
				setState(146);
				class_attr();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			match(FROM);
			setState(153);
			tablePath();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(154);
				match(COMMA);
				setState(155);
				tablePath();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(161);
				whereClause();
				}
			}

			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(164);
				orderByClause();
				}
			}

			setState(167);
			match(SEMICOLON);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMERIC_LITERAL) {
				{
				setState(168);
				freq();
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

	public static class TablePathContext extends ParserRuleContext {
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(WorkloadParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(WorkloadParser.DOT, i);
		}
		public List<Rel_nameContext> rel_name() {
			return getRuleContexts(Rel_nameContext.class);
		}
		public Rel_nameContext rel_name(int i) {
			return getRuleContext(Rel_nameContext.class,i);
		}
		public TablePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterTablePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitTablePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitTablePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePathContext tablePath() throws RecognitionException {
		TablePathContext _localctx = new TablePathContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tablePath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			table_name();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(172);
				match(DOT);
				setState(173);
				rel_name();
				setState(174);
				match(DOT);
				setState(175);
				table_name();
				}
				}
				setState(181);
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

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(WorkloadParser.ASSIGN, 0); }
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			any_name();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(183);
				match(ASSIGN);
				setState(184);
				class_name();
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

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(WorkloadParser.WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(WorkloadParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(WorkloadParser.AND, i);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_whereClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(WHERE);
			{
			setState(188);
			expr();
			}
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(189);
				match(AND);
				setState(190);
				expr();
				}
				}
				setState(195);
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

	public static class ExprContext extends ParserRuleContext {
		public Class_attrContext class_attr() {
			return getRuleContext(Class_attrContext.class,0);
		}
		public TerminalNode QUESTION_MARK() { return getToken(WorkloadParser.QUESTION_MARK, 0); }
		public TerminalNode ASSIGN() { return getToken(WorkloadParser.ASSIGN, 0); }
		public TerminalNode LT() { return getToken(WorkloadParser.LT, 0); }
		public TerminalNode GT() { return getToken(WorkloadParser.GT, 0); }
		public TerminalNode LT_EQ() { return getToken(WorkloadParser.LT_EQ, 0); }
		public TerminalNode GT_EQ() { return getToken(WorkloadParser.GT_EQ, 0); }
		public TerminalNode NOT_EQ1() { return getToken(WorkloadParser.NOT_EQ1, 0); }
		public TerminalNode NOT_EQ2() { return getToken(WorkloadParser.NOT_EQ2, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			class_attr();
			setState(197);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ) | (1L << NOT_EQ1) | (1L << NOT_EQ2))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(198);
			match(QUESTION_MARK);
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

	public static class OrderByClauseContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(WorkloadParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(WorkloadParser.BY, 0); }
		public List<OrderEleContext> orderEle() {
			return getRuleContexts(OrderEleContext.class);
		}
		public OrderEleContext orderEle(int i) {
			return getRuleContext(OrderEleContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WorkloadParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WorkloadParser.COMMA, i);
		}
		public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitOrderByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitOrderByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderByClauseContext orderByClause() throws RecognitionException {
		OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_orderByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(ORDER);
			setState(201);
			match(BY);
			setState(202);
			orderEle();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(203);
				match(COMMA);
				setState(204);
				orderEle();
				}
				}
				setState(209);
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

	public static class OrderEleContext extends ParserRuleContext {
		public Class_attrContext class_attr() {
			return getRuleContext(Class_attrContext.class,0);
		}
		public Asc_descContext asc_desc() {
			return getRuleContext(Asc_descContext.class,0);
		}
		public OrderEleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderEle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterOrderEle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitOrderEle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitOrderEle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderEleContext orderEle() throws RecognitionException {
		OrderEleContext _localctx = new OrderEleContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_orderEle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			class_attr();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESC_ || _la==ASC_) {
				{
				setState(211);
				asc_desc();
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

	public static class Asc_descContext extends ParserRuleContext {
		public TerminalNode ASC_() { return getToken(WorkloadParser.ASC_, 0); }
		public TerminalNode DESC_() { return getToken(WorkloadParser.DESC_, 0); }
		public Asc_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asc_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).enterAsc_desc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WorkloadParserListener) ((WorkloadParserListener)listener).exitAsc_desc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WorkloadParserVisitor) return ((WorkloadParserVisitor<? extends T>)visitor).visitAsc_desc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asc_descContext asc_desc() throws RecognitionException {
		Asc_descContext _localctx = new Asc_descContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_asc_desc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_la = _input.LA(1);
			if ( !(_la==DESC_ || _la==ASC_) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u00db\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6J\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\5\13W\n\13\3\f\3\f\3\r\3\r\3\r\5\r^\n\r\3\r\3\r\3\r\3"+
		"\r\7\rd\n\r\f\r\16\rg\13\r\3\r\3\r\5\rk\n\r\3\16\3\16\5\16o\n\16\3\16"+
		"\3\16\5\16s\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u0085\n\20\f\20\16\20\u0088\13\20\3\20"+
		"\3\20\5\20\u008c\n\20\3\20\3\20\5\20\u0090\n\20\3\21\3\21\3\21\3\21\7"+
		"\21\u0096\n\21\f\21\16\21\u0099\13\21\3\21\3\21\3\21\3\21\7\21\u009f\n"+
		"\21\f\21\16\21\u00a2\13\21\3\21\5\21\u00a5\n\21\3\21\5\21\u00a8\n\21\3"+
		"\21\3\21\5\21\u00ac\n\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00b4\n\22"+
		"\f\22\16\22\u00b7\13\22\3\23\3\23\3\23\5\23\u00bc\n\23\3\24\3\24\3\24"+
		"\3\24\7\24\u00c2\n\24\f\24\16\24\u00c5\13\24\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\7\26\u00d0\n\26\f\26\16\26\u00d3\13\26\3\27\3\27"+
		"\5\27\u00d7\n\27\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\2\7\4\2\n\n\62\62\3\2+.\5\2!(+.\60\60\5\2\t\t\25\30\32"+
		"\33\3\2)*\2\u00db\2\63\3\2\2\2\48\3\2\2\2\6<\3\2\2\2\b@\3\2\2\2\nI\3\2"+
		"\2\2\fK\3\2\2\2\16M\3\2\2\2\20O\3\2\2\2\22Q\3\2\2\2\24V\3\2\2\2\26X\3"+
		"\2\2\2\30Z\3\2\2\2\32l\3\2\2\2\34t\3\2\2\2\36x\3\2\2\2 \u0091\3\2\2\2"+
		"\"\u00ad\3\2\2\2$\u00b8\3\2\2\2&\u00bd\3\2\2\2(\u00c6\3\2\2\2*\u00ca\3"+
		"\2\2\2,\u00d4\3\2\2\2.\u00d8\3\2\2\2\60\62\5\24\13\2\61\60\3\2\2\2\62"+
		"\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66"+
		"\67\7\2\2\3\67\3\3\2\2\289\7\37\2\29:\t\2\2\2:;\7 \2\2;\5\3\2\2\2<=\5"+
		"\16\b\2=>\7\3\2\2>?\5\20\t\2?\7\3\2\2\2@A\t\3\2\2A\t\3\2\2\2BJ\7\61\2"+
		"\2CJ\5\f\7\2DJ\7\63\2\2EF\7\7\2\2FG\5\n\6\2GH\7\b\2\2HJ\3\2\2\2IB\3\2"+
		"\2\2IC\3\2\2\2ID\3\2\2\2IE\3\2\2\2J\13\3\2\2\2KL\t\4\2\2L\r\3\2\2\2MN"+
		"\5\n\6\2N\17\3\2\2\2OP\5\n\6\2P\21\3\2\2\2QR\5\n\6\2R\23\3\2\2\2SW\5\30"+
		"\r\2TW\5\36\20\2UW\5 \21\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\25\3\2\2\2X"+
		"Y\7\62\2\2Y\27\3\2\2\2Z[\7(\2\2[]\5\16\b\2\\^\7\62\2\2]\\\3\2\2\2]^\3"+
		"\2\2\2^_\3\2\2\2_`\7\35\2\2`e\5\32\16\2ab\7\4\2\2bd\5\32\16\2ca\3\2\2"+
		"\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hj\7\36\2\2ik\5\26"+
		"\f\2ji\3\2\2\2jk\3\2\2\2k\31\3\2\2\2ln\5\b\5\2mo\7\n\2\2nm\3\2\2\2no\3"+
		"\2\2\2op\3\2\2\2pr\5\20\t\2qs\5\34\17\2rq\3\2\2\2rs\3\2\2\2s\33\3\2\2"+
		"\2tu\7\37\2\2uv\7/\2\2vw\7 \2\2w\35\3\2\2\2xy\7$\2\2yz\5\22\n\2z{\7\5"+
		"\2\2{|\5\16\b\2|}\5\4\3\2}~\7\4\2\2~\177\5\16\b\2\177\u008b\5\4\3\2\u0080"+
		"\u0081\7\37\2\2\u0081\u0086\5\32\16\2\u0082\u0083\7\4\2\2\u0083\u0085"+
		"\5\32\16\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2"+
		"\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a"+
		"\7 \2\2\u008a\u008c\3\2\2\2\u008b\u0080\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008f\7\6\2\2\u008e\u0090\5\26\f\2\u008f\u008e\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\37\3\2\2\2\u0091\u0092\7!\2\2\u0092\u0097"+
		"\5\6\4\2\u0093\u0094\7\4\2\2\u0094\u0096\5\6\4\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\"\2\2\u009b\u00a0\5\"\22\2\u009c"+
		"\u009d\7\4\2\2\u009d\u009f\5\"\22\2\u009e\u009c\3\2\2\2\u009f\u00a2\3"+
		"\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u00a5\5&\24\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a8\5*\26\2\u00a7\u00a6\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\7\6\2\2\u00aa\u00ac\5\26"+
		"\f\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac!\3\2\2\2\u00ad\u00b5"+
		"\5$\23\2\u00ae\u00af\7\3\2\2\u00af\u00b0\5\22\n\2\u00b0\u00b1\7\3\2\2"+
		"\u00b1\u00b2\5$\23\2\u00b2\u00b4\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b4\u00b7"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6#\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00bb\5\n\6\2\u00b9\u00ba\7\t\2\2\u00ba\u00bc\5\16"+
		"\b\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc%\3\2\2\2\u00bd\u00be"+
		"\7#\2\2\u00be\u00c3\5(\25\2\u00bf\u00c0\7\'\2\2\u00c0\u00c2\5(\25\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\'\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\5\6\4\2\u00c7\u00c8"+
		"\t\5\2\2\u00c8\u00c9\7\34\2\2\u00c9)\3\2\2\2\u00ca\u00cb\7%\2\2\u00cb"+
		"\u00cc\7&\2\2\u00cc\u00d1\5,\27\2\u00cd\u00ce\7\4\2\2\u00ce\u00d0\5,\27"+
		"\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2+\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d6\5\6\4\2\u00d5"+
		"\u00d7\5.\30\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7-\3\2\2\2"+
		"\u00d8\u00d9\t\6\2\2\u00d9/\3\2\2\2\27\63IV]ejnr\u0086\u008b\u008f\u0097"+
		"\u00a0\u00a4\u00a7\u00ab\u00b5\u00bb\u00c3\u00d1\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}