package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.LocalOrFieldVarExpr;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.StatementExpression;
import syntaxtree.statements.*;

import java.util.Vector;


public class BlockStmtAdapter {
    public static BlockStmt adapt(JavaMiniParser.BlockContext ctx) throws EscapeHatchException {

        Vector<Statement> stmts = new Vector<>();

        for (JavaMiniParser.StatementContext stmtCxt : ctx.statement()) {
            // check if current statement is if-statement
            if (stmtCxt.IfLiteral() != null) {
                Expression ifExpr = ExpressionAdapter.adapt(stmtCxt.expression());
                BlockStmt ifBody, elseBody;

                if (stmtCxt.ElseLiteral() != null) {
                    ifBody = BlockStmtAdapter.adapt(stmtCxt.block(0));
                    elseBody = BlockStmtAdapter.adapt(stmtCxt.block(1));
                } else {
                    ifBody = BlockStmtAdapter.adapt(stmtCxt.block(0));
                    elseBody = null;
                }
                stmts.add(new IfStmt(ifExpr, ifBody, elseBody));
            }
            // check if current statement is while-statement
            else if (stmtCxt.WhileLiteral() != null) {
                Expression bExpr = ExpressionAdapter.adapt(stmtCxt.expression());
                BlockStmt whileBody = BlockStmtAdapter.adapt(stmtCxt.block(0));
                stmts.add(new WhileStmt(bExpr, whileBody));
            }
            // check if current statement is return-statement
            else if (stmtCxt.ReturnLiteral() != null) {
                JavaMiniParser.ExpressionContext rExprCtx = stmtCxt.expression();
                ReturnStmt rStmt = new ReturnStmt(ExpressionAdapter.adapt(rExprCtx));
                stmts.add(rStmt);
            }
            // check if current statement is a local variable declaration
            else if (stmtCxt.localVariableDeclaration() != null) {
                String localOrFieldName = stmtCxt.localVariableDeclaration().variableDeclarator().variableDeclaratorId().Identifier().getText();
                VarDeclStmt varDeclStmt =  new VarDeclStmt(
                        localOrFieldName,
                        TypeAdapter.adapt(stmtCxt.localVariableDeclaration().type()));
                stmts.add(varDeclStmt);
                // check for inline initialization
                if (stmtCxt.localVariableDeclaration().variableDeclarator().directInitialization() != null) {
                    AssignStmtExpr directAssignStmtExpr = new AssignStmtExpr(
                            new LocalOrFieldVarExpr(localOrFieldName),
                            ExpressionAdapter.adapt(stmtCxt.localVariableDeclaration().variableDeclarator().directInitialization().expression())
                    );
                    stmts.add(
                            new StmtExprStmt(directAssignStmtExpr)
                    );
                }
            }
            // check if current statement is a hidden statement expression
            else if (stmtCxt.statementExpression() != null) {
                StatementExpression stmtExpr = StatementExpressionAdapter.adapt(stmtCxt.statementExpression());
                stmts.add(
                        new StmtExprStmt(stmtExpr)
                );
            }
            else if (stmtCxt.EmptyStatement() != null) {
                // do nothing
            }
            else {
                // should never be reached
                throw new EscapeHatchException();
            }
        }

        return new BlockStmt(stmts);
    }
}
