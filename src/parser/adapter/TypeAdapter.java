package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.Type;

public class TypeAdapter {
    public static Type adapt (JavaMiniParser.TypeContext ctx) throws EscapeHatchException {
        if (ctx.Identifier() != null) {
            return new Type(ctx.Identifier().getText());
        }
        else if (ctx.PrimitiveType() != null) {
            return new Type(ctx.PrimitiveType().getText());
        }
        else {
            // should never be reached
            throw new EscapeHatchException();
        }
    }
}
