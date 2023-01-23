package typecheck;

import syntaxtree.Type;
import syntaxtree.expressions.Expression;
import syntaxtree.statementexpressions.StatementExpression;

import java.util.HashMap;

public class LocalContext {
    StatementExpression parent;
    HashMap<String, Type> local;

}
