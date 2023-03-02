class RecTest {
    int i = 1;
    int j = -1;

    int add() {
        return i+j;
    }
    int inc(int i) {
        return i+1;
    }

    boolean b = 3 < 1;

    int sum(int n) {
        int result = 0;
        while (0 < n) {
            result = result + n;
            n = n - 1;
        }
        return result;
    }

    String starsRec(int n) {
        if (n == 0) {
            return "";
        } else {
            String out = "";
            int count = n;
            while (0 < count) {
                out = out + "*";
                count = count - 1;
            }
            return out + "\n" + starsRec(n-1);
        }
    }
}

class Ball {
    int radius = 0;
    Ball() {return;}
    Ball(int r) {
        radius = r;
    }

    int diameter() {
        int result = 0;
        result = this.radius;
        return result * 2;
    }
}