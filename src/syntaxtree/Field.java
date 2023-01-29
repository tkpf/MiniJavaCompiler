package syntaxtree;

import syntaxtree.statementexpressions.StatementExpression;

public class Field {
    final public String name;
    final public Type type;
    public StatementExpression assignment;

    public Field (String name, Type type) {
        this.name = name;
        this.type = type;
    }
    public Field (String name, Type type, StatementExpression assignment) {
        this.name = name;
        this.type = type;
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        if (assignment != null) {
            return "(Field:" + type + " " + name + " " + assignment + ")";
        } else {
            return "(Field:" + type + " " + name + ")";

        }
    }
}
