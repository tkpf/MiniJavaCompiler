package codegen.testing;

class Empty {}
class Empty2 {
    int i;
    public void seti9() {i = 9;}
    public int return1() {return 1;}
    public int return1plus1() {return 1 + 1;}
    public void doNothing() { }
}

class Store
{
    int store;

    Store(int i){
        store = i;
    }
    Store(){
        store = 0;
    }

    void countUp() {
        store = store + 1;
    }
}


class TestClass
{
    int intField;
    char charField;
    boolean boolField;
    String stringField;

    public void storeThings(int i, char c, boolean b, String s)
    {
        String h;
        h = "Hello Universe";
        intField = i;
        charField = c;
        boolField = b;
        stringField = s;
    }

    public Empty createEmpty()
    {
        return new Empty();
    }

    public int choose(int a, int b, boolean c)
    {
        if(c) { return a; }
        else { return b; }
    }


    public int sumUpRecursive(int num)
    {
        if (num == 0) {
            return 0;
        }
        return this.sumUpRecursive(num - 1) + num;
    }

    public void doNothingRecursion(int repetitions)
    {
        if (repetitions < 1)
        {
            TestClass t = new TestClass();
            t.doNothingRecursion(repetitions - 1);
        }
    }

    public Empty testMethodCall()
    {
        TestClass t = new TestClass();
        return t.createEmpty();
    }

    public boolean isSmaller(int a, int b)
    {
        return a < b;
    }

    public void spin(int i)
    {
        while(0 < i)
        {
            i = i - 1;
        }
    }

    public int count(int i)
    {
        int counter = 0;
        while(0 < i)
        {
            i = i - 1;
            counter = counter + 1;
        }
        return counter;
    }

    public void assignDebug()
    {
        int j = 5;
        j = j + 1;
    }

    public void assignDebug2()
    {
        int j;
        j = 5;
        j = j + 1;
    }

    public void incr1(int i)
    {
        i = i + 1;
    }

    public int incr1int(int i)
    {
        i = i + 1;
        return i;
    }

    public int sumUp(int num)
    {
        int res = 0;
        while (0 < num)
        {
            res = res + num;
            num = num - 1;
        }
        return res;
    }

    public String compareInts(int a, int b)
    {
        if (a == b) { return "equal";}

        if (a < b) { return "smaller"; }

        return "greater";
    }

    public String helloWorld() {return "Hello World";}


    public boolean compareObjects(Object a, Object b) {return a == b;}

    public String addStrings(String a, String b) { return a + b; }



    public int testStore()
    {
        Store st;
        st = new Store();
        st.countUp();
        st.countUp();
        st.countUp();
        st.countUp();
        return  st.store;
    }


}