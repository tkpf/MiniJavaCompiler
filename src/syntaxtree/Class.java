package syntaxtree;

import syntaxtree.expressions.Type;

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

    public void genCode() {
        //todo genCode method
    }

}
