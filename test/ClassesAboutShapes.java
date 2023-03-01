class Circle {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    int approximateCircumference() {
        return radius * 3;
    }

    boolean guessRadius(int guess) {
        return (radius == guess);
    }

}

class Rectangle {
    int a;
    int b;

    Rectangle (int a, int b) {
        this.a = a;
        this.b = b;
    }

    int getLongerEdge() {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

}

class someCollectionsOfObjects {
    int i = 4;
    Circle myCircle = new Circle(5);
    Rectangle myRectangle = new Rectangle(3, i);

    boolean checkIfRectangleWasInitializedRight() {
        if (myRectangle.getLongerEdge() == i) {
            return true;
        } else {
            return false;
        }
    }

    void manipulateRadiusOfCircle(int manipulation) {
        if (myCircle.radius != manipulation) {
            myCircle.radius = manipulation;
        }
    }

    void someWhileMethod() {
        int i;
        i = 10;
        int j = 5;;
        while (i > j) {
            j = j+1;
        }
    }

    void someWhileMethodWithWildFormatting(){
        int i; i=10;
        int j          = 5;
        ;while(i>j){j=j+1;}}


}