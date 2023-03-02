public class ShapeMain {
    public static void main(String[] var0) {
        System.out.println("This is the default java compiler compiled Main file.");

        // make unique circle and circle with radius 5
        Circle c1 = new Circle();
        Circle c2 = new Circle(5);

        System.out.println("\nTest with Circle CLass");
        System.out.println("----------------------------");
        System.out.println("The first circle as radius \t"+ c1.getRadius() + "\tand appr. circumference\t" + c1.approximateCircumference());
        System.out.println("The first circle as radius \t"+ c2.getRadius() + "\tand appr. circumference\t" + c2.approximateCircumference());
        System.out.println("Ergo the guess r=5 is\t" + c1.guessRadius(5) +"\t for the first circle, but\t" + c2.guessRadius(5)+ "\tfor the second one.");

        System.out.println("Lets manipulate the radius of circle 1 and test again:");
        c1.manipulateRadiusOfCircle(5);
        System.out.println("Now the guess r=5 is (hopefully) also\t" + c1.guessRadius(5));

        // make two rectangles
        Rectangle rec1 = new Rectangle(2);
        Rectangle rec2 = new Rectangle(2,4);

        System.out.println("\nTest with Rectangle Class");
        System.out.println("----------------------------");
        System.out.println("Is rec1 a square?\t" + rec1.isSquare());
        System.out.println("Is rec2 a square?\t" + rec2.isSquare());

        System.out.println("What is the longer edge of rec2?\t" + rec2.getLongerEdge());
        System.out.println("Lets make the rec2 a square with the longer edge:");
        rec2.makeSquareWithLongerOrSmallerEdge(true);
        System.out.println("Rec2 is now a square:\t" + rec2.isSquare());

    }




}
