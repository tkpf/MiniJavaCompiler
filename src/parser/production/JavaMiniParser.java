// Generated from java-escape by ANTLR 4.11.1
package parser.production;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JavaMiniParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, AssignLiteral=16, 
		PrimitiveType=17, IfLiteral=18, WhileLiteral=19, ReturnLiteral=20, ElseLiteral=21, 
		RefLiteral=22, DecimalLiteral=23, BoolLiteral=24, CharacterLiteral=25, 
		StringLiteral=26, NullLiteral=27, VoidLiteral=28, NewLiteral=29, InstLiteral=30, 
		MulLiterals=31, AddLiterals=32, CompareLiterals=33, AndOrLiterals=34, 
		IncLiterals=35, NotLiteral=36, EscapeSequence=37, Identifier=38, Letter=39, 
		JavaIDDigit=40, COMMENT=41, WS=42, LINE_COMMENT=43;
	public static final int
		RULE_compilationUnit = 0, RULE_typeDeclaration = 1, RULE_classDeclaration = 2, 
		RULE_modifier = 3, RULE_classBody = 4, RULE_classBodyDeclaration = 5, 
		RULE_member = 6, RULE_methodDeclaration = 7, RULE_methodDeclarationRest = 8, 
		RULE_methodBody = 9, RULE_formalParameters = 10, RULE_formalParameterDecls = 11, 
		RULE_formalParameter = 12, RULE_fieldDeclaration = 13, RULE_variableDeclarator = 14, 
		RULE_directInitialization = 15, RULE_variableDeclaratorId = 16, RULE_block = 17, 
		RULE_localVariableDeclaration = 18, RULE_statement = 19, RULE_emptyStatement = 20, 
		RULE_statementExpression = 21, RULE_expression = 22, RULE_methodCallRest = 23, 
		RULE_binaryLiterals = 24, RULE_unaryLiterals = 25, RULE_expressionList = 26, 
		RULE_creator = 27, RULE_primary = 28, RULE_type = 29, RULE_typeLiteral = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "typeDeclaration", "classDeclaration", "modifier", 
			"classBody", "classBodyDeclaration", "member", "methodDeclaration", "methodDeclarationRest", 
			"methodBody", "formalParameters", "formalParameterDecls", "formalParameter", 
			"fieldDeclaration", "variableDeclarator", "directInitialization", "variableDeclaratorId", 
			"block", "localVariableDeclaration", "statement", "emptyStatement", "statementExpression", 
			"expression", "methodCallRest", "binaryLiterals", "unaryLiterals", "expressionList", 
			"creator", "primary", "type", "typeLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'class'", "'extends'", "'public'", "'protected'", "'private'", 
			"'abstract'", "'static'", "'final'", "'strictfp'", "'{'", "'}'", "'('", 
			"')'", "','", "'='", null, "'if'", "'while'", "'return'", "'else'", null, 
			null, null, null, null, "'null'", "'void'", "'new'", "'.'", null, null, 
			null, null, null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "AssignLiteral", "PrimitiveType", "IfLiteral", 
			"WhileLiteral", "ReturnLiteral", "ElseLiteral", "RefLiteral", "DecimalLiteral", 
			"BoolLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", "VoidLiteral", 
			"NewLiteral", "InstLiteral", "MulLiterals", "AddLiterals", "CompareLiterals", 
			"AndOrLiterals", "IncLiterals", "NotLiteral", "EscapeSequence", "Identifier", 
			"Letter", "JavaIDDigit", "COMMENT", "WS", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaMiniParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JavaMiniParser.EOF, 0); }
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2038L) != 0) {
				{
				{
				setState(62);
				typeDeclaration();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typeDeclaration);
		int _la;
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2032L) != 0) {
					{
					{
					setState(70);
					modifier();
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(76);
				classDeclaration();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaMiniParser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__1);
			setState(81);
			match(Identifier);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(82);
				match(T__2);
				setState(83);
				type();
				}
			}

			setState(86);
			classBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 2032L) != 0) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__10);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 275146475506L) != 0) {
				{
				{
				setState(91);
				classBodyDeclaration();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			match(T__11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public MemberContext member() {
			return getRuleContext(MemberContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitClassBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitClassBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classBodyDeclaration);
		int _la;
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(T__0);
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case PrimitiveType:
			case VoidLiteral:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2032L) != 0) {
					{
					{
					setState(100);
					modifier();
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(106);
				member();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MemberContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_member);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				methodDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				fieldDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaMiniParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodDeclarationRestContext methodDeclarationRest() {
			return getRuleContext(MethodDeclarationRestContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VoidLiteral() { return getToken(JavaMiniParser.VoidLiteral, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodDeclaration);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PrimitiveType:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(113);
					type();
					}
					break;
				}
				setState(116);
				match(Identifier);
				setState(117);
				formalParameters();
				setState(118);
				methodDeclarationRest();
				}
				break;
			case VoidLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(VoidLiteral);
				setState(121);
				match(Identifier);
				setState(122);
				formalParameters();
				setState(123);
				methodDeclarationRest();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclarationRestContext extends ParserRuleContext {
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public MethodDeclarationRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarationRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterMethodDeclarationRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitMethodDeclarationRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitMethodDeclarationRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationRestContext methodDeclarationRest() throws RecognitionException {
		MethodDeclarationRestContext _localctx = new MethodDeclarationRestContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDeclarationRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(127);
				methodBody();
				}
				break;
			case T__0:
				{
				setState(128);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParametersContext extends ParserRuleContext {
		public FormalParameterDeclsContext formalParameterDecls() {
			return getRuleContext(FormalParameterDeclsContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__12);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 274878040048L) != 0) {
				{
				setState(134);
				formalParameterDecls();
				}
			}

			setState(137);
			match(T__13);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterDeclsContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParameterDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterDecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterFormalParameterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitFormalParameterDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitFormalParameterDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterDeclsContext formalParameterDecls() throws RecognitionException {
		FormalParameterDeclsContext _localctx = new FormalParameterDeclsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_formalParameterDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			formalParameter();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(140);
				match(T__14);
				setState(141);
				formalParameter();
				}
				}
				setState(146);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2032L) != 0) {
				{
				{
				setState(147);
				modifier();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			type();
			setState(154);
			variableDeclaratorId();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclaratorContext variableDeclarator() {
			return getRuleContext(VariableDeclaratorContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			type();
			setState(157);
			variableDeclarator();
			setState(158);
			match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public DirectInitializationContext directInitialization() {
			return getRuleContext(DirectInitializationContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitVariableDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitVariableDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			variableDeclaratorId();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssignLiteral) {
				{
				setState(161);
				directInitialization();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DirectInitializationContext extends ParserRuleContext {
		public TerminalNode AssignLiteral() { return getToken(JavaMiniParser.AssignLiteral, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DirectInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directInitialization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterDirectInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitDirectInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitDirectInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectInitializationContext directInitialization() throws RecognitionException {
		DirectInitializationContext _localctx = new DirectInitializationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_directInitialization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(AssignLiteral);
			setState(165);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaMiniParser.Identifier, 0); }
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitVariableDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitVariableDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variableDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__10);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 383055177714L) != 0) {
				{
				{
				setState(170);
				statement();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			match(T__11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclaratorContext variableDeclarator() {
			return getRuleContext(VariableDeclaratorContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_localVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2032L) != 0) {
				{
				{
				setState(178);
				modifier();
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184);
			type();
			setState(185);
			variableDeclarator();
			setState(186);
			match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode IfLiteral() { return getToken(JavaMiniParser.IfLiteral, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ElseLiteral() { return getToken(JavaMiniParser.ElseLiteral, 0); }
		public TerminalNode WhileLiteral() { return getToken(JavaMiniParser.WhileLiteral, 0); }
		public TerminalNode ReturnLiteral() { return getToken(JavaMiniParser.ReturnLiteral, 0); }
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		int _la;
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(IfLiteral);
				setState(189);
				match(T__12);
				setState(190);
				expression(0);
				setState(191);
				match(T__13);
				setState(192);
				block();
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ElseLiteral) {
					{
					setState(193);
					match(ElseLiteral);
					setState(194);
					block();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(WhileLiteral);
				setState(198);
				match(T__12);
				setState(199);
				expression(0);
				setState(200);
				match(T__13);
				setState(201);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				match(ReturnLiteral);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 383053209600L) != 0) {
					{
					setState(204);
					expression(0);
					}
				}

				setState(207);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				emptyStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				statementExpression();
				setState(210);
				match(T__0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(212);
				localVariableDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AssignLiteral() { return getToken(JavaMiniParser.AssignLiteral, 0); }
		public MethodCallRestContext methodCallRest() {
			return getRuleContext(MethodCallRestContext.class,0);
		}
		public TerminalNode NewLiteral() { return getToken(JavaMiniParser.NewLiteral, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statementExpression);
		try {
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				expression(0);
				setState(218);
				match(AssignLiteral);
				setState(219);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				expression(0);
				setState(222);
				methodCallRest();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(NewLiteral);
				setState(225);
				creator();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnaryLiteralsContext unaryLiterals() {
			return getRuleContext(UnaryLiteralsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NewLiteral() { return getToken(JavaMiniParser.NewLiteral, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public BinaryLiteralsContext binaryLiterals() {
			return getRuleContext(BinaryLiteralsContext.class,0);
		}
		public TerminalNode AssignLiteral() { return getToken(JavaMiniParser.AssignLiteral, 0); }
		public TerminalNode InstLiteral() { return getToken(JavaMiniParser.InstLiteral, 0); }
		public TerminalNode Identifier() { return getToken(JavaMiniParser.Identifier, 0); }
		public MethodCallRestContext methodCallRest() {
			return getRuleContext(MethodCallRestContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case RefLiteral:
			case DecimalLiteral:
			case BoolLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case Identifier:
				{
				setState(229);
				primary();
				}
				break;
			case AddLiterals:
			case IncLiterals:
			case NotLiteral:
				{
				setState(230);
				unaryLiterals();
				setState(231);
				expression(5);
				}
				break;
			case NewLiteral:
				{
				setState(233);
				match(NewLiteral);
				setState(234);
				creator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(249);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(237);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(238);
						binaryLiterals();
						setState(239);
						expression(5);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(241);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(242);
						match(AssignLiteral);
						setState(243);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(245);
						match(InstLiteral);
						setState(246);
						match(Identifier);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(248);
						methodCallRest();
						}
						break;
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallRestContext extends ParserRuleContext {
		public TerminalNode InstLiteral() { return getToken(JavaMiniParser.InstLiteral, 0); }
		public TerminalNode Identifier() { return getToken(JavaMiniParser.Identifier, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MethodCallRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterMethodCallRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitMethodCallRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitMethodCallRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallRestContext methodCallRest() throws RecognitionException {
		MethodCallRestContext _localctx = new MethodCallRestContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_methodCallRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(InstLiteral);
			setState(255);
			match(Identifier);
			setState(256);
			match(T__12);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 383053209600L) != 0) {
				{
				setState(257);
				expressionList();
				}
			}

			setState(260);
			match(T__13);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryLiteralsContext extends ParserRuleContext {
		public TerminalNode MulLiterals() { return getToken(JavaMiniParser.MulLiterals, 0); }
		public TerminalNode AddLiterals() { return getToken(JavaMiniParser.AddLiterals, 0); }
		public TerminalNode CompareLiterals() { return getToken(JavaMiniParser.CompareLiterals, 0); }
		public TerminalNode AndOrLiterals() { return getToken(JavaMiniParser.AndOrLiterals, 0); }
		public BinaryLiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryLiterals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterBinaryLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitBinaryLiterals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitBinaryLiterals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryLiteralsContext binaryLiterals() throws RecognitionException {
		BinaryLiteralsContext _localctx = new BinaryLiteralsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_binaryLiterals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 32212254720L) != 0) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryLiteralsContext extends ParserRuleContext {
		public TerminalNode IncLiterals() { return getToken(JavaMiniParser.IncLiterals, 0); }
		public TerminalNode NotLiteral() { return getToken(JavaMiniParser.NotLiteral, 0); }
		public TerminalNode AddLiterals() { return getToken(JavaMiniParser.AddLiterals, 0); }
		public UnaryLiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryLiterals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterUnaryLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitUnaryLiterals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitUnaryLiterals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryLiteralsContext unaryLiterals() throws RecognitionException {
		UnaryLiteralsContext _localctx = new UnaryLiteralsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryLiterals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 107374182400L) != 0) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			expression(0);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(267);
				match(T__14);
				setState(268);
				expression(0);
				}
				}
				setState(273);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CreatorContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_creator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			type();
			setState(275);
			match(T__12);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 383053209600L) != 0) {
				{
				setState(276);
				expressionList();
				}
			}

			setState(279);
			match(T__13);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RefLiteral() { return getToken(JavaMiniParser.RefLiteral, 0); }
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaMiniParser.Identifier, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_primary);
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(T__12);
				setState(282);
				expression(0);
				setState(283);
				match(T__13);
				}
				break;
			case RefLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(RefLiteral);
				}
				break;
			case DecimalLiteral:
			case BoolLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				typeLiteral();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(287);
				match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaMiniParser.Identifier, 0); }
		public TerminalNode PrimitiveType() { return getToken(JavaMiniParser.PrimitiveType, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			_la = _input.LA(1);
			if ( !(_la==PrimitiveType || _la==Identifier) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeLiteralContext extends ParserRuleContext {
		public TerminalNode BoolLiteral() { return getToken(JavaMiniParser.BoolLiteral, 0); }
		public TerminalNode NullLiteral() { return getToken(JavaMiniParser.NullLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(JavaMiniParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(JavaMiniParser.StringLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(JavaMiniParser.DecimalLiteral, 0); }
		public TypeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).enterTypeLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaMiniListener ) ((JavaMiniListener)listener).exitTypeLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaMiniVisitor ) return ((JavaMiniVisitor<? extends T>)visitor).visitTypeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeLiteralContext typeLiteral() throws RecognitionException {
		TypeLiteralContext _localctx = new TypeLiteralContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_typeLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 260046848L) != 0) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u0127\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0005\u0000@\b\u0000\n\u0000\f\u0000C\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0005\u0001H\b\u0001\n\u0001\f\u0001K\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001O\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002U\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004]\b\u0004"+
		"\n\u0004\f\u0004`\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0005\u0005f\b\u0005\n\u0005\f\u0005i\t\u0005\u0001\u0005\u0003\u0005"+
		"l\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006p\b\u0006\u0001\u0007\u0003"+
		"\u0007s\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007~\b"+
		"\u0007\u0001\b\u0001\b\u0003\b\u0082\b\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0003\n\u0088\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u008f\b\u000b\n\u000b\f\u000b\u0092\t\u000b\u0001\f\u0005"+
		"\f\u0095\b\f\n\f\f\f\u0098\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e\u00a3\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u00ac\b\u0011\n\u0011\f\u0011\u00af\t\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0005\u0012\u00b4\b\u0012\n\u0012\f\u0012\u00b7"+
		"\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00c4\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00ce\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00d6\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u00e3\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00ec\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u00fa\b\u0016\n\u0016\f\u0016\u00fd\t\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u0103\b\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0005\u001a\u010e\b\u001a\n\u001a\f\u001a\u0111\t\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0116\b\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u0121\b\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0000\u0001,\u001f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<\u0000\u0005\u0001\u0000\u0004\n\u0001\u0000\u001f\"\u0002\u0000"+
		"  #$\u0002\u0000\u0011\u0011&&\u0001\u0000\u0017\u001b\u012d\u0000A\u0001"+
		"\u0000\u0000\u0000\u0002N\u0001\u0000\u0000\u0000\u0004P\u0001\u0000\u0000"+
		"\u0000\u0006X\u0001\u0000\u0000\u0000\bZ\u0001\u0000\u0000\u0000\nk\u0001"+
		"\u0000\u0000\u0000\fo\u0001\u0000\u0000\u0000\u000e}\u0001\u0000\u0000"+
		"\u0000\u0010\u0081\u0001\u0000\u0000\u0000\u0012\u0083\u0001\u0000\u0000"+
		"\u0000\u0014\u0085\u0001\u0000\u0000\u0000\u0016\u008b\u0001\u0000\u0000"+
		"\u0000\u0018\u0096\u0001\u0000\u0000\u0000\u001a\u009c\u0001\u0000\u0000"+
		"\u0000\u001c\u00a0\u0001\u0000\u0000\u0000\u001e\u00a4\u0001\u0000\u0000"+
		"\u0000 \u00a7\u0001\u0000\u0000\u0000\"\u00a9\u0001\u0000\u0000\u0000"+
		"$\u00b5\u0001\u0000\u0000\u0000&\u00d5\u0001\u0000\u0000\u0000(\u00d7"+
		"\u0001\u0000\u0000\u0000*\u00e2\u0001\u0000\u0000\u0000,\u00eb\u0001\u0000"+
		"\u0000\u0000.\u00fe\u0001\u0000\u0000\u00000\u0106\u0001\u0000\u0000\u0000"+
		"2\u0108\u0001\u0000\u0000\u00004\u010a\u0001\u0000\u0000\u00006\u0112"+
		"\u0001\u0000\u0000\u00008\u0120\u0001\u0000\u0000\u0000:\u0122\u0001\u0000"+
		"\u0000\u0000<\u0124\u0001\u0000\u0000\u0000>@\u0003\u0002\u0001\u0000"+
		"?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000\u0000CA\u0001\u0000"+
		"\u0000\u0000DE\u0005\u0000\u0000\u0001E\u0001\u0001\u0000\u0000\u0000"+
		"FH\u0003\u0006\u0003\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001\u0000"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000LO\u0003\u0004\u0002\u0000MO\u0005"+
		"\u0001\u0000\u0000NI\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000"+
		"O\u0003\u0001\u0000\u0000\u0000PQ\u0005\u0002\u0000\u0000QT\u0005&\u0000"+
		"\u0000RS\u0005\u0003\u0000\u0000SU\u0003:\u001d\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0003\b\u0004"+
		"\u0000W\u0005\u0001\u0000\u0000\u0000XY\u0007\u0000\u0000\u0000Y\u0007"+
		"\u0001\u0000\u0000\u0000Z^\u0005\u000b\u0000\u0000[]\u0003\n\u0005\u0000"+
		"\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`^\u0001\u0000"+
		"\u0000\u0000ab\u0005\f\u0000\u0000b\t\u0001\u0000\u0000\u0000cl\u0005"+
		"\u0001\u0000\u0000df\u0003\u0006\u0003\u0000ed\u0001\u0000\u0000\u0000"+
		"fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hj\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jl\u0003\f\u0006"+
		"\u0000kc\u0001\u0000\u0000\u0000kg\u0001\u0000\u0000\u0000l\u000b\u0001"+
		"\u0000\u0000\u0000mp\u0003\u000e\u0007\u0000np\u0003\u001a\r\u0000om\u0001"+
		"\u0000\u0000\u0000on\u0001\u0000\u0000\u0000p\r\u0001\u0000\u0000\u0000"+
		"qs\u0003:\u001d\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000tu\u0005&\u0000\u0000uv\u0003\u0014\n\u0000"+
		"vw\u0003\u0010\b\u0000w~\u0001\u0000\u0000\u0000xy\u0005\u001c\u0000\u0000"+
		"yz\u0005&\u0000\u0000z{\u0003\u0014\n\u0000{|\u0003\u0010\b\u0000|~\u0001"+
		"\u0000\u0000\u0000}r\u0001\u0000\u0000\u0000}x\u0001\u0000\u0000\u0000"+
		"~\u000f\u0001\u0000\u0000\u0000\u007f\u0082\u0003\u0012\t\u0000\u0080"+
		"\u0082\u0005\u0001\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0011\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0003\"\u0011\u0000\u0084\u0013\u0001\u0000\u0000\u0000\u0085\u0087"+
		"\u0005\r\u0000\u0000\u0086\u0088\u0003\u0016\u000b\u0000\u0087\u0086\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0005\u000e\u0000\u0000\u008a\u0015\u0001"+
		"\u0000\u0000\u0000\u008b\u0090\u0003\u0018\f\u0000\u008c\u008d\u0005\u000f"+
		"\u0000\u0000\u008d\u008f\u0003\u0018\f\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0017\u0001\u0000\u0000"+
		"\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0095\u0003\u0006\u0003"+
		"\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000"+
		"\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000"+
		"\u0000\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0003:\u001d\u0000\u009a\u009b\u0003 \u0010\u0000\u009b"+
		"\u0019\u0001\u0000\u0000\u0000\u009c\u009d\u0003:\u001d\u0000\u009d\u009e"+
		"\u0003\u001c\u000e\u0000\u009e\u009f\u0005\u0001\u0000\u0000\u009f\u001b"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a2\u0003 \u0010\u0000\u00a1\u00a3\u0003"+
		"\u001e\u000f\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u001d\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005"+
		"\u0010\u0000\u0000\u00a5\u00a6\u0003,\u0016\u0000\u00a6\u001f\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0005&\u0000\u0000\u00a8!\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ad\u0005\u000b\u0000\u0000\u00aa\u00ac\u0003&\u0013\u0000\u00ab"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00b0\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0005\f\u0000\u0000\u00b1#\u0001\u0000\u0000\u0000\u00b2\u00b4"+
		"\u0003\u0006\u0003\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b9\u0003:\u001d\u0000\u00b9\u00ba\u0003"+
		"\u001c\u000e\u0000\u00ba\u00bb\u0005\u0001\u0000\u0000\u00bb%\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0005\u0012\u0000\u0000\u00bd\u00be\u0005\r\u0000"+
		"\u0000\u00be\u00bf\u0003,\u0016\u0000\u00bf\u00c0\u0005\u000e\u0000\u0000"+
		"\u00c0\u00c3\u0003\"\u0011\u0000\u00c1\u00c2\u0005\u0015\u0000\u0000\u00c2"+
		"\u00c4\u0003\"\u0011\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c4\u00d6\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0005\u0013\u0000\u0000\u00c6\u00c7\u0005\r\u0000\u0000\u00c7\u00c8\u0003"+
		",\u0016\u0000\u00c8\u00c9\u0005\u000e\u0000\u0000\u00c9\u00ca\u0003\""+
		"\u0011\u0000\u00ca\u00d6\u0001\u0000\u0000\u0000\u00cb\u00cd\u0005\u0014"+
		"\u0000\u0000\u00cc\u00ce\u0003,\u0016\u0000\u00cd\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d6\u0005\u0001\u0000\u0000\u00d0\u00d6\u0003(\u0014\u0000"+
		"\u00d1\u00d2\u0003*\u0015\u0000\u00d2\u00d3\u0005\u0001\u0000\u0000\u00d3"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d6\u0003$\u0012\u0000\u00d5\u00bc"+
		"\u0001\u0000\u0000\u0000\u00d5\u00c5\u0001\u0000\u0000\u0000\u00d5\u00cb"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d0\u0001\u0000\u0000\u0000\u00d5\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\'\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u0005\u0001\u0000\u0000\u00d8)\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0003,\u0016\u0000\u00da\u00db\u0005\u0010\u0000"+
		"\u0000\u00db\u00dc\u0003,\u0016\u0000\u00dc\u00e3\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\u0003,\u0016\u0000\u00de\u00df\u0003.\u0017\u0000\u00df\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\u001d\u0000\u0000\u00e1\u00e3"+
		"\u00036\u001b\u0000\u00e2\u00d9\u0001\u0000\u0000\u0000\u00e2\u00dd\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3+\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0006\u0016\uffff\uffff\u0000\u00e5\u00ec\u0003"+
		"8\u001c\u0000\u00e6\u00e7\u00032\u0019\u0000\u00e7\u00e8\u0003,\u0016"+
		"\u0005\u00e8\u00ec\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\u001d\u0000"+
		"\u0000\u00ea\u00ec\u00036\u001b\u0000\u00eb\u00e4\u0001\u0000\u0000\u0000"+
		"\u00eb\u00e6\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00ec\u00fb\u0001\u0000\u0000\u0000\u00ed\u00ee\n\u0004\u0000\u0000\u00ee"+
		"\u00ef\u00030\u0018\u0000\u00ef\u00f0\u0003,\u0016\u0005\u00f0\u00fa\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f2\n\u0002\u0000\u0000\u00f2\u00f3\u0005\u0010"+
		"\u0000\u0000\u00f3\u00fa\u0003,\u0016\u0003\u00f4\u00f5\n\u0006\u0000"+
		"\u0000\u00f5\u00f6\u0005\u001e\u0000\u0000\u00f6\u00fa\u0005&\u0000\u0000"+
		"\u00f7\u00f8\n\u0003\u0000\u0000\u00f8\u00fa\u0003.\u0017\u0000\u00f9"+
		"\u00ed\u0001\u0000\u0000\u0000\u00f9\u00f1\u0001\u0000\u0000\u0000\u00f9"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fc-\u0001\u0000\u0000\u0000\u00fd\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005\u001e\u0000\u0000\u00ff\u0100"+
		"\u0005&\u0000\u0000\u0100\u0102\u0005\r\u0000\u0000\u0101\u0103\u0003"+
		"4\u001a\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105\u0005\u000e"+
		"\u0000\u0000\u0105/\u0001\u0000\u0000\u0000\u0106\u0107\u0007\u0001\u0000"+
		"\u0000\u01071\u0001\u0000\u0000\u0000\u0108\u0109\u0007\u0002\u0000\u0000"+
		"\u01093\u0001\u0000\u0000\u0000\u010a\u010f\u0003,\u0016\u0000\u010b\u010c"+
		"\u0005\u000f\u0000\u0000\u010c\u010e\u0003,\u0016\u0000\u010d\u010b\u0001"+
		"\u0000\u0000\u0000\u010e\u0111\u0001\u0000\u0000\u0000\u010f\u010d\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u01105\u0001\u0000"+
		"\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0113\u0003:\u001d"+
		"\u0000\u0113\u0115\u0005\r\u0000\u0000\u0114\u0116\u00034\u001a\u0000"+
		"\u0115\u0114\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000"+
		"\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0005\u000e\u0000\u0000"+
		"\u01187\u0001\u0000\u0000\u0000\u0119\u011a\u0005\r\u0000\u0000\u011a"+
		"\u011b\u0003,\u0016\u0000\u011b\u011c\u0005\u000e\u0000\u0000\u011c\u0121"+
		"\u0001\u0000\u0000\u0000\u011d\u0121\u0005\u0016\u0000\u0000\u011e\u0121"+
		"\u0003<\u001e\u0000\u011f\u0121\u0005&\u0000\u0000\u0120\u0119\u0001\u0000"+
		"\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000"+
		"\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u01219\u0001\u0000\u0000"+
		"\u0000\u0122\u0123\u0007\u0003\u0000\u0000\u0123;\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u0007\u0004\u0000\u0000\u0125=\u0001\u0000\u0000\u0000\u001c"+
		"AINT^gkor}\u0081\u0087\u0090\u0096\u00a2\u00ad\u00b5\u00c3\u00cd\u00d5"+
		"\u00e2\u00eb\u00f9\u00fb\u0102\u010f\u0115\u0120";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}