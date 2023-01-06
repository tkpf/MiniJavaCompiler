package syntaxtree;

import syntaxtree.expressions.Type;

import java.util.Vector;

public class Class {

    private final Type name;
    private final Vector<Field> fields;
    private final Vector<Method> meths;

    public Class(String name, Vector<Field> fields, Vector<Method> meths) {
        this.name = new Type(name);
        this.fields = fields;
        this.meths = meths;

    }

    public void genCode() {
        //todo genCode method
    }

}
