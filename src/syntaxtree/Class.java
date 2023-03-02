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
        String result = "(Class " + name + " [";
        for (Field f : fields) {
            result += f + " ";
        }
        if (fields.size() > 0) result = result.substring(0, result.length() - 1);
        result += "] [";
        for (Method m : meths) {
            result += m + " ";
        }
        if (meths.size() > 0) result = result.substring(0, result.length() - 1);
        result += "])";
        return result;
    }
}
