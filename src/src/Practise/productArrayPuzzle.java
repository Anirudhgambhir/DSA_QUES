package Practise;

/**
 * @Documentation
 * Your task is to complete the function productExceptSelf()
 *  @params array nums[] and n
 *  @returns list of n integers denoting the product array P.
 *   If the array has only one element the returned list should contain one value i.e {1}
 *  Problem - <a href="https://practice.geeksforgeeks.org/problems/product-array-puzzle4525/1">Link</a>
 *  Approaches
 *  1 -> Division based approach
 *  2 -> 2 Pass approach
 */
public class productArrayPuzzle {
    public static long[] productExceptSelf(int[] nums, int n)
    {
        long[] ans = new long[n];
        int productExcept0 = 1;
        int productOfAll = 1;
        int countOf0 = 0;
        for (int i : nums) {
            if (i == 0)
                countOf0++;

            if (i != 0)
                productExcept0 *= i;

            productOfAll *= i;
        }
        for (int i = 0; i < n; i++) {

            if (nums[i] == 0 && countOf0 == 1)
                ans[i] = productExcept0;

            else if (nums[i] == 0 && countOf0 > 1) {
                ans[i] = 0;
            }
            else
                ans[i] = productOfAll / nums[i];

        }
        return ans;
    }

    public static long[] productExceptSelfApproach2(int[] nums, int n) {
        if (n == 1) {
            return new long[]{1};
        }

        int i;
        long temp = 1;
        long[] prod = new long[n];
        for (int j = 0; j < n; j++)
            prod[j] = 1;

        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= nums[i];
        }

        temp = 1;

        for (i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= nums[i];
        }
        return prod;
    }
}
