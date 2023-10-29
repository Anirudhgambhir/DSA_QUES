package Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    // Brute Force Approach
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> tripletsWithSum0 = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> indexOfTriplets = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(indexOfTriplets);
                        tripletsWithSum0.add(indexOfTriplets);
                    }
                }
            }
        }
        return new ArrayList<>(tripletsWithSum0);
    }

    // O(N^2) approach
    public List<List<Integer>> threeSumBetterApproach(int[] nums) {
        Set<List<Integer>> uniqueTripletsWithSum0 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> elementsPresentInArray = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int k = -(nums[i] + nums[j]);
                if (elementsPresentInArray.contains(k)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(temp);
                    uniqueTripletsWithSum0.add(temp);
                }
                elementsPresentInArray.add(nums[j]);
            }
        }
        return new ArrayList<>(uniqueTripletsWithSum0);
    }

    //Efficient Approach
    public List<List<Integer>> threeSumEfficient(int[] nums) {
        List<List<Integer>> tripletsWithSum0 = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    tripletsWithSum0.add(temp);
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return tripletsWithSum0;
    }
}
