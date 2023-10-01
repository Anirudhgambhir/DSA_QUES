package Practise;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        boolean search = search(new int[]{2,5,6,0,0,1,2}, 0);
        System.out.println(search);
    }

    public static boolean search(int[] nums, int target) {
        int idx = findIndex(nums);
        boolean leftAns = binarySearch(nums, target, 0, idx - 1);
        boolean rightAns = binarySearch(nums, target, idx, nums.length - 1);
        if (!leftAns && !rightAns) {
            return false;
        } else if (!leftAns) {
            return rightAns;
        }else
            return leftAns;
    }

    private static boolean binarySearch(int[] a, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target)
                return true;
            else if (a[mid] < target) {
                left = mid + 1;
            }else
                right = mid - 1;
        }
        return false;
    }

    private static int findIndex(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] <= a[(mid + a.length - 1) % a.length] && a[mid] <= a[(mid + 1) % a.length])
                return mid;
            else if (a[mid] <= a[right]) {
                right = mid - 1;
            }else
                left = mid + 1;
        }
        return -1;
    }
}
