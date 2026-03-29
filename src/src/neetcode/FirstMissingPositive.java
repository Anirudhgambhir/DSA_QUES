package neetcode;

import java.util.PriorityQueue;
public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        nums[nums[3] - 1] = nums[3];

        for (int i : nums) {
            if (!minHeap.contains(i))
                minHeap.add(i);
        }
        int minValue = minHeap.peek();
        while (!minHeap.isEmpty()) {
            int value = minHeap.poll();
            if (value != minValue)
                return minValue;
            minValue++;
        }
        return minValue;
    }
}
