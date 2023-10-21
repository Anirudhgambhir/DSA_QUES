package Practise;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target)
            return false;

        for (int[] arr : matrix) {
            if (binarySearch(arr, target))
                return true;
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target) {
                i = mid + 1;
            } else
                j = mid - 1;
        }
        return false;
    }
}
