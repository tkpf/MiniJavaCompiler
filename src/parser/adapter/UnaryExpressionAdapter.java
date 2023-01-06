package parser.adapter;

import syntaxtree.expressions.Expression;
import syntaxtree.expressions.UnaryExpr;

public class UnaryExpressionAdapter {
    static Expression adapt(Expression expr, String op) {
        return new UnaryExpr(expr, op);
    }
}
