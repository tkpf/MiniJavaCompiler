package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.StmtExprExpr;
import syntaxtree.statementexpressions.NewStmtExpr;

import java.util.List;
import java.util.Vector;

public class ExpressionAdapter {

    static Expression adapt(JavaMiniParser.ExpressionContext ctx) {
        if (ctx.primary() != null) {
            return PrimaryExpressionAdapter.adapt(ctx.primary());
        }
        else if (ctx.binaryLiterals() != null) {
            //Binary Expression
            return BinaryExpressionAdapter.adapt(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ExpressionAdapter.adapt(ctx.expression(1)),
                    ctx.binaryLiterals().start.getText());
        }
        else if (ctx.unaryLiterals() != null) {
            //Unary Expression
            return UnaryExpressionAdapter.adapt(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ctx.unaryLiterals().start.getText());
        }
        else if (ctx.InstLiteral() != null) {
            //InstVar or Method //todo
            return InstVarExpressionAdapter.adapt(
                    ExpressionAdapter.adapt(
                            ctx.expression(0)),
                    ctx.Identifier().getText());
        }
        else if (ctx.NewLiteral() != null) {
            if (ctx.creator().expressionList() != null) {
                Vector<Expression> exprList = new Vector<>();
                List<JavaMiniParser.ExpressionContext> exprCtxList = ctx.creator().expressionList().expression();
                for (JavaMiniParser.ExpressionContext exprCtx : exprCtxList) {
                    exprList.add(ExpressionAdapter.adapt(exprCtx));
                }
                return StmtExprExpressionAdapter.adapt(new NewStmtExpr(
                        TypeAdapter.adapt(ctx.creator().type()), exprList));
            }
            else {
                return StmtExprExpressionAdapter.adapt(new NewStmtExpr(
                        TypeAdapter.adapt(ctx.creator().type()), null));
            }
        }
        else {
            return null; //never reached
        }

    }
}
