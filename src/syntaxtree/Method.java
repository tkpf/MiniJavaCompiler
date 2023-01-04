package syntaxtree;

import java.util.Vector;

public class Method {

    final String name;
    final TypeExpr rtype;
    final Vector<Parameter> params;
    final BlockStmt blck;

    public  Method (String name, TypeExpr rtype, Vector<Parameter> params, BlockStmt blck) {
        this.name = name;
        this.rtype = rtype;
        this.params = params;
        this.blck = blck;
    }


}
