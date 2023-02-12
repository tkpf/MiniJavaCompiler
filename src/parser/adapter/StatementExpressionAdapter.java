package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.MethodCallStmtExpr;
import syntaxtree.statementexpressions.NewStmtExpr;
import syntaxtree.statementexpressions.StatementExpression;

import java.util.List;
import java.util.Vector;

public class StatementExpressionAdapter {
    public static StatementExpression adapt (JavaMiniParser.ExpressionContext ctx) throws EscapeHatchException {
        // check if statement expression is a New Creator StmtExpr
        if (ctx.NewLiteral() != null) {
            Vector<Expression> exprList = new Vector<>();
            if (ctx.creator().expressionList() != null) {
                List<JavaMiniParser.ExpressionContext> exprCtxList = ctx.creator().expressionList().expression();
                for (JavaMiniParser.ExpressionContext exprCtx : exprCtxList) {
                    exprList.add(ExpressionAdapter.adapt(exprCtx));
                }
            }
            return new NewStmtExpr(
                    TypeAdapter.adapt(ctx.creator().type()),
                    exprList
            );
        }
        // check if statement expression is an assignment StmtExpr
        else if (ctx.AssignLiteral() != null) {
            return new AssignStmtExpr(
                            ExpressionAdapter.adapt(ctx.expression(0)),
                            ExpressionAdapter.adapt(ctx.expression(1))
                    );
        }
        // check if statement expression is a method call
        else if (ctx.methodCallRest() != null) {
            return new MethodCallStmtExpr(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ctx.methodCallRest().Identifier().getText(),
                    ExpressionListAdapter.adapt(ctx.methodCallRest().expressionList())
            );
        }
        else {
            // this should never be reached
            throw new EscapeHatchException();
        }
    }

    public static StatementExpression adapt (JavaMiniParser.StatementExpressionContext ctx) throws EscapeHatchException {
        // check if statement expression is a New Creator StmtExpr
        if (ctx.NewLiteral() != null) {
            Vector<Expression> exprList = new Vector<>();
            if (ctx.creator().expressionList() != null) {
                List<JavaMiniParser.ExpressionContext> exprCtxList = ctx.creator().expressionList().expression();
                for (JavaMiniParser.ExpressionContext exprCtx : exprCtxList) {
                    exprList.add(ExpressionAdapter.adapt(exprCtx));
                }
            }
            return new NewStmtExpr(
                    TypeAdapter.adapt(ctx.creator().type()),
                    exprList
            );
        }
        // check if statement expression is an assignment StmtExpr
        else if (ctx.AssignLiteral() != null) {
            return new AssignStmtExpr(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ExpressionAdapter.adapt(ctx.expression(1))
            );
        }
        // check if statement expression is a method call
        else if (ctx.methodCallRest() != null) {
            return new MethodCallStmtExpr(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ctx.methodCallRest().Identifier().getText(),
                    ExpressionListAdapter.adapt(ctx.methodCallRest().expressionList())
            );
        } else {
            // this should never be reached
            throw new EscapeHatchException();
        }
    }
}
