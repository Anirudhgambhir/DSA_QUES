package Learn.Sorting.impl;

public class MergeSort {

    void merge(int a[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];


        int i = 0;
        int j = 0;
        int p = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j])
                a[p++] = L[i++];
            else
                a[p++] = R[j++];
        }

        while (i < n1) {
            a[p++] = L[i++];
        }

        while (j < n2) {
            a[p++] = R[j++];
        }
    }
    void mergeSort(int a[], int l, int r)
    {
        if (r > l) {
            int mid = l + (r - l) /2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }
}
