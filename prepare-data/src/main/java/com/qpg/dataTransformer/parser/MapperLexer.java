// Generated from MapperLexer.g4 by ANTLR 4.9
 package com.qpg.dataTransformer.parser; 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapperLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMA=2, LBRACE=3, RBRACE=4, LPAR=5, RPAR=6, ASSIGN=7, QUESTION_MARK=8, 
		TARGET_=9, CF_=10, DOC_=11, KV_=12, SQL_=13, ISLIST_=14, ID=15, NUMERIC_LITERAL=16, 
		STRING_LITERAL=17, SINGLE_LINE_COMMENT=18, MULTILINE_COMMENT=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COLON", "COMMA", "LBRACE", "RBRACE", "LPAR", "RPAR", "ASSIGN", "QUESTION_MARK", 
			"TARGET_", "CF_", "DOC_", "KV_", "SQL_", "ISLIST_", "ID", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "A", "B", 
			"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "HEX_DIGIT", "DIGIT", 
			"LETTER", "WS"
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


	public MapperLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MapperLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u012f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\7\20\u0094\n\20\f\20\16"+
		"\20\u0097\13\20\3\21\6\21\u009a\n\21\r\21\16\21\u009b\3\21\3\21\7\21\u00a0"+
		"\n\21\f\21\16\21\u00a3\13\21\5\21\u00a5\n\21\3\21\3\21\6\21\u00a9\n\21"+
		"\r\21\16\21\u00aa\5\21\u00ad\n\21\3\21\3\21\5\21\u00b1\n\21\3\21\6\21"+
		"\u00b4\n\21\r\21\16\21\u00b5\5\21\u00b8\n\21\3\21\3\21\3\21\3\21\6\21"+
		"\u00be\n\21\r\21\16\21\u00bf\5\21\u00c2\n\21\3\22\3\22\3\22\3\22\7\22"+
		"\u00c8\n\22\f\22\16\22\u00cb\13\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23"+
		"\u00d3\n\23\f\23\16\23\u00d6\13\23\3\23\5\23\u00d9\n\23\3\23\3\23\5\23"+
		"\u00dd\n\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00e5\n\24\f\24\16\24\u00e8"+
		"\13\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\6\62\u012a\n"+
		"\62\r\62\16\62\u012b\3\62\3\62\3\u00e6\2\63\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\2+\2"+
		"-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U"+
		"\2W\2Y\2[\2]\2_\2a\2c\26\3\2%\6\2&&C\\aac|\7\2&&\62;C\\aac|\4\2--//\3"+
		"\2))\4\2\f\f\17\17\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2"+
		"IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4"+
		"\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZz"+
		"z\4\2[[{{\4\2\\\\||\4\2\62;CH\3\2\62;\4\2C\\c|\5\2\13\f\17\17\"\"\2\u0123"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5g\3\2\2\2\7i\3\2\2"+
		"\2\tk\3\2\2\2\13m\3\2\2\2\ro\3\2\2\2\17q\3\2\2\2\21s\3\2\2\2\23u\3\2\2"+
		"\2\25|\3\2\2\2\27\177\3\2\2\2\31\u0083\3\2\2\2\33\u0086\3\2\2\2\35\u008a"+
		"\3\2\2\2\37\u0091\3\2\2\2!\u00c1\3\2\2\2#\u00c3\3\2\2\2%\u00ce\3\2\2\2"+
		"\'\u00e0\3\2\2\2)\u00ee\3\2\2\2+\u00f0\3\2\2\2-\u00f2\3\2\2\2/\u00f4\3"+
		"\2\2\2\61\u00f6\3\2\2\2\63\u00f8\3\2\2\2\65\u00fa\3\2\2\2\67\u00fc\3\2"+
		"\2\29\u00fe\3\2\2\2;\u0100\3\2\2\2=\u0102\3\2\2\2?\u0104\3\2\2\2A\u0106"+
		"\3\2\2\2C\u0108\3\2\2\2E\u010a\3\2\2\2G\u010c\3\2\2\2I\u010e\3\2\2\2K"+
		"\u0110\3\2\2\2M\u0112\3\2\2\2O\u0114\3\2\2\2Q\u0116\3\2\2\2S\u0118\3\2"+
		"\2\2U\u011a\3\2\2\2W\u011c\3\2\2\2Y\u011e\3\2\2\2[\u0120\3\2\2\2]\u0122"+
		"\3\2\2\2_\u0124\3\2\2\2a\u0126\3\2\2\2c\u0129\3\2\2\2ef\7<\2\2f\4\3\2"+
		"\2\2gh\7.\2\2h\6\3\2\2\2ij\7}\2\2j\b\3\2\2\2kl\7\177\2\2l\n\3\2\2\2mn"+
		"\7*\2\2n\f\3\2\2\2op\7+\2\2p\16\3\2\2\2qr\7?\2\2r\20\3\2\2\2st\7A\2\2"+
		"t\22\3\2\2\2uv\5O(\2vw\5)\25\2wx\5K&\2xy\5\65\33\2yz\5\61\31\2z{\5O(\2"+
		"{\24\3\2\2\2|}\5-\27\2}~\5\63\32\2~\26\3\2\2\2\177\u0080\5/\30\2\u0080"+
		"\u0081\5E#\2\u0081\u0082\5-\27\2\u0082\30\3\2\2\2\u0083\u0084\5=\37\2"+
		"\u0084\u0085\5S*\2\u0085\32\3\2\2\2\u0086\u0087\5M\'\2\u0087\u0088\5I"+
		"%\2\u0088\u0089\5? \2\u0089\34\3\2\2\2\u008a\u008b\59\35\2\u008b\u008c"+
		"\5M\'\2\u008c\u008d\5? \2\u008d\u008e\59\35\2\u008e\u008f\5M\'\2\u008f"+
		"\u0090\5O(\2\u0090\36\3\2\2\2\u0091\u0095\t\2\2\2\u0092\u0094\t\3\2\2"+
		"\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096 \3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\5_\60\2\u0099"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u00a4\3\2\2\2\u009d\u00a1\7\60\2\2\u009e\u00a0\5_\60\2\u009f"+
		"\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u009d\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00ad\3\2\2\2\u00a6\u00a8\7\60\2\2\u00a7\u00a9\5"+
		"_\60\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u0099\3\2\2\2\u00ac\u00a6\3\2"+
		"\2\2\u00ad\u00b7\3\2\2\2\u00ae\u00b0\5\61\31\2\u00af\u00b1\t\4\2\2\u00b0"+
		"\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b4\5_"+
		"\60\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00ae\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\u00c2\3\2\2\2\u00b9\u00ba\7\62\2\2\u00ba\u00bb\7z\2\2\u00bb"+
		"\u00bd\3\2\2\2\u00bc\u00be\5]/\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2"+
		"\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00ac"+
		"\3\2\2\2\u00c1\u00b9\3\2\2\2\u00c2\"\3\2\2\2\u00c3\u00c9\7)\2\2\u00c4"+
		"\u00c8\n\5\2\2\u00c5\u00c6\7)\2\2\u00c6\u00c8\7)\2\2\u00c7\u00c4\3\2\2"+
		"\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7)\2\2\u00cd"+
		"$\3\2\2\2\u00ce\u00cf\7/\2\2\u00cf\u00d0\7/\2\2\u00d0\u00d4\3\2\2\2\u00d1"+
		"\u00d3\n\6\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00dc\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00d9\7\17\2\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3"+
		"\2\2\2\u00da\u00dd\7\f\2\2\u00db\u00dd\7\2\2\3\u00dc\u00d8\3\2\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\b\23\2\2\u00df&\3\2\2\2"+
		"\u00e0\u00e1\7\61\2\2\u00e1\u00e2\7,\2\2\u00e2\u00e6\3\2\2\2\u00e3\u00e5"+
		"\13\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e7\3\2\2\2"+
		"\u00e6\u00e4\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea"+
		"\7,\2\2\u00ea\u00eb\7\61\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\b\24\2\2"+
		"\u00ed(\3\2\2\2\u00ee\u00ef\t\7\2\2\u00ef*\3\2\2\2\u00f0\u00f1\t\b\2\2"+
		"\u00f1,\3\2\2\2\u00f2\u00f3\t\t\2\2\u00f3.\3\2\2\2\u00f4\u00f5\t\n\2\2"+
		"\u00f5\60\3\2\2\2\u00f6\u00f7\t\13\2\2\u00f7\62\3\2\2\2\u00f8\u00f9\t"+
		"\f\2\2\u00f9\64\3\2\2\2\u00fa\u00fb\t\r\2\2\u00fb\66\3\2\2\2\u00fc\u00fd"+
		"\t\16\2\2\u00fd8\3\2\2\2\u00fe\u00ff\t\17\2\2\u00ff:\3\2\2\2\u0100\u0101"+
		"\t\20\2\2\u0101<\3\2\2\2\u0102\u0103\t\21\2\2\u0103>\3\2\2\2\u0104\u0105"+
		"\t\22\2\2\u0105@\3\2\2\2\u0106\u0107\t\23\2\2\u0107B\3\2\2\2\u0108\u0109"+
		"\t\24\2\2\u0109D\3\2\2\2\u010a\u010b\t\25\2\2\u010bF\3\2\2\2\u010c\u010d"+
		"\t\26\2\2\u010dH\3\2\2\2\u010e\u010f\t\27\2\2\u010fJ\3\2\2\2\u0110\u0111"+
		"\t\30\2\2\u0111L\3\2\2\2\u0112\u0113\t\31\2\2\u0113N\3\2\2\2\u0114\u0115"+
		"\t\32\2\2\u0115P\3\2\2\2\u0116\u0117\t\33\2\2\u0117R\3\2\2\2\u0118\u0119"+
		"\t\34\2\2\u0119T\3\2\2\2\u011a\u011b\t\35\2\2\u011bV\3\2\2\2\u011c\u011d"+
		"\t\36\2\2\u011dX\3\2\2\2\u011e\u011f\t\37\2\2\u011fZ\3\2\2\2\u0120\u0121"+
		"\t \2\2\u0121\\\3\2\2\2\u0122\u0123\t!\2\2\u0123^\3\2\2\2\u0124\u0125"+
		"\t\"\2\2\u0125`\3\2\2\2\u0126\u0127\t#\2\2\u0127b\3\2\2\2\u0128\u012a"+
		"\t$\2\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\b\62\3\2\u012ed\3\2\2\2"+
		"\25\2\u0095\u009b\u00a1\u00a4\u00aa\u00ac\u00b0\u00b5\u00b7\u00bf\u00c1"+
		"\u00c7\u00c9\u00d4\u00d8\u00dc\u00e6\u012b\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}