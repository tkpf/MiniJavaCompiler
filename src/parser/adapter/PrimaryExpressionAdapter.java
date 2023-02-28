package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.ThisExpr;

public class PrimaryExpressionAdapter {

    static Expression adapt (JavaMiniParser.PrimaryContext ctx) throws EscapeHatchException{
        if (ctx.expression() != null) {
            return ExpressionAdapter.adapt(ctx.expression());
        }
        // check for Instance Variable Expression
        else if (ctx.InstLiteral() != null) {
            return InstVarExpressionAdapter.adapt(
                    PrimaryExpressionAdapter.adapt(
                            ctx.primary()),
                            ctx.Identifier().getText()
            );
        }
        else if (ctx.RefLiteral() != null) {
            if (ctx.RefLiteral().getText().equals("this")) {
                return new ThisExpr();
            }
            else {
                throw new EscapeHatchException(); // should never be reached
            }
        }
        else if (ctx.typeLiteral() != null) {
            return TypeLiteralAdapter.adapt(ctx.typeLiteral());
        }
        else if (ctx.Identifier() != null) {
            return LocalOrFieldVarExpressionAdapter.adapt(ctx);
        }
        else {
            // should never be reached
            throw new EscapeHatchException();
        }
    }
}
