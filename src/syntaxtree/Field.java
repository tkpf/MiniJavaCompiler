package syntaxtree;

import syntaxtree.expressions.Type;

public class Field {
    final private String name;
    final private Type type;

    public Field (String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
