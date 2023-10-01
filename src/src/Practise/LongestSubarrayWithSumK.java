package Practise;

import java.util.HashMap;

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {
        int longestSubarray = getLongestSubarray(new int[]{1, 2, 2, 3}, 4);
        System.out.println(longestSubarray);
    }

    public static int getLongestSubarray(int []nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];

            if (sum == k)
                ans = Math.max(i+1, ans);

            int rem = sum - k;

            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                ans = Math.max(ans, len);
            }


            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
