package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.expressions.BinaryExpr;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.StmtExprExpr;
import syntaxtree.expressions.UnaryExpr;
import syntaxtree.statementexpressions.StatementExpression;


public class ExpressionAdapter {

    static Expression adapt(JavaMiniParser.ExpressionContext ctx) throws EscapeHatchException {
        if (ctx.primary() != null) {
            return PrimaryExpressionAdapter.adapt(ctx.primary());
        }
        // Check for Binary Expression
        else if (ctx.binaryLiterals() != null) {
            return new BinaryExpr(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ExpressionAdapter.adapt(ctx.expression(1)),
                    ctx.binaryLiterals().start.getText()
            );
        }
        // check for Unary Expression
        else if (ctx.unaryLiterals() != null) {
            return new UnaryExpr(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ctx.unaryLiterals().start.getText()
            );
        }
        // check for StatementExpression
        else if (ctx.statementExpression() != null) {
            StatementExpression stmtExpr = StatementExpressionAdapter.adapt(ctx.statementExpression());
            return new StmtExprExpr(stmtExpr);
        }
        // this should never be reached
        else {
            throw new EscapeHatchException();
        }

    }
}
