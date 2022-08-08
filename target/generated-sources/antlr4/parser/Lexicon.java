// Generated from Lexicon.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Lexicon extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, FLOAT=2, IDENT=3, LINE_COMMENT=4, MULTILINE_COMMENT=5, WHITESPACE=6, 
		CHAR=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'"
	};
	public static final String[] ruleNames = {
		"INT", "FLOAT", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE", 
		"CHAR"
	};


	public Lexicon(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexicon.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tS\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\3\3\6\3\30\n\3\r\3\16\3\31\3\3\3\3\6\3\36\n\3\r\3\16\3\37\3\4\3\4"+
		"\7\4$\n\4\f\4\16\4\'\13\4\3\5\3\5\3\5\3\5\7\5-\n\5\f\5\16\5\60\13\5\3"+
		"\5\5\5\63\n\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6;\n\6\f\6\16\6>\13\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\6\7F\n\7\r\7\16\7G\3\7\3\7\3\b\3\b\3\b\3\b\5\bP\n\b\3"+
		"\b\3\b\4.<\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\7\3\2\62;\4\2C\\c|\6"+
		"\2\62;C\\aac|\3\3\f\f\5\2\13\f\17\17\"\"Z\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\22\3\2\2"+
		"\2\5\27\3\2\2\2\7!\3\2\2\2\t(\3\2\2\2\13\66\3\2\2\2\rE\3\2\2\2\17K\3\2"+
		"\2\2\21\23\t\2\2\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2"+
		"\2\2\25\4\3\2\2\2\26\30\t\2\2\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2"+
		"\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33\35\7\60\2\2\34\36\t\2\2\2\35\34\3"+
		"\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \6\3\2\2\2!%\t\3\2\2\""+
		"$\t\4\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\b\3\2\2\2\'%\3\2"+
		"\2\2()\7\61\2\2)*\7\61\2\2*.\3\2\2\2+-\13\2\2\2,+\3\2\2\2-\60\3\2\2\2"+
		"./\3\2\2\2.,\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\61\63\t\5\2\2\62\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\65\b\5\2\2\65\n\3\2\2\2\66\67\7\61\2\2\678\7,\2\2"+
		"8<\3\2\2\29;\13\2\2\2:9\3\2\2\2;>\3\2\2\2<=\3\2\2\2<:\3\2\2\2=?\3\2\2"+
		"\2><\3\2\2\2?@\7,\2\2@A\7\61\2\2AB\3\2\2\2BC\b\6\2\2C\f\3\2\2\2DF\t\6"+
		"\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\b\7\2\2J\16\3"+
		"\2\2\2KO\7)\2\2LP\13\2\2\2MN\7^\2\2NP\7p\2\2OL\3\2\2\2OM\3\2\2\2PQ\3\2"+
		"\2\2QR\7)\2\2R\20\3\2\2\2\f\2\24\31\37%.\62<GO\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}