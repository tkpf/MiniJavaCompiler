package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.expressions.Type;

public class TypeAdapter {
    public static Type adapt (JavaMiniParser.TypeContext ctx) {
        if (ctx.Identifier() != null) {
            return new Type(ctx.Identifier().getText());
        }
        else if (ctx.PrimitiveType() != null) {
            return new Type(ctx.PrimitiveType().getText());
        }
        else {
            return null; //never reached
        }
    }
}
