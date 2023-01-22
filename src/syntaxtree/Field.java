package syntaxtree;

import syntaxtree.expressions.Type;

public class Field {
    final public String name;
    final public Type type;

    public Field (String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "(Field " + this.name + " " + this.type + ")";
    }
}
