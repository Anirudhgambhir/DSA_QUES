package Practise;

import java.util.HashMap;

public class LongestSubarrayWithZeroSum {
    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static int getLongestZeroSumSubarrayLengthEfficient(int[] arr) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int max = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0)
                max = Math.max(max, i + 1);
            else {
                if (prefixSumMap.get(sum) != null)
                    max = Math.max(max, i - prefixSumMap.get(sum));
                else
                    prefixSumMap.put(sum, i);
            }
        }
        return max;
    }
}
