package syntaxtree;

import syntaxtree.expressions.Type;
import syntaxtree.statements.BlockStmt;

import java.util.Vector;

public class Method {

    final String name;
    final Type rtype;
    final Vector<Parameter> params;
    final BlockStmt blck;

    public  Method (String name, Type rtype, Vector<Parameter> params, BlockStmt blck) {
        this.name = name;
        this.rtype = rtype;
        this.params = params;
        this.blck = blck;
    }


}
