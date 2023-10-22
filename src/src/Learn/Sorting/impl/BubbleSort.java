package Learn.Sorting.impl;

import Learn.Sorting.Sort;

public class BubbleSort implements Sort{
    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j+1])
                    swap(a,j,j+1);
            }
        }
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
