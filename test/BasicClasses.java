class emptyClass {}

class ConstructorClass{
    ConstructorClass(){}
}

class FieldHoldingClass {
    int field1;
    char field2;
    boolean field3;
}

class EmptyMethodClass {
    void doNothing(){

    }
}

class MethodWithInputClass{
    void thisMethodHasAnInput(int i) {

    }
}

class ReturnMethodClass{
    int returnFive(){
        return 5;
    }
    boolean returnTrue(){
        return true;
    }
    char returnAnA(){
        return 'a';
    }
    String returnHello(){
        return "Hello";
    }
}

class BasicTypeFieldClass {
    BasicTypeFieldClass(){}
    int field1;
    char field2;
    boolean field3;

    void setInteger(int i) {
        field1 = i;
    }
    void setChar(char c) {
        field2 = c;
    }
    void setBoolean(boolean b) {
        field3 = b;
    }
    int returnInteger() {
        return field1;
    }
    char returnChar() {
        return field2;
    }
    boolean returnBoolean() {
        return field3;
    }
}

class StringFieldClass {
    String field1;
    String field2;

    StringFieldClass() {
        field1 = "This is some text \n with new line!";
        field2 = "This is some text \\n without new line!";
    }

    String giveText() {
        return field1;
    }
    String giveTextWithEscapeSequence() {
        return field2;
    }
}

class DirectInitClass {
    DirectInitClass(){}
    int field1 = 1;
    char field2 = 'a';
    boolean field3 = true;
    String field4 = "I love my mamma!";

    int returnDirectInitInt() {
        return field1;
    }
    String returnDirectInitString() {
        return field4;
    }

}

class ConstructorClassWithThisAssignment {
    int i;
    ConstructorClassWithThisAssignment(int i) {
        this.i = i;
    }

    int getAssignedInteger() {
        return i;
    }
}

class ObjectAssignmentClass {
   ConstructorClass i = new ConstructorClass();
}

class ReturnObjectClass {
    ReturnObjectClass() {}
    ConstructorClassWithThisAssignment nestedClass;
    ReturnObjectClass(int ArgToPass) {
        nestedClass = new ConstructorClassWithThisAssignment(ArgToPass);
    }
    ConstructorClassWithThisAssignment returnNestedObject() {
        return nestedClass;
    }

}

class commentClass {
    //this part is empty but containes strong words: this super int String
    /*
    this is also
    very
    very
    empty
    */
}


class IfAndWhileMethods {
    IfAndWhileMethods(){}
    void someWhileMethod() {
        int i;
        i = 10;
        int j = 5;;
        while (i > j) {
            j = j+1;
        }
    }

    int someIfMethod() {
        int i = 0;
        if (true) {
            i = 1;
        }
        return i;
    }

    int SomeIfElseMethod(boolean b) {
        int i;
        if (b) {
            i = 1;
        }
        else {
            i = 0;
        }
        return i;
    }

}

class AddingStrings {
    String student1 = "Peter";
    String student2 = "Horst";
    String student3 = "Barbara";

    AddingStrings() {}
    AddingStrings(String student1) {
        this.student1 = student1;
    }
    AddingStrings(String student1, String student2) {
        this.student1 = student1;
        this.student2 = student2;
    }
    AddingStrings(String student1, String student2, String student3) {
        this.student1 = student1;
        this.student2 = student2;
        this.student3 = student3;
    }

    String getProjectStudents() {
        return ("This project was done by " + student1 + ", " + student2 + ", " + student3 + "!");
    }
}

class WildFormatting {
        int i;char a2343;boolean B734skjdo;
        ;
        void someWhileMethodWithWildFormatting(){
        ;
        int i; i=10;
        int j          = 5;
        ;while(i>j){j=j+1;}}

        }
