package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;
import syntaxtree.statementexpressions.StatementExpression;
import syntaxtree.statements.*;

import java.util.Vector;


public class BlockStmtAdapter {
    public static BlockStmt adapt(JavaMiniParser.BlockContext ctx) {

        Vector<Statement> stmts = new Vector<>();

        for (JavaMiniParser.StatementContext stmtCxt : ctx.statement()) {
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
            else if (stmtCxt.WhileLiteral() != null) {
                Expression bExpr = ExpressionAdapter.adapt(stmtCxt.expression());
                BlockStmt whileBody = BlockStmtAdapter.adapt(stmtCxt.block(0));
                stmts.add(new WhileStmt(bExpr, whileBody));
            }
            else if (stmtCxt.ReturnLiteral() != null) {
                JavaMiniParser.ExpressionContext rExprCtx = stmtCxt.expression(); // todo try catch
                ReturnStmt rStmt = new ReturnStmt(ExpressionAdapter.adapt(rExprCtx));
                stmts.add(rStmt);
            }
            else if (stmtCxt.localVariableDeclaration() != null) {
                VarDeclStmt varDeclStmt =  new VarDeclStmt(
                        stmtCxt.localVariableDeclaration().variableDeclarator().variableDeclaratorId().Identifier().getText(),
                        TypeAdapter.adapt(stmtCxt.localVariableDeclaration().type()));
                stmts.add(varDeclStmt);
            }
            else if (stmtCxt.statementExpression() != null) {
                StatementExpression stmtExpr = StatementExpressionAdapter.adapt(stmtCxt.statementExpression());
                stmts.add(
                        new StmtExprStmt(stmtExpr)
                );
            }
            else {} //never reached
        }

        return new BlockStmt(stmts);
    }
}
