package Practise;

public class Median2SortedArray {

    public static void main(String[] args) {
        double v = medianOfArrays(3, 4, new int[]{1, 5, 9}, new int[]{2, 3, 6, 7});
        System.out.println(v);
    }
    static double medianOfArrays(int n, int m, int a[], int b[]) {
        return n > m ? binarySearch(n, m, a, b) : binarySearch(m, n, b, a);
    }

    private static double binarySearch(int n, int m, int[] a, int[] b) {
        int i = 0;
        int j = m - 1;
        while (i <= j) {
            int i1 = (i + j) / 2;
            int i2 = (n + m + 1) / 2 - i1;
            int min1 = i1 == m ? Integer.MAX_VALUE : b[i1];
            int max1 = i1 == 0 ? Integer.MIN_VALUE : b[i1 - 1];
            int min2 = i2 == n ? Integer.MAX_VALUE : a[i2];
            int max2 = i2 == 0 ? Integer.MIN_VALUE : a[i2 - 1];
            if (min2 >= max1 && min1 >= max2) {
                if ((m + n) % 2 == 0) {
                    return ((double) (Math.max(max1, max2) + Math.min(min1, min2))) / 2;
                } else
                    return Math.max(max1, max2);
            } else if (min2 < max1) {
                j = i1 - 1;
            } else
                i = i1 + 1;
        }
        return 0;

    }
}
