package Practise;

public class SearchRotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println(new SearchRotatedSortedArrayII().search(new int[]{2,2,2,0,2,2}, 0));
        System.out.println(new SearchRotatedSortedArrayII().search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(new SearchRotatedSortedArrayII().search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(new SearchRotatedSortedArrayII().search(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1}, 13));
    }
    public boolean search(int[] nums, int target) {
//        int idx = findIdx(nums);
//        System.out.println(idx);
        boolean leftAns = binarySearch(nums, target, 0, nums.length-1 ) ;
        return leftAns;
//        boolean rightAns = binarySearch(nums, target, idx, nums.length-1);
//        if (!leftAns && !rightAns) {
//            return false;
//        } else if (!leftAns) {
//            return rightAns;
//        }else
//            return leftAns;
    }

//    private int findIdx(int[] nums) {
//        int i = 0;
//        int j = nums.length - 1;
//
//        while (i <= j) {
//            int mid =( j + i) / 2;
//            if (nums[mid] <= nums[(mid + nums.length - 1) % nums.length] && nums[mid] <= nums[(mid + 1) % nums.length])
//                return mid;
//            else if (nums[mid] <= nums[j])
//                j = mid - 1;
//            else
//                i = mid + 1;
//        }
//        return -1;
//    }

//    private int findIdx(int[] nums) {
//        int i = 0;
//        int j = nums.length - 1;
//        int ele = nums[nums.length - 1];
//        int ans = -1;
//        while (i <= j) {
//            int mid =(j + i) / 2;
//            if (ele >= nums[mid]) {
//                ans = mid - 1;
//                j = mid - 1;
//            }
//            else
//                i = mid + 1;
//        }
//        return ans + 1;
//    }

    private boolean binarySearch(int[] nums, int target, int i, int j) {
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] == nums[i] && nums[mid] == nums[j]){
                i++; j--;
            }
            else if (nums[i] <= nums[mid])
                if (target <= nums[mid] && target >= nums[i])
                    j = mid - 1;
                else
                    i = mid + 1;
            else
                if (target >= nums[mid] && target <= nums[j])
                    i = mid + 1;
                else
                    j = mid - 1;
        }
        return false;
    }
}
