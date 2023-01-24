package codegen.testing;

public class TestingExamples {

    public static void main(String[] args) {
        TestClass t = new TestClass();

        t.storeThings(1, 'Q', false, "foo");
        t.createEmpty();
        System.out.println(t.addStrings("asldkfj","1234"));
        System.out.println(t.choose(8, 9, false));
        System.out.println(t.sumUp(5));
        System.out.println(t.sumUpRecursive(5));
        System.out.println(t.testStore());


    }
}
