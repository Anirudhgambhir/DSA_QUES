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
}
