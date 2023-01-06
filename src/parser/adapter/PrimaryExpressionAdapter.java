package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.SuperExpr;
import syntaxtree.expressions.ThisExpr;

public class PrimaryExpressionAdapter {

    static Expression adapt (JavaMiniParser.PrimaryContext ctx) {
        if (ctx.expression() != null) {
            return ExpressionAdapter.adapt(ctx.expression());
        }
        else if (ctx.RefLiteral() != null) {
            return switch (ctx.RefLiteral().getText()) {
                case "this" -> new ThisExpr();
                case "super" -> new SuperExpr();
                default -> null; // is never reached
            };
        }
        else if (ctx.typeLiteral() != null) {
            return TypeLiteralAdapter.adapt(ctx.typeLiteral());
        }
        else if (ctx.Identifier() != null) {
            return LocalOrFieldVarExpressionAdapter.adapt(ctx);
        }
        else {
            return null; //never reached
        }
    }
}
