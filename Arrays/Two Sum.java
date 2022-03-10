Question: https://leetcode.com/problems/two-sum/

public int[] twoSum(int[] nums, int target) {
        // HASHMAP APPROACH
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return null;
        }
     
        
        
        
public int[] twoSum(int[] nums, int target) {      
    //BRUTE FORCE 
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target ){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
