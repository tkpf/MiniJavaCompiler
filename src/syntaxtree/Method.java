package syntaxtree;

import org.objectweb.asm.MethodVisitor;
import syntaxtree.statements.BlockStmt;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Vector;

public class Method {

    final public String name;
    final public Type type;
    final public Vector<Parameter> params;
    final public BlockStmt blck;

    public MethodVisitor visitor;
    public Dictionary<String, Integer> localVariableIndexes;

    public  Method (String name, Type type, Vector<Parameter> params, BlockStmt blck) {
        this.name = name;
        this.type = type;
        this.params = params;
        this.blck = blck;
        this.localVariableIndexes = new Hashtable<>();
    }

    @Override
    public String toString() {
        String result =  "(Method " + this.name + " " + this.type + " [";
        for (Parameter p : params) {
            result += p.toString();
        }
        result += "] " + blck.toString() + ")";
        return result;
    }

}
