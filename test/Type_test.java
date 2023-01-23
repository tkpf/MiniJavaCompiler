import syntaxtree.expressions.BoolExpr;
import syntaxtree.expressions.IntegerExpr;
import syntaxtree.Type;

import java.util.HashMap;

class Test {
    public int i = 5;
}
public class Type_test {
    public static void main(String[] args) {
        Test test = new Test();

        IntegerExpr i = new IntegerExpr(test.i);
        i.type = new Type("int");
        i.type = new Type("int");
        System.out.println(i);

        BoolExpr b = new BoolExpr(true);
        System.out.println(b);

        Type t = new Type("String");
        System.out.println(t.equals(new Type("String")));
        System.out.println(t.equals("String"));
        HashMap<String,Integer> hs = new HashMap<>();
        System.out.println(hs.put("test", Integer.valueOf(1)));
        System.out.println(hs.put("test", Integer.valueOf(3)));


        System.out.println(5+7);
    }
}
