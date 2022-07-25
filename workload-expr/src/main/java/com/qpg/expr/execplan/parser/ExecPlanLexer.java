// Generated from /Users/dollychen/Documents/qpg_workspace/QPG_experiment/lib/QueryPathGraph-master/workload-expr/src/main/antlr4/ExecPlanLexer.g4 by ANTLR 4.9.2
 package com.qpg.expr.execplan.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExecPlanLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COLON", "COMMA", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LPAR", 
			"RPAR", "OP", "DATA_", "TYPE_", "RANGE_", "EXEC_", "QUERY_", "UPDATE_", 
			"FILTER_", "INSERT_", "INT_", "STRING_", "DATE_", "FLOAT_", "ID", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "A", "B", 
			"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "HEX_DIGIT", "DIGIT", 
			"LETTER", "WS"
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


	public ExecPlanLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExecPlanLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u0174\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u008f\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\7\27\u00d9\n\27\f\27\16\27\u00dc\13\27"+
		"\3\30\6\30\u00df\n\30\r\30\16\30\u00e0\3\30\3\30\7\30\u00e5\n\30\f\30"+
		"\16\30\u00e8\13\30\5\30\u00ea\n\30\3\30\3\30\6\30\u00ee\n\30\r\30\16\30"+
		"\u00ef\5\30\u00f2\n\30\3\30\3\30\5\30\u00f6\n\30\3\30\6\30\u00f9\n\30"+
		"\r\30\16\30\u00fa\5\30\u00fd\n\30\3\30\3\30\3\30\3\30\6\30\u0103\n\30"+
		"\r\30\16\30\u0104\5\30\u0107\n\30\3\31\3\31\3\31\3\31\7\31\u010d\n\31"+
		"\f\31\16\31\u0110\13\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u0118\n\32"+
		"\f\32\16\32\u011b\13\32\3\32\5\32\u011e\n\32\3\32\3\32\5\32\u0122\n\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u012a\n\33\f\33\16\33\u012d\13\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64"+
		"\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\69\u016f\n9\r9\169\u0170"+
		"\39\39\3\u012b\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a"+
		"\2c\2e\2g\2i\2k\2m\2o\2q\35\3\2%\7\2&&\60\60C\\aac|\b\2&&\60\60\62;C\\"+
		"aac|\4\2--//\3\2))\4\2\f\f\17\17\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2G"+
		"Ggg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4"+
		"\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXx"+
		"x\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\4\2\62;CH\3\2\62;\4\2C\\c|\5\2\13"+
		"\f\17\17\"\"\2\u016e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2q\3\2\2"+
		"\2\3s\3\2\2\2\5u\3\2\2\2\7w\3\2\2\2\ty\3\2\2\2\13{\3\2\2\2\r}\3\2\2\2"+
		"\17\177\3\2\2\2\21\u0081\3\2\2\2\23\u008e\3\2\2\2\25\u0090\3\2\2\2\27"+
		"\u0095\3\2\2\2\31\u009a\3\2\2\2\33\u00a0\3\2\2\2\35\u00a5\3\2\2\2\37\u00ab"+
		"\3\2\2\2!\u00b2\3\2\2\2#\u00b9\3\2\2\2%\u00c0\3\2\2\2\'\u00c4\3\2\2\2"+
		")\u00cb\3\2\2\2+\u00d0\3\2\2\2-\u00d6\3\2\2\2/\u0106\3\2\2\2\61\u0108"+
		"\3\2\2\2\63\u0113\3\2\2\2\65\u0125\3\2\2\2\67\u0133\3\2\2\29\u0135\3\2"+
		"\2\2;\u0137\3\2\2\2=\u0139\3\2\2\2?\u013b\3\2\2\2A\u013d\3\2\2\2C\u013f"+
		"\3\2\2\2E\u0141\3\2\2\2G\u0143\3\2\2\2I\u0145\3\2\2\2K\u0147\3\2\2\2M"+
		"\u0149\3\2\2\2O\u014b\3\2\2\2Q\u014d\3\2\2\2S\u014f\3\2\2\2U\u0151\3\2"+
		"\2\2W\u0153\3\2\2\2Y\u0155\3\2\2\2[\u0157\3\2\2\2]\u0159\3\2\2\2_\u015b"+
		"\3\2\2\2a\u015d\3\2\2\2c\u015f\3\2\2\2e\u0161\3\2\2\2g\u0163\3\2\2\2i"+
		"\u0165\3\2\2\2k\u0167\3\2\2\2m\u0169\3\2\2\2o\u016b\3\2\2\2q\u016e\3\2"+
		"\2\2st\7<\2\2t\4\3\2\2\2uv\7.\2\2v\6\3\2\2\2wx\7]\2\2x\b\3\2\2\2yz\7_"+
		"\2\2z\n\3\2\2\2{|\7}\2\2|\f\3\2\2\2}~\7\177\2\2~\16\3\2\2\2\177\u0080"+
		"\7*\2\2\u0080\20\3\2\2\2\u0081\u0082\7+\2\2\u0082\22\3\2\2\2\u0083\u008f"+
		"\7>\2\2\u0084\u0085\7>\2\2\u0085\u008f\7?\2\2\u0086\u008f\7@\2\2\u0087"+
		"\u0088\7@\2\2\u0088\u008f\7?\2\2\u0089\u008a\7#\2\2\u008a\u008f\7?\2\2"+
		"\u008b\u008c\7>\2\2\u008c\u008f\7@\2\2\u008d\u008f\7?\2\2\u008e\u0083"+
		"\3\2\2\2\u008e\u0084\3\2\2\2\u008e\u0086\3\2\2\2\u008e\u0087\3\2\2\2\u008e"+
		"\u0089\3\2\2\2\u008e\u008b\3\2\2\2\u008e\u008d\3\2\2\2\u008f\24\3\2\2"+
		"\2\u0090\u0091\5=\37\2\u0091\u0092\5\67\34\2\u0092\u0093\5]/\2\u0093\u0094"+
		"\5\67\34\2\u0094\26\3\2\2\2\u0095\u0096\5]/\2\u0096\u0097\5g\64\2\u0097"+
		"\u0098\5U+\2\u0098\u0099\5? \2\u0099\30\3\2\2\2\u009a\u009b\5Y-\2\u009b"+
		"\u009c\5\67\34\2\u009c\u009d\5Q)\2\u009d\u009e\5C\"\2\u009e\u009f\5? "+
		"\2\u009f\32\3\2\2\2\u00a0\u00a1\5? \2\u00a1\u00a2\5e\63\2\u00a2\u00a3"+
		"\5? \2\u00a3\u00a4\5;\36\2\u00a4\34\3\2\2\2\u00a5\u00a6\5W,\2\u00a6\u00a7"+
		"\5_\60\2\u00a7\u00a8\5? \2\u00a8\u00a9\5Y-\2\u00a9\u00aa\5g\64\2\u00aa"+
		"\36\3\2\2\2\u00ab\u00ac\5_\60\2\u00ac\u00ad\5U+\2\u00ad\u00ae\5=\37\2"+
		"\u00ae\u00af\5\67\34\2\u00af\u00b0\5]/\2\u00b0\u00b1\5? \2\u00b1 \3\2"+
		"\2\2\u00b2\u00b3\5A!\2\u00b3\u00b4\5G$\2\u00b4\u00b5\5M\'\2\u00b5\u00b6"+
		"\5]/\2\u00b6\u00b7\5? \2\u00b7\u00b8\5Y-\2\u00b8\"\3\2\2\2\u00b9\u00ba"+
		"\5G$\2\u00ba\u00bb\5Q)\2\u00bb\u00bc\5[.\2\u00bc\u00bd\5? \2\u00bd\u00be"+
		"\5Y-\2\u00be\u00bf\5]/\2\u00bf$\3\2\2\2\u00c0\u00c1\5G$\2\u00c1\u00c2"+
		"\5Q)\2\u00c2\u00c3\5]/\2\u00c3&\3\2\2\2\u00c4\u00c5\5[.\2\u00c5\u00c6"+
		"\5]/\2\u00c6\u00c7\5Y-\2\u00c7\u00c8\5G$\2\u00c8\u00c9\5Q)\2\u00c9\u00ca"+
		"\5C\"\2\u00ca(\3\2\2\2\u00cb\u00cc\5=\37\2\u00cc\u00cd\5\67\34\2\u00cd"+
		"\u00ce\5]/\2\u00ce\u00cf\5? \2\u00cf*\3\2\2\2\u00d0\u00d1\5A!\2\u00d1"+
		"\u00d2\5M\'\2\u00d2\u00d3\5S*\2\u00d3\u00d4\5\67\34\2\u00d4\u00d5\5]/"+
		"\2\u00d5,\3\2\2\2\u00d6\u00da\t\2\2\2\u00d7\u00d9\t\3\2\2\u00d8\u00d7"+
		"\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		".\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df\5m\67\2\u00de\u00dd\3\2\2\2"+
		"\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e9"+
		"\3\2\2\2\u00e2\u00e6\7\60\2\2\u00e3\u00e5\5m\67\2\u00e4\u00e3\3\2\2\2"+
		"\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ea"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00e2\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00f2\3\2\2\2\u00eb\u00ed\7\60\2\2\u00ec\u00ee\5m\67\2\u00ed\u00ec\3"+
		"\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f2\3\2\2\2\u00f1\u00de\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f2\u00fc\3\2"+
		"\2\2\u00f3\u00f5\5? \2\u00f4\u00f6\t\4\2\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f9\5m\67\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2"+
		"\2\2\u00fc\u00f3\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0107\3\2\2\2\u00fe"+
		"\u00ff\7\62\2\2\u00ff\u0100\7z\2\2\u0100\u0102\3\2\2\2\u0101\u0103\5k"+
		"\66\2\u0102\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u00f1\3\2\2\2\u0106\u00fe\3\2"+
		"\2\2\u0107\60\3\2\2\2\u0108\u010e\7)\2\2\u0109\u010d\n\5\2\2\u010a\u010b"+
		"\7)\2\2\u010b\u010d\7)\2\2\u010c\u0109\3\2\2\2\u010c\u010a\3\2\2\2\u010d"+
		"\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2"+
		"\2\2\u0110\u010e\3\2\2\2\u0111\u0112\7)\2\2\u0112\62\3\2\2\2\u0113\u0114"+
		"\7/\2\2\u0114\u0115\7/\2\2\u0115\u0119\3\2\2\2\u0116\u0118\n\6\2\2\u0117"+
		"\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u0121\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011e\7\17\2\2\u011d"+
		"\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0122\7\f"+
		"\2\2\u0120\u0122\7\2\2\3\u0121\u011d\3\2\2\2\u0121\u0120\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0124\b\32\2\2\u0124\64\3\2\2\2\u0125\u0126\7\61"+
		"\2\2\u0126\u0127\7,\2\2\u0127\u012b\3\2\2\2\u0128\u012a\13\2\2\2\u0129"+
		"\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u012c\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7,\2\2\u012f"+
		"\u0130\7\61\2\2\u0130\u0131\3\2\2\2\u0131\u0132\b\33\2\2\u0132\66\3\2"+
		"\2\2\u0133\u0134\t\7\2\2\u01348\3\2\2\2\u0135\u0136\t\b\2\2\u0136:\3\2"+
		"\2\2\u0137\u0138\t\t\2\2\u0138<\3\2\2\2\u0139\u013a\t\n\2\2\u013a>\3\2"+
		"\2\2\u013b\u013c\t\13\2\2\u013c@\3\2\2\2\u013d\u013e\t\f\2\2\u013eB\3"+
		"\2\2\2\u013f\u0140\t\r\2\2\u0140D\3\2\2\2\u0141\u0142\t\16\2\2\u0142F"+
		"\3\2\2\2\u0143\u0144\t\17\2\2\u0144H\3\2\2\2\u0145\u0146\t\20\2\2\u0146"+
		"J\3\2\2\2\u0147\u0148\t\21\2\2\u0148L\3\2\2\2\u0149\u014a\t\22\2\2\u014a"+
		"N\3\2\2\2\u014b\u014c\t\23\2\2\u014cP\3\2\2\2\u014d\u014e\t\24\2\2\u014e"+
		"R\3\2\2\2\u014f\u0150\t\25\2\2\u0150T\3\2\2\2\u0151\u0152\t\26\2\2\u0152"+
		"V\3\2\2\2\u0153\u0154\t\27\2\2\u0154X\3\2\2\2\u0155\u0156\t\30\2\2\u0156"+
		"Z\3\2\2\2\u0157\u0158\t\31\2\2\u0158\\\3\2\2\2\u0159\u015a\t\32\2\2\u015a"+
		"^\3\2\2\2\u015b\u015c\t\33\2\2\u015c`\3\2\2\2\u015d\u015e\t\34\2\2\u015e"+
		"b\3\2\2\2\u015f\u0160\t\35\2\2\u0160d\3\2\2\2\u0161\u0162\t\36\2\2\u0162"+
		"f\3\2\2\2\u0163\u0164\t\37\2\2\u0164h\3\2\2\2\u0165\u0166\t \2\2\u0166"+
		"j\3\2\2\2\u0167\u0168\t!\2\2\u0168l\3\2\2\2\u0169\u016a\t\"\2\2\u016a"+
		"n\3\2\2\2\u016b\u016c\t#\2\2\u016cp\3\2\2\2\u016d\u016f\t$\2\2\u016e\u016d"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171"+
		"\u0172\3\2\2\2\u0172\u0173\b9\3\2\u0173r\3\2\2\2\26\2\u008e\u00da\u00e0"+
		"\u00e6\u00e9\u00ef\u00f1\u00f5\u00fa\u00fc\u0104\u0106\u010c\u010e\u0119"+
		"\u011d\u0121\u012b\u0170\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}