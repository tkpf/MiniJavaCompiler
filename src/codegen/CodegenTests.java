package codegen;

public class CodegenTests {

    class Empty {}

    class Store
    {
        int store;

        Store(){
            store = 0;
        }

        void add1() {store = store + 1;}
    }

    class TestClass
    {
        int intField;               // Kann der Parser das Feld "int a = 5;" lesen?
        char charField;
        boolean boolField;
        String stringField;

        public void storeThings(int i, char c, boolean b, String s)
        {
            String h = "Hello Universe";
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

        public int sumUpRecursive(int num)
        {
            if (num == 0) {
                return 0;
            }
            return num + sumUpRecursive(num - 1);
        }

        public int testStore()
        {
            Store st = new Store();
            st.add1();
            st.add1();
            st.add1();
            st.add1();
            return  st.store;
        }

    }

    //storeThings(1, 'Q', false, "foo");


}
