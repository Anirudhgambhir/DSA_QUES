package Practise;

import java.util.ArrayList;

public class RowWithMax1s {
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int max1 = -1;
        int ans = 0;
        for (int i =0; i < matrix.size(); i++) {
            int curr = binarySearch(matrix.get(i));
            if (curr > max1) {
                max1 = curr;
                ans = i;
            }
        }
        return ans;
    }

    private static int binarySearch(ArrayList<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        int ans = list.size();
        while (i <= j) {
            int mid = (i + j) / 2;
            if (list.get(mid) == 1) {
                ans = mid;
                j = mid - 1;
            } else
                i = mid + 1;
        }
        return list.size() - ans;
    }
}
