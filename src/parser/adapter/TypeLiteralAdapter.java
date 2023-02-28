package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.expressions.*;

public class TypeLiteralAdapter {

    static Expression adapt(JavaMiniParser.TypeLiteralContext ctx) throws EscapeHatchException {
        if (ctx.BoolLiteral() != null) {
            return new BoolExpr(
                    Boolean.parseBoolean(
                            ctx.BoolLiteral().getText()));
        }
        else if (ctx.CharacterLiteral() != null) {
            return new CharExpr(
                    ctx.CharacterLiteral().getText().charAt(1));
        }
        else if (ctx.DecimalLiteral() != null) {
            return new IntegerExpr(
                    Integer.parseInt(ctx.DecimalLiteral().getText()));
        }
        else if (ctx.StringLiteral() != null) {
            return new StringExpr(ctx.StringLiteral().getText());
        }
        else if (ctx.NullLiteral() != null) {
            return new JNullExpr();
        }
        else {
            // should never be reached
            throw new EscapeHatchException();
        }
    }

}
