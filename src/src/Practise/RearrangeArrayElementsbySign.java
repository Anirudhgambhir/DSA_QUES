package Practise;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/rearrange-array-elements-by-sign/description/">Question</a>
 */
public class RearrangeArrayElementsbySign {

    public static void main(String[] args) {
        int[] ints = rearrangeArrayEfficient(new int[]{28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] rearrangeArrayEfficient(int @NonNull [] a) {
        int pos = 0;
        int neg = 1;
        int[] ans = new int[a.length];
        for (int j : a)
            if (j > 0) {
                ans[pos] = j;
                pos += 2;
            } else {
                ans[neg] = j;
                neg += 2;
            }
        return ans;
    }


    public int[] rearrangeArray(int[] nums) {
        int[] pa = new int[nums.length / 2];
        int[] na = new int[nums.length / 2];
        int pi = 0;
        int ni = 0;
        for (int i : nums) {
            if (i > 0) {
                pa[pi++] = i;
            } else {
                na[ni++] = i;
            }
        }
        int i = 0;
        pi = 0;
        ni = 0;
        while (i < nums.length) {
            if (i % 2 == 0)
                nums[i++] = pa[pi++];
            else
                nums[i++] = na[ni++];
        }
        return nums;
    }
}
