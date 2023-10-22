package Practise;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySumEfficient(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int ans = 0;
        map.put(0,1);
        for (int num : nums) {
            preSum += num;
            int temp = preSum - k;
            ans += map.getOrDefault(temp, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }

    public int subarraySumNaive(int[] nums, int k) {
        int ans= 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    ans++;
            }
        }
        return ans;
    }
}
