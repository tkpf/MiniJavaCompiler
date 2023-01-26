import syntaxtree.expressions.BoolExpr;
import syntaxtree.expressions.IntegerExpr;
import syntaxtree.Type;
import typecheck.Signature;

import java.util.HashMap;

class Test {
    int i = 5;

    //method parameters and body are local
    void m(boolean i, int j) {
        int k = this.i;
        boolean l = i;
    }

    // block is local
    {
        int i = 1;
        {
            i++;
            int j = 2;
            {
                i++;
                j++;
                int k = 3;
            }
            //k++;
        }
        //j++;
        //k++;
    }

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
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {1,2,3,4};
        System.out.println(arr1.hashCode() + "\n" + arr2.hashCode());

        Type t1 = new Type("String");
        Type t2 = new Type("int");
        Type t3 = new Type("boolean");
        Signature sig1 = new Signature("m", t1, t1, t3);
        Signature sig2 = new Signature("m", t1, t2, t3);
        System.out.println(sig1.equals(sig2) + "\n" + sig1.hashCode() + "\n" + sig2.hashCode());
    }
}
