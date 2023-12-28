package Practise;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        // Stack Creation
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Answer Creation -  Array to be returned
        int[] answer = new int[nums.length];

        // Filling the Array with default value of -1
        Arrays.fill(answer, -1);

        for (int i = 0; i < 2 * nums.length; i++) {

            // If Stack has index and current index value is more than stored index value.
            // We update answer for stored index as current idx value is next Greater element.
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length])
                answer[stack.pop()] = nums[i % nums.length];

            // If index is within range of input array we store the index
            if (i < nums.length)
                stack.push(i);
        }
        return answer;
    }
}
