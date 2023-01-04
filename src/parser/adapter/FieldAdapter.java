package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.Field;
import syntaxtree.Method;

public class FieldAdapter {
    public static Field adapt(JavaMiniParser.FieldDeclarationContext ctx) {

        // Todo try catch
        final String name = ctx.variableDeclarator().variableDeclaratorId().getText();
        final String type = ctx.type().getText();

        return new Field(name, type);
    }
}
