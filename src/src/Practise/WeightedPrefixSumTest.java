package Practise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightedPrefixSumTest {

    static WeightedPrefixSum weightedPrefixSum;

    static int[] arr;

    @BeforeEach
    void setup(){
        arr = new int[]{2,3,5,7,4,2,4,7,1,2};
        weightedPrefixSum = new WeightedPrefixSum();
    }

    @Test
    public static void testSuccess(){
        int ans = weightedPrefixSum.weightedPrefixSum(arr, arr.length, 0,2);
        Assertions.assertEquals(ans, 23);
    }

    @Test
    public static void test2(){
        int ans = weightedPrefixSum.weightedPrefixSum(new int[]{}, 0, 0,2);
        Assertions.assertEquals(ans, 0);
    }

}