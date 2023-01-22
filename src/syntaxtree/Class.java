package syntaxtree;

import java.util.Vector;

public class Class {

    public final Type name;
    public final Vector<Field> fields;
    public final Vector<Method> meths;



    public Class(String name, Vector<Field> fields, Vector<Method> meths) {
        this.name = new Type(name);
        this.fields = fields;
        this.meths = meths;

    }

    @Override
    public String toString() {
        String result = "(Class " + this.name + " [";
        for (Field f : this.fields) {
            result += f.toString();
        }
        result += "] [";
        for (Method m : meths) {
            result += m.toString();
        }
        result += "]";
        return result;
    }
}
