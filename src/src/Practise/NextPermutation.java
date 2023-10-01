package Practise;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,2};
        new NextPermutation().nextPermutation(a);
        System.out.println(Arrays.toString(a));

    }

    public void nextPermutation(int[] nums) {
        int idx = -1;
        int swap = Integer.MAX_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverse(nums, 0, nums.length - 1);
            return;

        }

        for (int i = nums.length - 1; i >= idx; i--) {
            if (nums[i] > nums[idx]) {
                if (swap == Integer.MAX_VALUE)
                    swap = i;
                swap = nums[swap] > nums[i] ? i : swap;
            }
        }
        int temp = nums[idx];
        nums[idx] = nums[swap];
        nums[swap] = temp;

        reverse(nums, idx + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
    }
}
