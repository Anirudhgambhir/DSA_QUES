package Practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        HashMap<Integer, Integer> elementsWithOccurrences = new HashMap<>();
        for (int element : nums) {
            if (elementsWithOccurrences.containsKey(element))
                elementsWithOccurrences.replace(element, elementsWithOccurrences.get(element) + 1);
            else
                elementsWithOccurrences.put(element, 1);
        }

        for (int element : elementsWithOccurrences.keySet()) {
            if (elementsWithOccurrences.get(element) > (nums.length / 3))
                majorityElements.add(element);
        }
        return majorityElements;
    }

    public List<Integer> majorityElementEfficient(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        int countOfElement1 = 0;
        int countOfElement2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for (int element : nums) {
            if (countOfElement1 == 0 && element2 != element) {
                element1 = element;
                countOfElement1 = 1;
            } else if (countOfElement2 == 0 && element1 != element) {
                element2 = element;
                countOfElement2 = 1;
            } else if (element == element1)
                countOfElement1++;
            else if (element == element2)
                countOfElement2++;
            else {
                countOfElement1--;
                countOfElement2--;
            }
        }
        countOfElement1 = 0;
        countOfElement2 = 0;

        for (int element : nums){
            if (element1 == element)
                countOfElement1++;
            else if (element2 == element)
                countOfElement2++;
        }

        if (countOfElement1 > (nums.length / 3))
            majorityElements.add(element1);

        if (countOfElement2 > (nums.length / 3))
            majorityElements.add(element2);

        return majorityElements;
    }
}
