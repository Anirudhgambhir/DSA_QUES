package Learn.Sorting.impl;

import Learn.Sorting.Sort;

import java.util.Arrays;

public class SelectionSort implements Sort {

    public static void main(String[] args) {
        int[] a = new int[]{4, 1 ,3, 9, 7,};
            new SelectionSort().sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            swap(a, min, i);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
