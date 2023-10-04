package Practise;

public class findMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));

    }


    public static int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= nums[(mid + nums.length -1)% nums.length]  && nums[mid] <= nums[(mid + 1) % nums.length]) {
                return nums[mid];
            }
            else if (nums[mid] <= nums[nums.length - 1])
                j = mid - 1;
            else
                i = mid + 1;
        }
        return -1;
    }
}
