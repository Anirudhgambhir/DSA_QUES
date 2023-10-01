package Practise;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int i = new LongestConsecutiveSequence().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        System.out.println(i);

    }

    public int longestConsecutive(int[] nums) {
        int ans = -1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int temp = i;
                while (set.contains(temp + 1)) {
                    count++;
                    temp++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
