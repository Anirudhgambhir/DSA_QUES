QUESTION: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/

public int singleNumber(int[] nums) {
        int result =0;
        for(int i:nums){
            result ^= i;
        }
        return result;
    }
