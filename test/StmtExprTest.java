class A {
    int a = 1;
    boolean b;
    int m2(int a) {return a;}
}
class StmtExprTest {
    A a = new A();
    void v() {
        int j = 0;
        boolean b;
        A aa;
        new A();

        A aaa = new A();
        aaa.m2(1);

        int i = aaa.m2(j);
        j = a.a;
        aaa.a = a.m2(i);
    }

}
