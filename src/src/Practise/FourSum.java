package Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    // BRUTE FORCE
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> uniqueList = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        long sum = nums[i] + nums[j];
                        sum += nums[k];
                        sum += nums[l];

                        if (sum == target) {
                            List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(quadruplet);
                            uniqueList.add(quadruplet);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(uniqueList);
    }

    // Better Approach than Brute
    public List<List<Integer>> fourSumBetter(int[] nums, int target) {
        Set<List<Integer>> uniqueList = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Long> findFourthElement = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long remaining = target - sum;
                    if (findFourthElement.contains(remaining)) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], (int) remaining);
                        Collections.sort(quadruplet);
                        uniqueList.add(quadruplet);
                    }
                    findFourthElement.add((long) nums[k]);
                }
            }
        }
        return new ArrayList<>(uniqueList);
    }

    // Efficient Approach
    public List<List<Integer>> fourSumEfficient(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadrupletList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    long sum = (int) nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        quadrupletList.add(quadruplet);
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return quadrupletList;
    }
}
