package practise;

public class SummedMatrix {

    // Solution is correct but for higher value of "n" throws OutOfMemoryError
    static long sumMatrix(long n, long q) {
        long[][] matrix = new long[(int) n][(int) n];
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i + j + 2;
                count = matrix[i][j] == q ? ++count : count;
            }
        }
        return count;
    }

    static long sumMatrixEfficient(long n, long q) {
        if (q > 2 * n)
            return 0;
        if (n < q)
            return n - (q - n) + 1;
        else
            return q - 1;
    }


}
