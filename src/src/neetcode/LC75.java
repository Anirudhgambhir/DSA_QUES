package neetcode;

import java.util.Arrays;

public class LC75 {

    public static void main(String[] args) {
        LC75 lc75 = new LC75();

        lc75.sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        int[] counter = new int[3];

        for (int i : nums) {
            counter[i]++;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter[k] == 0) {
                k++;
            }
            nums[i] = k;
            counter[k] -= 1;
        }

        System.out.println(Arrays.toString(nums));
    }
}
