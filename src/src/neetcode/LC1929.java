package neetcode;

public class LC1929 {
    public int[] getConcatenation(int[] nums) {
        int ans_index = 0;
        int[] ans_array = new int[nums.length*2];

        // Initial copy (0 to nums.length)
        for (int val : nums) {
            ans_array[ans_index++] = val;
        }

        // Additional copy for (nums.length to nums.length * 2)
        for (int val : nums) {
            ans_array[ans_index++] = val;
        }

        return ans_array;
    }
}
