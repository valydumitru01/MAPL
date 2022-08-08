// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

	import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		INT=39, FLOAT=40, IDENT=41, LINE_COMMENT=42, MULTILINE_COMMENT=43, WHITESPACE=44, 
		CHAR=45;
	public static final int
		RULE_start = 0, RULE_global = 1, RULE_func = 2, RULE_defineFuncParams = 3, 
		RULE_defineFuncParamsList = 4, RULE_passFuncParams = 5, RULE_passFuncParamsList = 6, 
		RULE_structField = 7, RULE_varDef = 8, RULE_statement = 9, RULE_expression = 10, 
		RULE_type = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "global", "func", "defineFuncParams", "defineFuncParamsList", 
			"passFuncParams", "passFuncParamsList", "structField", "varDef", "statement", 
			"expression", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'{'", "'}'", "';'", "'('", "')'", "':'", "','", "'var'", 
			"'='", "'return'", "'print'", "'println'", "'printsp'", "'read'", "'if'", 
			"'else'", "'while'", "'['", "']'", "'.'", "'!'", "'<'", "'>'", "'*'", 
			"'/'", "'%'", "'+'", "'-'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", 
			"'int'", "'float'", "'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT", "FLOAT", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", 
			"WHITESPACE", "CHAR"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public GlobalContext global;
		public List<GlobalContext> lg = new ArrayList<GlobalContext>();
		public List<GlobalContext> global() {
			return getRuleContexts(GlobalContext.class);
		}
		public GlobalContext global(int i) {
			return getRuleContext(GlobalContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << IDENT))) != 0)) {
				{
				{
				setState(24);
				((StartContext)_localctx).global = global();
				((StartContext)_localctx).lg.add(((StartContext)_localctx).global);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((StartContext)_localctx).ast = new Program(((StartContext)_localctx).lg);
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

	public static class GlobalContext extends ParserRuleContext {
		public Global ast;
		public Token name;
		public StructFieldContext structField;
		public List<StructFieldContext> lsd = new ArrayList<StructFieldContext>();
		public VarDefContext varDef;
		public FuncContext func;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<StructFieldContext> structField() {
			return getRuleContexts(StructFieldContext.class);
		}
		public StructFieldContext structField(int i) {
			return getRuleContext(StructFieldContext.class,i);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public GlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global; }
	}

	public final GlobalContext global() throws RecognitionException {
		GlobalContext _localctx = new GlobalContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_global);
		int _la;
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(T__0);
				setState(33);
				((GlobalContext)_localctx).name = match(IDENT);
				setState(34);
				match(T__1);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(35);
					((GlobalContext)_localctx).structField = structField();
					((GlobalContext)_localctx).lsd.add(((GlobalContext)_localctx).structField);
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(41);
				match(T__2);
				setState(42);
				match(T__3);
				((GlobalContext)_localctx).ast =  new Struct(((GlobalContext)_localctx).name,((GlobalContext)_localctx).lsd);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				((GlobalContext)_localctx).varDef = varDef();
				((GlobalContext)_localctx).ast = ((GlobalContext)_localctx).varDef.ast;
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				((GlobalContext)_localctx).func = func();
				((GlobalContext)_localctx).ast = ((GlobalContext)_localctx).func.ast;
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

	public static class FuncContext extends ParserRuleContext {
		public Global ast;
		public Token name;
		public DefineFuncParamsContext lp;
		public TypeContext type;
		public VarDefContext varDef;
		public List<VarDefContext> lvd = new ArrayList<VarDefContext>();
		public StatementContext statement;
		public List<StatementContext> ls = new ArrayList<StatementContext>();
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public DefineFuncParamsContext defineFuncParams() {
			return getRuleContext(DefineFuncParamsContext.class,0);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_func);
		int _la;
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				((FuncContext)_localctx).name = match(IDENT);
				setState(53);
				match(T__4);
				setState(54);
				((FuncContext)_localctx).lp = defineFuncParams();
				setState(55);
				match(T__5);
				setState(56);
				match(T__6);
				setState(57);
				((FuncContext)_localctx).type = type();
				setState(58);
				match(T__1);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(59);
					((FuncContext)_localctx).varDef = varDef();
					((FuncContext)_localctx).lvd.add(((FuncContext)_localctx).varDef);
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << T__22) | (1L << INT) | (1L << FLOAT) | (1L << IDENT) | (1L << CHAR))) != 0)) {
					{
					{
					setState(65);
					((FuncContext)_localctx).statement = statement();
					((FuncContext)_localctx).ls.add(((FuncContext)_localctx).statement);
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71);
				match(T__2);
				((FuncContext)_localctx).ast = new Func(((FuncContext)_localctx).name,((FuncContext)_localctx).lp.ast,((FuncContext)_localctx).type.ast,((FuncContext)_localctx).lvd, ((FuncContext)_localctx).ls);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				((FuncContext)_localctx).name = match(IDENT);
				setState(75);
				match(T__4);
				setState(76);
				((FuncContext)_localctx).lp = defineFuncParams();
				setState(77);
				match(T__5);
				setState(78);
				match(T__1);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(79);
					((FuncContext)_localctx).varDef = varDef();
					((FuncContext)_localctx).lvd.add(((FuncContext)_localctx).varDef);
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << T__22) | (1L << INT) | (1L << FLOAT) | (1L << IDENT) | (1L << CHAR))) != 0)) {
					{
					{
					setState(85);
					((FuncContext)_localctx).statement = statement();
					((FuncContext)_localctx).ls.add(((FuncContext)_localctx).statement);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91);
				match(T__2);
				((FuncContext)_localctx).ast = new Func(((FuncContext)_localctx).name,((FuncContext)_localctx).lp.ast,null,((FuncContext)_localctx).lvd, ((FuncContext)_localctx).ls);
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

	public static class DefineFuncParamsContext extends ParserRuleContext {
		public List<VarDef> ast = new ArrayList<>();
		public DefineFuncParamsListContext defineFuncParamsList;
		public DefineFuncParamsListContext defineFuncParamsList() {
			return getRuleContext(DefineFuncParamsListContext.class,0);
		}
		public DefineFuncParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineFuncParams; }
	}

	public final DefineFuncParamsContext defineFuncParams() throws RecognitionException {
		DefineFuncParamsContext _localctx = new DefineFuncParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defineFuncParams);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				((DefineFuncParamsContext)_localctx).defineFuncParamsList = defineFuncParamsList();
				((DefineFuncParamsContext)_localctx).ast = ((DefineFuncParamsContext)_localctx).defineFuncParamsList.ast;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class DefineFuncParamsListContext extends ParserRuleContext {
		public List<VarDef> ast = new ArrayList<>();
		public Token IDENT;
		public TypeContext type;
		public DefineFuncParamsListContext defineFuncParamsList;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefineFuncParamsListContext defineFuncParamsList() {
			return getRuleContext(DefineFuncParamsListContext.class,0);
		}
		public DefineFuncParamsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineFuncParamsList; }
	}

	public final DefineFuncParamsListContext defineFuncParamsList() throws RecognitionException {
		DefineFuncParamsListContext _localctx = new DefineFuncParamsListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_defineFuncParamsList);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((DefineFuncParamsListContext)_localctx).IDENT = match(IDENT);
				setState(103);
				match(T__6);
				setState(104);
				((DefineFuncParamsListContext)_localctx).type = type();
				setState(105);
				match(T__7);
				setState(106);
				((DefineFuncParamsListContext)_localctx).defineFuncParamsList = defineFuncParamsList();
				_localctx.ast.add(new VarDef(((DefineFuncParamsListContext)_localctx).IDENT,((DefineFuncParamsListContext)_localctx).type.ast));
					_localctx.ast.addAll(((DefineFuncParamsListContext)_localctx).defineFuncParamsList.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				((DefineFuncParamsListContext)_localctx).IDENT = match(IDENT);
				setState(110);
				match(T__6);
				setState(111);
				((DefineFuncParamsListContext)_localctx).type = type();
				_localctx.ast.add(new VarDef(((DefineFuncParamsListContext)_localctx).IDENT,((DefineFuncParamsListContext)_localctx).type.ast));
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

	public static class PassFuncParamsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<>();
		public PassFuncParamsListContext passFuncParamsList;
		public PassFuncParamsListContext passFuncParamsList() {
			return getRuleContext(PassFuncParamsListContext.class,0);
		}
		public PassFuncParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passFuncParams; }
	}

	public final PassFuncParamsContext passFuncParams() throws RecognitionException {
		PassFuncParamsContext _localctx = new PassFuncParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_passFuncParams);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__21:
			case T__22:
			case INT:
			case FLOAT:
			case IDENT:
			case CHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				((PassFuncParamsContext)_localctx).passFuncParamsList = passFuncParamsList();
				((PassFuncParamsContext)_localctx).ast = ((PassFuncParamsContext)_localctx).passFuncParamsList.ast;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class PassFuncParamsListContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<>();
		public ExpressionContext expression;
		public PassFuncParamsContext passFuncParams;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PassFuncParamsContext passFuncParams() {
			return getRuleContext(PassFuncParamsContext.class,0);
		}
		public PassFuncParamsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passFuncParamsList; }
	}

	public final PassFuncParamsListContext passFuncParamsList() throws RecognitionException {
		PassFuncParamsListContext _localctx = new PassFuncParamsListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_passFuncParamsList);
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				((PassFuncParamsListContext)_localctx).expression = expression(0);
				setState(123);
				match(T__7);
				setState(124);
				((PassFuncParamsListContext)_localctx).passFuncParams = passFuncParams();
				_localctx.ast.add(((PassFuncParamsListContext)_localctx).expression.ast);
					_localctx.ast.addAll(((PassFuncParamsListContext)_localctx).passFuncParams.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				((PassFuncParamsListContext)_localctx).expression = expression(0);
				_localctx.ast.add(((PassFuncParamsListContext)_localctx).expression.ast);
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

	public static class StructFieldContext extends ParserRuleContext {
		public StructField ast;
		public Token name;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			((StructFieldContext)_localctx).name = match(IDENT);
			setState(133);
			match(T__6);
			setState(134);
			((StructFieldContext)_localctx).type = type();
			setState(135);
			match(T__3);
			((StructFieldContext)_localctx).ast =  new StructField(((StructFieldContext)_localctx).name,((StructFieldContext)_localctx).type.ast);
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

	public static class VarDefContext extends ParserRuleContext {
		public VarDef ast;
		public Token name;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__8);
			setState(139);
			((VarDefContext)_localctx).name = match(IDENT);
			setState(140);
			match(T__6);
			setState(141);
			((VarDefContext)_localctx).type = type();
			setState(142);
			match(T__3);
			((VarDefContext)_localctx).ast =  new VarDef(((VarDefContext)_localctx).name,((VarDefContext)_localctx).type.ast);
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

	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext assigned;
		public ExpressionContext value;
		public ExpressionContext returned;
		public Token print;
		public ExpressionContext printed;
		public Token IDENT;
		public PassFuncParamsContext parameters;
		public ExpressionContext into;
		public ExpressionContext condition;
		public StatementContext statement;
		public List<StatementContext> ifBody = new ArrayList<StatementContext>();
		public List<StatementContext> elseBody = new ArrayList<StatementContext>();
		public List<StatementContext> body = new ArrayList<StatementContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public PassFuncParamsContext passFuncParams() {
			return getRuleContext(PassFuncParamsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				((StatementContext)_localctx).assigned = expression(0);
				setState(146);
				match(T__9);
				setState(147);
				((StatementContext)_localctx).value = expression(0);
				setState(148);
				match(T__3);
				((StatementContext)_localctx).ast = new Assignment(((StatementContext)_localctx).assigned.ast,((StatementContext)_localctx).value.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(T__10);
				setState(152);
				((StatementContext)_localctx).returned = expression(0);
				setState(153);
				match(T__3);
				((StatementContext)_localctx).ast = new Return(((StatementContext)_localctx).returned.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				match(T__10);
				setState(157);
				match(T__3);
				((StatementContext)_localctx).ast = new Return(null);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(159);
				((StatementContext)_localctx).print = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
					((StatementContext)_localctx).print = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(160);
				((StatementContext)_localctx).printed = expression(0);
				setState(161);
				match(T__3);
				((StatementContext)_localctx).ast = new Print(((StatementContext)_localctx).print,((StatementContext)_localctx).printed.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				((StatementContext)_localctx).print = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
					((StatementContext)_localctx).print = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(165);
				match(T__3);
				((StatementContext)_localctx).ast = new Print(((StatementContext)_localctx).print,null);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				((StatementContext)_localctx).IDENT = match(IDENT);
				setState(168);
				match(T__4);
				setState(169);
				((StatementContext)_localctx).parameters = passFuncParams();
				setState(170);
				match(T__5);
				setState(171);
				match(T__3);
				((StatementContext)_localctx).ast = new FuncCall(((StatementContext)_localctx).IDENT,((StatementContext)_localctx).parameters.ast);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(174);
				match(T__14);
				setState(175);
				((StatementContext)_localctx).into = expression(0);
				setState(176);
				match(T__3);
				((StatementContext)_localctx).ast = new Read(((StatementContext)_localctx).into.ast);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(179);
				match(T__15);
				setState(180);
				match(T__4);
				setState(181);
				((StatementContext)_localctx).condition = expression(0);
				setState(182);
				match(T__5);
				setState(183);
				match(T__1);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << T__22) | (1L << INT) | (1L << FLOAT) | (1L << IDENT) | (1L << CHAR))) != 0)) {
					{
					{
					setState(184);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).ifBody.add(((StatementContext)_localctx).statement);
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(190);
				match(T__2);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(191);
					match(T__16);
					setState(192);
					match(T__1);
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << T__22) | (1L << INT) | (1L << FLOAT) | (1L << IDENT) | (1L << CHAR))) != 0)) {
						{
						{
						setState(193);
						((StatementContext)_localctx).statement = statement();
						((StatementContext)_localctx).elseBody.add(((StatementContext)_localctx).statement);
						}
						}
						setState(198);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(199);
					match(T__2);
					}
				}

				((StatementContext)_localctx).ast = new If(((StatementContext)_localctx).condition.ast,((StatementContext)_localctx).ifBody,((StatementContext)_localctx).elseBody);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(204);
				match(T__17);
				setState(205);
				match(T__4);
				setState(206);
				((StatementContext)_localctx).condition = expression(0);
				setState(207);
				match(T__5);
				setState(208);
				match(T__1);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << T__22) | (1L << INT) | (1L << FLOAT) | (1L << IDENT) | (1L << CHAR))) != 0)) {
					{
					{
					setState(209);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).body.add(((StatementContext)_localctx).statement);
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(215);
				match(T__2);
				((StatementContext)_localctx).ast = new While(((StatementContext)_localctx).condition.ast,((StatementContext)_localctx).body);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext array;
		public ExpressionContext e;
		public ExpressionContext left;
		public ExpressionContext inside;
		public Token IDENT;
		public PassFuncParamsContext parameters;
		public ExpressionContext bool;
		public TypeContext to;
		public ExpressionContext from;
		public Token name;
		public Token value;
		public Token op;
		public ExpressionContext right;
		public ExpressionContext index;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public PassFuncParamsContext passFuncParams() {
			return getRuleContext(PassFuncParamsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(GrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(GrammarParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(221);
				match(T__4);
				setState(222);
				((ExpressionContext)_localctx).inside = expression(0);
				setState(223);
				match(T__5);
				((ExpressionContext)_localctx).ast = ((ExpressionContext)_localctx).inside.ast;
				}
				break;
			case 2:
				{
				setState(226);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				setState(227);
				match(T__4);
				setState(228);
				((ExpressionContext)_localctx).parameters = passFuncParams();
				setState(229);
				match(T__5);
				((ExpressionContext)_localctx).ast = new ExpressionFuncAccess(((ExpressionContext)_localctx).IDENT,((ExpressionContext)_localctx).parameters.ast);
				}
				break;
			case 3:
				{
				setState(232);
				match(T__21);
				setState(233);
				((ExpressionContext)_localctx).bool = expression(11);
				((ExpressionContext)_localctx).ast = new Negate(((ExpressionContext)_localctx).bool.ast);
				}
				break;
			case 4:
				{
				setState(236);
				match(T__22);
				setState(237);
				((ExpressionContext)_localctx).to = type();
				setState(238);
				match(T__23);
				setState(239);
				((ExpressionContext)_localctx).from = expression(10);
				((ExpressionContext)_localctx).ast = new Parse(((ExpressionContext)_localctx).to.ast,((ExpressionContext)_localctx).from.ast);
				}
				break;
			case 5:
				{
				setState(242);
				((ExpressionContext)_localctx).name = match(IDENT);
				((ExpressionContext)_localctx).ast = new Variable(((ExpressionContext)_localctx).name);
				}
				break;
			case 6:
				{
				setState(244);
				((ExpressionContext)_localctx).value = match(FLOAT);
				((ExpressionContext)_localctx).ast = new FloatConstant(((ExpressionContext)_localctx).value);
				}
				break;
			case 7:
				{
				setState(246);
				((ExpressionContext)_localctx).value = match(CHAR);
				((ExpressionContext)_localctx).ast = new CharConstant(((ExpressionContext)_localctx).value);
				}
				break;
			case 8:
				{
				setState(248);
				((ExpressionContext)_localctx).value = match(INT);
				((ExpressionContext)_localctx).ast = new IntConstant(((ExpressionContext)_localctx).value);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(287);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(253);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						((ExpressionContext)_localctx).right = expression(10);
						((ExpressionContext)_localctx).ast = new ArithmeticExpression(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).op,((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(258);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(259);
						((ExpressionContext)_localctx).right = expression(9);
						((ExpressionContext)_localctx).ast = new ArithmeticExpression(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).op,((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(263);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						((ExpressionContext)_localctx).right = expression(8);
						((ExpressionContext)_localctx).ast = new BooleanExpression(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).op,((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(268);
						((ExpressionContext)_localctx).op = match(T__33);
						setState(269);
						((ExpressionContext)_localctx).right = expression(7);
						((ExpressionContext)_localctx).ast = new BooleanOfBooleansExpr(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).op,((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(272);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(273);
						((ExpressionContext)_localctx).op = match(T__34);
						setState(274);
						((ExpressionContext)_localctx).right = expression(6);
						((ExpressionContext)_localctx).ast = new BooleanOfBooleansExpr(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).op,((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.array = _prevctx;
						_localctx.array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(278);
						match(T__18);
						setState(279);
						((ExpressionContext)_localctx).index = expression(0);
						setState(280);
						match(T__19);
						((ExpressionContext)_localctx).ast = new ExpressionArrayAccess(((ExpressionContext)_localctx).array.ast,((ExpressionContext)_localctx).index.ast);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(283);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(284);
						match(T__20);
						setState(285);
						((ExpressionContext)_localctx).IDENT = match(IDENT);
						((ExpressionContext)_localctx).ast = new ExpressionPointAccess(((ExpressionContext)_localctx).e.ast,((ExpressionContext)_localctx).IDENT);
						}
						break;
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token name;
		public Token size;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(T__35);
				((TypeContext)_localctx).ast =  new IntType();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				match(T__36);
				((TypeContext)_localctx).ast =  new FloatType();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				match(T__37);
				((TypeContext)_localctx).ast =  new CharType();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(298);
				((TypeContext)_localctx).name = match(IDENT);
				((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).name);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(300);
				match(T__18);
				setState(301);
				((TypeContext)_localctx).size = match(INT);
				setState(302);
				match(T__19);
				setState(303);
				((TypeContext)_localctx).type = type();
				((TypeContext)_localctx).ast =  new ArrayType(new IntConstant(((TypeContext)_localctx).size),((TypeContext)_localctx).type.ast);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0137\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\65\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13\4\3\4"+
		"\7\4E\n\4\f\4\16\4H\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4S\n\4"+
		"\f\4\16\4V\13\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\3\4\3\4\5\4a\n\4\3\5"+
		"\3\5\3\5\3\5\5\5g\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6u\n\6\3\7\3\7\3\7\3\7\5\7{\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"\u0085\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00bc\n\13"+
		"\f\13\16\13\u00bf\13\13\3\13\3\13\3\13\3\13\7\13\u00c5\n\13\f\13\16\13"+
		"\u00c8\13\13\3\13\5\13\u00cb\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\7\13\u00d5\n\13\f\13\16\13\u00d8\13\13\3\13\3\13\3\13\5\13\u00dd\n"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00fd\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u0122\n\f\f\f\16\f\u0125\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0135\n\r\3\r\2\3\26\16\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\2\6\3\2\16\20\3\2\33\35\3\2\36\37\4\2\31\32 #\2\u0155\2\35\3\2"+
		"\2\2\4\64\3\2\2\2\6`\3\2\2\2\bf\3\2\2\2\nt\3\2\2\2\fz\3\2\2\2\16\u0084"+
		"\3\2\2\2\20\u0086\3\2\2\2\22\u008c\3\2\2\2\24\u00dc\3\2\2\2\26\u00fc\3"+
		"\2\2\2\30\u0134\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33"+
		"\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\b\2\1\2!\3\3\2\2\2"+
		"\"#\7\3\2\2#$\7+\2\2$(\7\4\2\2%\'\5\20\t\2&%\3\2\2\2\'*\3\2\2\2(&\3\2"+
		"\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\5\2\2,-\7\6\2\2-\65\b\3\1\2./\5"+
		"\22\n\2/\60\b\3\1\2\60\65\3\2\2\2\61\62\5\6\4\2\62\63\b\3\1\2\63\65\3"+
		"\2\2\2\64\"\3\2\2\2\64.\3\2\2\2\64\61\3\2\2\2\65\5\3\2\2\2\66\67\7+\2"+
		"\2\678\7\7\2\289\5\b\5\29:\7\b\2\2:;\7\t\2\2;<\5\30\r\2<@\7\4\2\2=?\5"+
		"\22\n\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AF\3\2\2\2B@\3\2\2\2CE"+
		"\5\24\13\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2"+
		"IJ\7\5\2\2JK\b\4\1\2Ka\3\2\2\2LM\7+\2\2MN\7\7\2\2NO\5\b\5\2OP\7\b\2\2"+
		"PT\7\4\2\2QS\5\22\n\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UZ\3\2\2"+
		"\2VT\3\2\2\2WY\5\24\13\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3"+
		"\2\2\2\\Z\3\2\2\2]^\7\5\2\2^_\b\4\1\2_a\3\2\2\2`\66\3\2\2\2`L\3\2\2\2"+
		"a\7\3\2\2\2bc\5\n\6\2cd\b\5\1\2dg\3\2\2\2eg\3\2\2\2fb\3\2\2\2fe\3\2\2"+
		"\2g\t\3\2\2\2hi\7+\2\2ij\7\t\2\2jk\5\30\r\2kl\7\n\2\2lm\5\n\6\2mn\b\6"+
		"\1\2nu\3\2\2\2op\7+\2\2pq\7\t\2\2qr\5\30\r\2rs\b\6\1\2su\3\2\2\2th\3\2"+
		"\2\2to\3\2\2\2u\13\3\2\2\2vw\5\16\b\2wx\b\7\1\2x{\3\2\2\2y{\3\2\2\2zv"+
		"\3\2\2\2zy\3\2\2\2{\r\3\2\2\2|}\5\26\f\2}~\7\n\2\2~\177\5\f\7\2\177\u0080"+
		"\b\b\1\2\u0080\u0085\3\2\2\2\u0081\u0082\5\26\f\2\u0082\u0083\b\b\1\2"+
		"\u0083\u0085\3\2\2\2\u0084|\3\2\2\2\u0084\u0081\3\2\2\2\u0085\17\3\2\2"+
		"\2\u0086\u0087\7+\2\2\u0087\u0088\7\t\2\2\u0088\u0089\5\30\r\2\u0089\u008a"+
		"\7\6\2\2\u008a\u008b\b\t\1\2\u008b\21\3\2\2\2\u008c\u008d\7\13\2\2\u008d"+
		"\u008e\7+\2\2\u008e\u008f\7\t\2\2\u008f\u0090\5\30\r\2\u0090\u0091\7\6"+
		"\2\2\u0091\u0092\b\n\1\2\u0092\23\3\2\2\2\u0093\u0094\5\26\f\2\u0094\u0095"+
		"\7\f\2\2\u0095\u0096\5\26\f\2\u0096\u0097\7\6\2\2\u0097\u0098\b\13\1\2"+
		"\u0098\u00dd\3\2\2\2\u0099\u009a\7\r\2\2\u009a\u009b\5\26\f\2\u009b\u009c"+
		"\7\6\2\2\u009c\u009d\b\13\1\2\u009d\u00dd\3\2\2\2\u009e\u009f\7\r\2\2"+
		"\u009f\u00a0\7\6\2\2\u00a0\u00dd\b\13\1\2\u00a1\u00a2\t\2\2\2\u00a2\u00a3"+
		"\5\26\f\2\u00a3\u00a4\7\6\2\2\u00a4\u00a5\b\13\1\2\u00a5\u00dd\3\2\2\2"+
		"\u00a6\u00a7\t\2\2\2\u00a7\u00a8\7\6\2\2\u00a8\u00dd\b\13\1\2\u00a9\u00aa"+
		"\7+\2\2\u00aa\u00ab\7\7\2\2\u00ab\u00ac\5\f\7\2\u00ac\u00ad\7\b\2\2\u00ad"+
		"\u00ae\7\6\2\2\u00ae\u00af\b\13\1\2\u00af\u00dd\3\2\2\2\u00b0\u00b1\7"+
		"\21\2\2\u00b1\u00b2\5\26\f\2\u00b2\u00b3\7\6\2\2\u00b3\u00b4\b\13\1\2"+
		"\u00b4\u00dd\3\2\2\2\u00b5\u00b6\7\22\2\2\u00b6\u00b7\7\7\2\2\u00b7\u00b8"+
		"\5\26\f\2\u00b8\u00b9\7\b\2\2\u00b9\u00bd\7\4\2\2\u00ba\u00bc\5\24\13"+
		"\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00ca\7\5\2\2\u00c1"+
		"\u00c2\7\23\2\2\u00c2\u00c6\7\4\2\2\u00c3\u00c5\5\24\13\2\u00c4\u00c3"+
		"\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb\7\5\2\2\u00ca\u00c1\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b\13\1\2\u00cd"+
		"\u00dd\3\2\2\2\u00ce\u00cf\7\24\2\2\u00cf\u00d0\7\7\2\2\u00d0\u00d1\5"+
		"\26\f\2\u00d1\u00d2\7\b\2\2\u00d2\u00d6\7\4\2\2\u00d3\u00d5\5\24\13\2"+
		"\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7\5\2\2\u00da"+
		"\u00db\b\13\1\2\u00db\u00dd\3\2\2\2\u00dc\u0093\3\2\2\2\u00dc\u0099\3"+
		"\2\2\2\u00dc\u009e\3\2\2\2\u00dc\u00a1\3\2\2\2\u00dc\u00a6\3\2\2\2\u00dc"+
		"\u00a9\3\2\2\2\u00dc\u00b0\3\2\2\2\u00dc\u00b5\3\2\2\2\u00dc\u00ce\3\2"+
		"\2\2\u00dd\25\3\2\2\2\u00de\u00df\b\f\1\2\u00df\u00e0\7\7\2\2\u00e0\u00e1"+
		"\5\26\f\2\u00e1\u00e2\7\b\2\2\u00e2\u00e3\b\f\1\2\u00e3\u00fd\3\2\2\2"+
		"\u00e4\u00e5\7+\2\2\u00e5\u00e6\7\7\2\2\u00e6\u00e7\5\f\7\2\u00e7\u00e8"+
		"\7\b\2\2\u00e8\u00e9\b\f\1\2\u00e9\u00fd\3\2\2\2\u00ea\u00eb\7\30\2\2"+
		"\u00eb\u00ec\5\26\f\r\u00ec\u00ed\b\f\1\2\u00ed\u00fd\3\2\2\2\u00ee\u00ef"+
		"\7\31\2\2\u00ef\u00f0\5\30\r\2\u00f0\u00f1\7\32\2\2\u00f1\u00f2\5\26\f"+
		"\f\u00f2\u00f3\b\f\1\2\u00f3\u00fd\3\2\2\2\u00f4\u00f5\7+\2\2\u00f5\u00fd"+
		"\b\f\1\2\u00f6\u00f7\7*\2\2\u00f7\u00fd\b\f\1\2\u00f8\u00f9\7/\2\2\u00f9"+
		"\u00fd\b\f\1\2\u00fa\u00fb\7)\2\2\u00fb\u00fd\b\f\1\2\u00fc\u00de\3\2"+
		"\2\2\u00fc\u00e4\3\2\2\2\u00fc\u00ea\3\2\2\2\u00fc\u00ee\3\2\2\2\u00fc"+
		"\u00f4\3\2\2\2\u00fc\u00f6\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00fa\3\2"+
		"\2\2\u00fd\u0123\3\2\2\2\u00fe\u00ff\f\13\2\2\u00ff\u0100\t\3\2\2\u0100"+
		"\u0101\5\26\f\f\u0101\u0102\b\f\1\2\u0102\u0122\3\2\2\2\u0103\u0104\f"+
		"\n\2\2\u0104\u0105\t\4\2\2\u0105\u0106\5\26\f\13\u0106\u0107\b\f\1\2\u0107"+
		"\u0122\3\2\2\2\u0108\u0109\f\t\2\2\u0109\u010a\t\5\2\2\u010a\u010b\5\26"+
		"\f\n\u010b\u010c\b\f\1\2\u010c\u0122\3\2\2\2\u010d\u010e\f\b\2\2\u010e"+
		"\u010f\7$\2\2\u010f\u0110\5\26\f\t\u0110\u0111\b\f\1\2\u0111\u0122\3\2"+
		"\2\2\u0112\u0113\f\7\2\2\u0113\u0114\7%\2\2\u0114\u0115\5\26\f\b\u0115"+
		"\u0116\b\f\1\2\u0116\u0122\3\2\2\2\u0117\u0118\f\20\2\2\u0118\u0119\7"+
		"\25\2\2\u0119\u011a\5\26\f\2\u011a\u011b\7\26\2\2\u011b\u011c\b\f\1\2"+
		"\u011c\u0122\3\2\2\2\u011d\u011e\f\17\2\2\u011e\u011f\7\27\2\2\u011f\u0120"+
		"\7+\2\2\u0120\u0122\b\f\1\2\u0121\u00fe\3\2\2\2\u0121\u0103\3\2\2\2\u0121"+
		"\u0108\3\2\2\2\u0121\u010d\3\2\2\2\u0121\u0112\3\2\2\2\u0121\u0117\3\2"+
		"\2\2\u0121\u011d\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0124\3\2\2\2\u0124\27\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7&\2\2"+
		"\u0127\u0135\b\r\1\2\u0128\u0129\7\'\2\2\u0129\u0135\b\r\1\2\u012a\u012b"+
		"\7(\2\2\u012b\u0135\b\r\1\2\u012c\u012d\7+\2\2\u012d\u0135\b\r\1\2\u012e"+
		"\u012f\7\25\2\2\u012f\u0130\7)\2\2\u0130\u0131\7\26\2\2\u0131\u0132\5"+
		"\30\r\2\u0132\u0133\b\r\1\2\u0133\u0135\3\2\2\2\u0134\u0126\3\2\2\2\u0134"+
		"\u0128\3\2\2\2\u0134\u012a\3\2\2\2\u0134\u012c\3\2\2\2\u0134\u012e\3\2"+
		"\2\2\u0135\31\3\2\2\2\27\35(\64@FTZ`ftz\u0084\u00bd\u00c6\u00ca\u00d6"+
		"\u00dc\u00fc\u0121\u0123\u0134";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}