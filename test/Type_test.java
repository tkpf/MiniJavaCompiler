import syntaxtree.expressions.BoolExpr;
import syntaxtree.expressions.IntegerExpr;
import syntaxtree.expressions.Type;

class Test {
    public int i = 5;
}
public class Type_test {
    public static void main(String[] args) {
        Test test = new Test();

        IntegerExpr i = new IntegerExpr(test.i);
        System.out.println(i);

        BoolExpr b = new BoolExpr(true);
        System.out.println(b);

        Type t = new Type("String");
        System.out.println(t.equals(new Type("String")));
        System.out.println(t.equals("String"));
    }
}
