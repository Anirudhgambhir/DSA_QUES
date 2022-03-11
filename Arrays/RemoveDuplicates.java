QUESTION: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/

public int removeDuplicates(int[] nums) {
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[temp] != nums[i]){
                nums[temp+1] = nums[i];
                temp++;
            }
        }
        return temp+1;
    }
