public class RecTestMain {
    public static void main(String[] args) {
        RecTest t = new RecTest();
        System.out.println(t.add());
        System.out.println(t.inc(1));
        System.out.println(t.b);
        System.out.println(t.sum(5));
        System.out.println(t.starsRec(5));

        Ball b1 = new Ball();
        System.out.println(b1.radius + " " + b1.diameter());

        Ball b2 = new Ball(5);
        System.out.println(b2.radius + " " + b2.diameter());


    }
}
