package practise;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        final int sizeOfMatrix = mat.length;
        int sumOfDiagonalElements = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            sumOfDiagonalElements += mat[i][i]; // Primary diagonal
            sumOfDiagonalElements += mat[i][sizeOfMatrix - 1 - i]; // Secondary diagonal
        }
        return sumOfDiagonalElements - (sizeOfMatrix % 2 == 0 ? 0 : mat[sizeOfMatrix / 2][sizeOfMatrix / 2]);
    }
}
