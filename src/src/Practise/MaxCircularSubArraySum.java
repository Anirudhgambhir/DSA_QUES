package Practise;

public class MaxCircularSubArraySum {
    public int maxSubarraySumCircular(int[] nums) {
        int sum1 = kadaneAlgo(nums);
        int sum2 = modifiedKadaneAlgo(nums);
        if(sum1 < 0){
            return sum1;
        }
        return Math.max(sum1, sum2);
    }

    private int modifiedKadaneAlgo(int[] nums) {
        int curr = 0;
        int sum = Integer.MAX_VALUE;
        int diff = 0;
        for (int i :
                nums) {
            diff +=i;
            curr += i;
            if (sum > curr)
                sum = curr;
            if(curr > 0)
                curr = 0;
        }
        return diff - sum;
    }

    private int kadaneAlgo(int[] nums) {
        int curr = 0;
        int sum = Integer.MIN_VALUE;
        for (int i :
             nums) {
            curr += i;
            if (sum < curr)
                sum = curr;
            if(curr < 0)
                curr = 0;
        }
        return sum;
    }
}
