package Practise;

public class longestSubarrayWithSumKPositives {

    public static int longestSubarrayWithSumK(int []nums, long k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        long sum = 0;
        int start = 0;
        int arrstart = 0;
        int arrend = 0;

        while (i < nums.length) {
            if (sum == 0)
                start = i;

            sum += nums[i];

            if (sum == k) {
                arrstart = start;
                arrend = i;
            }

            if (sum < 0) {
                start = i;
                sum = 0;
            }
            i++;
        }
        return ans;
    }
}
