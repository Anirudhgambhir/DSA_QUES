package Practise;


import java.util.Arrays;

public class FindAPeakElementII {
    public static void main(String[] args) {
        int[] a = new FindAPeakElementII().findPeakGrid(new int[][]{{1, 4}, {3, 2}/*, {7, 16, 32}*/});
        System.out.println(Arrays.toString(a));
    }

    /**
     * There are 3 Approaches for this
     * 1. Loop through matrix for each row find peak element, and then compare above and below elements
     * 2. Loop through matrix for each row find max element's index, and then compare above and below elements
     * Idea for 2 is if element is max, it will be peak for that row.
     *
     * 3. Instead of looping through matrix, using Binary search get mid, for mid-find max element's index
     * and then compare above and below elements. If true we have answer, else if mid + 1 row is higher we move low to
     * mid + 1, similarly for mid - 1 row is higher we move high to mid - 1
     * @param mat
     * @return
     */

        public int[] findPeakGridNaive(int[][] mat) {
        boolean curr = false;
        for (int i = 0; i < mat.length; i++) {
            int j = max(mat[i]);
            if (j != -1) {
                curr = true;
                if (i > 0)
                    curr = mat[i][j] > mat[i - 1][j] ? curr : false;
                if (i < mat.length - 1)
                    curr = mat[i][j] > mat[i + 1][j] ? curr : false;
            }
            if (curr)
                return new int[]{i, j};
        }
        return new int[0];
    }
    public int[] findPeakGrid(int[][] mat) {
        boolean below = true, above = true;
        int i = 0;
        int end = mat.length - 1;
        while (i <= end) {
            int mid = i + (end) / 2;
            int j = max(mat[mid]);
            below = mid - 1 >= i && mat[mid][j] < mat[mid - 1][j];
            above = mid + 1 <= end && mat[mid][j] < mat[mid + 1][j];

            if (!below && !above)
                return new int[]{mid, j};

            if (below)
                end = mid - 1;
            else
                i = mid + 1;
        }
        return new int[0];
    }

    private int max(int[] a) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans = a[ans] > a[i] ? ans : i;
        }
        return ans;
    }


    private int findPeakElement(int[] a) {
        if (a.length == 0 || a[0] > a[1])
            return 0;
        if (a[a.length - 1] > a[a.length - 2])
            return a.length - 1;

        int i = 1;
        int j = a.length - 2;

        while (i <= j) {
            int mid = i + j / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
                return mid;
            else if (a[mid] > a[mid - 1]) {
                i = mid + 1;
            } else
                j = mid - 1;
        }
        return -1;
    }
}
