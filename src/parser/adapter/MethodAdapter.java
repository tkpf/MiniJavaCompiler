package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.Type;
import syntaxtree.statements.BlockStmt;
import syntaxtree.Method;
import syntaxtree.Parameter;

import java.util.Vector;

public class MethodAdapter {

    public static Method adapt(JavaMiniParser.MethodDeclarationContext ctx) {

        //TODO try catch
        final String name = ctx.Identifier().getText();
        final Type rtype;
        final Vector<Parameter> params = new Vector<>();
        final BlockStmt body;

        // load rtype
        if (ctx.type()!= null) {
            rtype = new Type(ctx.type().getText());
        }
        else if (ctx.VoidLiteral() != null){
            rtype = new Type("void");
        }
        else {
            // this must be a constructor
            rtype = new Type(name); //will never be reached
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
            body = null; //will never be reached
        }

        return new Method(name, rtype, params, body);
    }
}
