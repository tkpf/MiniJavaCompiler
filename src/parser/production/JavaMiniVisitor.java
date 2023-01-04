// Generated from java-escape by ANTLR 4.11.1
package parser.production;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaMiniParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaMiniVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(JavaMiniParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(JavaMiniParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(JavaMiniParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(JavaMiniParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(JavaMiniParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(JavaMiniParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(JavaMiniParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(JavaMiniParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#methodDeclarationRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarationRest(JavaMiniParser.MethodDeclarationRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(JavaMiniParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(JavaMiniParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#formalParameterDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterDecls(JavaMiniParser.FormalParameterDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JavaMiniParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(JavaMiniParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(JavaMiniParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(JavaMiniParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(JavaMiniParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(JavaMiniParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(JavaMiniParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(JavaMiniParser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JavaMiniParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(JavaMiniParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(JavaMiniParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JavaMiniParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(JavaMiniParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(JavaMiniParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(JavaMiniParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(JavaMiniParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JavaMiniParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(JavaMiniParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(JavaMiniParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(JavaMiniParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JavaMiniParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(JavaMiniParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaMiniParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JavaMiniParser.LiteralContext ctx);
}