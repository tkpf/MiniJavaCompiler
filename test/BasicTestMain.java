public class BasicTestMain {
    public static void main(String[] var0) {
        System.out.println("This is the default java compiler compiled Main file.");

        BasicTypeFieldClass basicTypeClass = new BasicTypeFieldClass();
        int i = 99; char c = 'z'; boolean b = false;
        basicTypeClass.setInteger(i);
        basicTypeClass.setChar(c);
        basicTypeClass.setBoolean(b);

        System.out.println("\nTest with BasicTypeFieldClass");
        System.out.println("----------------------------");
        System.out.println("Variables to Return:" +
                "\tInt: " + i +
                "\t Char: " + c +
                "\t Bool: " + b);
        System.out.println("Returned Variables:" +
                "\tInt: " + basicTypeClass.returnInteger() +
                "\t Char: " + basicTypeClass.returnChar() +
                "\t Bool: " + basicTypeClass.returnBoolean());


        System.out.println("\nTest with StringFieldClass");
        System.out.println("----------------------------");
        StringFieldClass strClass = new StringFieldClass();
        System.out.println("The String saved in StringFieldClass is: \n" + strClass.giveText());
        System.out.println(("The corresponding String with escape Sequence is: \n" + strClass.giveTextWithEscapeSequence()));

        System.out.println("\nTest with DirectInitClass");
        System.out.println("----------------------------");
        DirectInitClass directInitClass = new DirectInitClass();
        System.out.println("Direct initalized text is: \t" + directInitClass.returnDirectInitString());

        System.out.println("\nTest with ReturnObjectClass");
        System.out.println("----------------------------");
        int intToGive = 33;
        ReturnObjectClass objClass = new ReturnObjectClass(intToGive);
        int hiddenInteger = objClass.returnNestedObject().getAssignedInteger();
        System.out.println("Variables to Return:\t" + intToGive);
        System.out.println("Returned Variables:\t" + hiddenInteger);

        System.out.println("\nTest with AddingStrings");
        System.out.println("----------------------------");
        AddingStrings strClass1 = new AddingStrings();
        AddingStrings strClass2 = new AddingStrings("NotPeter");
        AddingStrings strClass3 = new AddingStrings("Matthias", "Kim", "Till");
        System.out.println("The project may be done by...");
        System.out.println(strClass1.getProjectStudents());
        System.out.println(strClass2.getProjectStudents());
        System.out.println(strClass3.getProjectStudents());


    }



}
