package Practise;

public class AllocateMinimumNumberOfPages {
    /**
     * <a href="https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1">Problem</a>
     */
    public static int findPagesEfficient(int[] A, int N, int M) {
        if (M > N) return -1;
        if (N == 1) return A[0];
        if (M == 1) return sum(A, 0, N - 1);

        int sum = sum(A, 0, N - 1);
        int max = max(A);

        int ans = -1;
        while (max <= sum) {
            int mid = (max + sum) / 2;
            if (isPossible(A, M, mid)) {
                ans = mid;
                sum = mid - 1;
            } else
                max = mid + 1;
        }
        return ans;
    }

    private static boolean isPossible(int[] a, int m, int mid) {

        int kids = 1;
        int sum = 0;
        for (int j : a) {
            if (sum + j < mid)
                sum += j;
            else {
                kids++;
                sum = j;
            }
        }
        return kids <= m;
    }

    private static int max(int[] a) {
        int max = 0;
        for (int i : a)
            max = Math.max(max, i);
        return max;
    }

    public static int findPages(int[] A, int N, int M) {
        if (M > N) return -1;
        if (N == 1) return A[0];
        if (M == 1) return sum(A, 0, N - 1);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            res = Math.min(res, Math.max(findPages(A, i, M - 1), sum(A, i, N - 1)));
        }
        return res;
    }

    private static int sum(int[] a, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += a[k];
        }
        return sum;
    }
}
