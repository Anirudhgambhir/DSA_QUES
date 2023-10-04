package Practise;

public class SingleElementInSortedArray {
    /**
     * <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">Question</a>
     * @param nums
     * @return Element which appears only once
     */

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];

        int i = 1;
        int j = nums.length - 2;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            else if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 != 0 && nums[mid] == nums[mid -1 ])
                i = mid + 1;
            else
                j = mid - 1;
        }
        return -1;
    }
}
