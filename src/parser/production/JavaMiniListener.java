// Generated from java-escape by ANTLR 4.11.1
package parser.production;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaMiniParser}.
 */
public interface JavaMiniListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(JavaMiniParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(JavaMiniParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(JavaMiniParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(JavaMiniParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(JavaMiniParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(JavaMiniParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(JavaMiniParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(JavaMiniParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(JavaMiniParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(JavaMiniParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(JavaMiniParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(JavaMiniParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(JavaMiniParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(JavaMiniParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(JavaMiniParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(JavaMiniParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#methodDeclarationRest}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarationRest(JavaMiniParser.MethodDeclarationRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#methodDeclarationRest}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarationRest(JavaMiniParser.MethodDeclarationRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(JavaMiniParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(JavaMiniParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(JavaMiniParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(JavaMiniParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#formalParameterDecls}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterDecls(JavaMiniParser.FormalParameterDeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#formalParameterDecls}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterDecls(JavaMiniParser.FormalParameterDeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JavaMiniParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JavaMiniParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(JavaMiniParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(JavaMiniParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(JavaMiniParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(JavaMiniParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(JavaMiniParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(JavaMiniParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(JavaMiniParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(JavaMiniParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JavaMiniParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JavaMiniParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(JavaMiniParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(JavaMiniParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JavaMiniParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JavaMiniParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(JavaMiniParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(JavaMiniParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JavaMiniParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JavaMiniParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#binaryLiterals}.
	 * @param ctx the parse tree
	 */
	void enterBinaryLiterals(JavaMiniParser.BinaryLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#binaryLiterals}.
	 * @param ctx the parse tree
	 */
	void exitBinaryLiterals(JavaMiniParser.BinaryLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#unaryLiterals}.
	 * @param ctx the parse tree
	 */
	void enterUnaryLiterals(JavaMiniParser.UnaryLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#unaryLiterals}.
	 * @param ctx the parse tree
	 */
	void exitUnaryLiterals(JavaMiniParser.UnaryLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(JavaMiniParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(JavaMiniParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(JavaMiniParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(JavaMiniParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(JavaMiniParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(JavaMiniParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JavaMiniParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JavaMiniParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaMiniParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTypeLiteral(JavaMiniParser.TypeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaMiniParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTypeLiteral(JavaMiniParser.TypeLiteralContext ctx);
}