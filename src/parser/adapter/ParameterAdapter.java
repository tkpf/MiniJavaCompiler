package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.Parameter;
import syntaxtree.Type;

public class ParameterAdapter {
    public static Parameter adapt (JavaMiniParser.FormalParameterContext ctx) throws EscapeHatchException {
        final String name = ctx.variableDeclaratorId().getText();
        final Type type = TypeAdapter.adapt(ctx.type());

        return new Parameter(name, type);
    }
}
