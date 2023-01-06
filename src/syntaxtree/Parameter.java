package syntaxtree;

import syntaxtree.expressions.Type;

public class Parameter {

    final String name;
    final Type type;

    public Parameter(String name, Type type) {
        this.name = name;
        this.type = type;
    }

}
