package syntaxtree;

import syntaxtree.expressions.Type;
import syntaxtree.statements.BlockStmt;

import java.util.Vector;

public class Method {

    final public String name;
    final public Type rtype;
    final public Vector<Parameter> params;
    final public BlockStmt blck;

    public  Method (String name, Type rtype, Vector<Parameter> params, BlockStmt blck) {
        this.name = name;
        this.rtype = rtype;
        this.params = params;
        this.blck = blck;
    }


}
