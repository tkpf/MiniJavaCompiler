package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.StmtExprExpr;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.MethodCallStmtExpr;
import syntaxtree.statementexpressions.NewStmtExpr;
import syntaxtree.statementexpressions.StatementExpression;

import java.util.List;
import java.util.Vector;

public class StatementExpressionAdapter {
    public static StatementExpression adapt (JavaMiniParser.ExpressionContext ctx) {
        if (ctx.NewLiteral() != null) {
            if (ctx.creator().expressionList() != null) {
                Vector<Expression> exprList = new Vector<>();
                List<JavaMiniParser.ExpressionContext> exprCtxList = ctx.creator().expressionList().expression();
                for (JavaMiniParser.ExpressionContext exprCtx : exprCtxList) {
                    exprList.add(ExpressionAdapter.adapt(exprCtx));
                }
                return new NewStmtExpr(
                        TypeAdapter.adapt(ctx.creator().type()),
                        exprList
                );
            }
            else {
                return new NewStmtExpr(
                        TypeAdapter.adapt(ctx.creator().type()), null
                );
            }
        }
        else if (ctx.AssignLiteral() != null) {
            return new AssignStmtExpr(
                            ExpressionAdapter.adapt(ctx.expression(0)),
                            ExpressionAdapter.adapt(ctx.expression(1))
                    );
        }
        else if (ctx.methodCallRest() != null) {
            return new MethodCallStmtExpr(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ctx.methodCallRest().Identifier().getText(),
                    ExpressionListAdapter.adapt(ctx.methodCallRest().expressionList())
            );
        }
        else {
            return null; // never reached
        }
    }

    public static StatementExpression adapt (JavaMiniParser.StatementExpressionContext ctx) {
        if (ctx.NewLiteral() != null) {
            if (ctx.creator().expressionList() != null) {
                Vector<Expression> exprList = new Vector<>();
                List<JavaMiniParser.ExpressionContext> exprCtxList = ctx.creator().expressionList().expression();
                for (JavaMiniParser.ExpressionContext exprCtx : exprCtxList) {
                    exprList.add(ExpressionAdapter.adapt(exprCtx));
                }
                return new NewStmtExpr(
                        TypeAdapter.adapt(ctx.creator().type()),
                        exprList
                );
            } else {
                return new NewStmtExpr(
                        TypeAdapter.adapt(ctx.creator().type()), null
                );
            }
        } else if (ctx.AssignLiteral() != null) {
            return new AssignStmtExpr(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ExpressionAdapter.adapt(ctx.expression(1))
            );
        } else if (ctx.methodCallRest() != null) {
            return new MethodCallStmtExpr(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ctx.methodCallRest().Identifier().getText(),
                    ExpressionListAdapter.adapt(ctx.methodCallRest().expressionList())
            );
        } else {
            return null; // never reached
        }
    }
}
