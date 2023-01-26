package syntaxtree;

import syntaxtree.statements.Statement;

import java.util.Vector;

public class Class {

    public final Type name;
    public final Vector<Statement> stmts;
    public final Vector<Method> meths;



    public Class(String name, Vector<Statement> stmts, Vector<Method> meths) {
        this.name = new Type(name);
        this.stmts = stmts;
        this.meths = meths;

    }

    @Override
    public String toString() {
        String result = "(Class " + this.name + " [";
        //todo overriden by tkpf, because field do not exist anymore
        for (Statement s : this.stmts) {
            result += stmts.toString();
        }
        result += "] [";
        for (Method m : meths) {
            result += m.toString();
        }
        result += "])";
        return result;
    }
}
