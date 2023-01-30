package syntaxtree;

import syntaxtree.statements.Statement;

import java.util.Vector;

public class Class {

    public final Type name;
    public final Vector<Method> meths;
    public Vector<Field> fields;



    public Class(String name, Vector<Field> fields, Vector<Method> meths) {
        this.name = new Type(name);
        this.fields = fields;
        this.meths = meths;

    }

    @Override
    public String toString() {
        String result = "(Class " + this.name + " [F ";
        for (Field f : this.fields) {
            result += f + " ";
        }
        result = result.substring(0, result.length() - 1);
        result += "] [M ";
        for (Method m : meths) {
            result += m + " ";
        }
        result = result.substring(0, result.length() - 1);
        result += "])";
        return result;
    }
}
