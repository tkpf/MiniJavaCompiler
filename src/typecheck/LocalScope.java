package typecheck;

import syntaxtree.Type;
import syntaxtree.expressions.Expression;
import syntaxtree.statementexpressions.StatementExpression;

import java.util.HashMap;

public class LocalContext {
    public final Type thisClass;
    public HashMap<String, Type> fields;
    public HashMap<String, Type> methods;

    LocalContext(Type thisClass) {
        this.thisClass = thisClass;
        this.fields = new HashMap<>();
        this.methods = new HashMap<>();
    }

}
