class Circle {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    Circle() {
        this.radius = 1;
    }
    int approximateCircumference() {
        return radius * 3;
    }

    int getRadius() {
        return radius;
    }
    boolean guessRadius(int guess) {
        return (radius == guess);
    }

    void manipulateRadiusOfCircle(int manipulation) {
        if (this.radius != manipulation) {
            this.radius = manipulation;
        }
    }

}

class Rectangle {
    int a;
    int b;

    Rectangle (int a, int b) {
        this.a = a;
        this.b = b;
    }
    Rectangle (int a) {
        this.a = a;
        this.b = a;
    }

    int getLongerEdge() {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    void makeSquareWithLongerOrSmallerEdge(boolean b) {
        if (b) {
            this.a = this.b;
        }
        else {
            this.b = this.a;
        }
    }

    boolean isSquare() {
        return (this.a == this.b);
    }

}