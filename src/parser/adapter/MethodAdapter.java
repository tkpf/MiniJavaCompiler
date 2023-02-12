package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.Type;
import syntaxtree.statements.BlockStmt;
import syntaxtree.Method;
import syntaxtree.Parameter;

import java.util.Vector;

public class MethodAdapter {

    public static Method adapt(JavaMiniParser.MethodDeclarationContext ctx) throws EscapeHatchException {

        final String name = ctx.Identifier().getText();
        final Type rtype;
        final Vector<Parameter> params = new Vector<>();
        final BlockStmt body;

        // load return type (rType)
        if (ctx.type()!= null) {
            rtype = new Type(ctx.type().getText());
        }
        else if (ctx.VoidLiteral() != null){
            rtype = new Type("void");
        }
        else {
            // this must be a constructor
            rtype = new Type(name);
        }

        // load params
        if (ctx.formalParameters().formalParameterDecls() != null) {
            for (JavaMiniParser.FormalParameterContext parCtx: ctx.formalParameters().formalParameterDecls().formalParameter()) {
                params.add(ParameterAdapter.adapt(parCtx));
            }
        }

        // load body
        if (ctx.methodDeclarationRest().methodBody() != null) {
            body = BlockStmtAdapter.adapt(ctx.methodDeclarationRest().methodBody().block());
        }
        else {
            // should never be reached
            throw new EscapeHatchException();
        }

        return new Method(name, rtype, params, body);
    }
}
