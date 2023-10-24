package Learn.Sorting.impl;

import Learn.Sorting.Sort;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            int j = i-1;
            while (j > 0 && a[j] > val) {
                a[j + 1] = a[j];
                j--;
            }
            a[j+1] = val;
        }
    }
}
