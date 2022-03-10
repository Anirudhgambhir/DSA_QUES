QUESTION: https://leetcode.com/problems/move-zeroes/

public void moveZeroes(int[] nums) {
        int left =0,right = 0;
        if(nums.length > 1){
           while(right < nums.length){
            if(nums[right] == 0){
                right++;
                continue;
            }
            else if(nums[right] != 0 && nums[left] == 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                
            }
            right++; left++;
        } 
        }
        
    }
