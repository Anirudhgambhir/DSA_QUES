package Learn.Sorting.impl;

public class MergeSort {

    private int[] merge(int[] a, int n, int[] b, int m) {
        int[] k = new int[n + m];
        int i = 0;
        int j = 0;
        int p = 0;
        while (i < n && j < m) {
            if (a[i] < b[j])
                k[p++] = a[i++];
            else
                k[p++] = b[j++];
        }

        while (i < n) {
            k[p++] = a[i++];
        }

        while (j < m) {
            k[p++] = b[j++];
        }
        return k;
    }
}
