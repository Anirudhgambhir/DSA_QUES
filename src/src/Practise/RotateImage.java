package Practise;

public class RotateImage {
    /**
     * We have to rotate a matrix by 90 degrees
     * The basic approach here :-
     * 1. We do the transpose of a matrix.
     * 2. We reverse each row of the matrix
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] ints : matrix) {
            reverse(ints);
        }

    }

    private void reverse(int[] array) {
        int i = 0;
        int j = array.length-1;
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            j--; i++;
        }
    }
}
