package Practise;

public class FindSmallestDivisorGivenThreshold {
    public static void main(String[] args) {
        System.out.println(new FindSmallestDivisorGivenThreshold().smallestDivisor(new int[]{1,2,5,9},6 ));
        System.out.println(new FindSmallestDivisorGivenThreshold().smallestDivisor(new int[]{44,22,33,11,1},5 ));
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int i = 1;
        int j = maxMin(nums);
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int currSum = findDivisionSum(nums, mid);
            if (currSum <= threshold) {
                ans = mid;
                j = mid - 1;
            }
            else
                i = mid + 1;
        }
        return ans;
    }

    private int findDivisionSum(int[] nums, int mid) {
        int ans = 0;
        for (int i : nums) {
            if (i % mid == 0)
                ans += i / mid;
            else
                ans += i / mid + 1;
        }
        return ans;
    }

    private int maxMin(int[] bloomDay) {
        int ans = -1;
        for (int i : bloomDay) {
            ans = Math.max(ans,i);
        }
        return ans;
    }
}
