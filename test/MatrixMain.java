public class MatrixMain {
    public static void main(String[] args) {
        int[][] aM1 = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};
        Matrix m1 = getMatrix(aM1);
        int[][] aM2 = {{1,2},
                       {4,5},
                       {7,8}};
        Matrix m2 = getMatrix(aM2);
        int[][] aM3 = {{1,2,3},
                       {4,5,6}};
        Matrix m3 = getMatrix(aM3);

        printMatrix(m1);
        printMatrix(m1.plus(m1));
        System.out.println(m1.plus(m1).equals(m1.mult(2)));

        printMatrix(m1.mult(m1));
        printMatrix(m2.mult(m3));

        printMatrix(m2);
        printMatrix(m2.transpose());
    }

    public static void printMatrix(Matrix mat) {
        for (int n = 0; n < mat.rows; n++) {
            for (int m = 0; m < mat.columns; m++) {
                System.out.print(mat.getValue(n,m) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printVector(LinkedVector vec) {
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec.get(i) + " ");
        }
        System.out.println();
    }

    public static Matrix getMatrix(int[][] arrayMatrix) {
        Matrix result = new Matrix();
        for (int[] col : arrayMatrix) {
            LinkedVector newRow = new LinkedVector();
            for (int val : col) {
                newRow.add(val);
            }
            result.addRow(newRow);
        }
        return result;
    }
}
