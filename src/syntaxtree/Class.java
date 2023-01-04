package syntaxtree;

import java.util.Vector;

public class Class {

    private final TypeExpr name;
    private final Vector<Field> fields;
    private final Vector<Method> meths;

    public Class(String name, Vector<Field> fields, Vector<Method> meths) {
        this.name = new TypeExpr(name);
        this.fields = fields;
        this.meths = meths;

    }

    public void genCode() {
        //todo genCode method
    }

}
