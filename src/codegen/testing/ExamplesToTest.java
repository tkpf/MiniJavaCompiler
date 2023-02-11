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

        Store(){
            store = 0;
        }

        void countUp() {store = store + 1;}
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





