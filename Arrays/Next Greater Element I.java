QUESION: https://leetcode.com/problems/next-greater-element-i/

public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()])
            {
                int index = stack.pop();
                map.put(nums2[index],nums2[i]);
            }
            stack.push(i);
        }
        for(int j = 0;j<nums1.length;j++){
            
            nums1[j] = map.getOrDefault(nums1[j],-1);
        }
        return nums1;
    }
