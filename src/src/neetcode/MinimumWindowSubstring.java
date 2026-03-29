package neetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int required = tMap.size();
        int left = 0;
        int startOfWindow = 0;
        int minLengthOfWindow = Integer.MAX_VALUE;
        int matches = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            if (tMap.containsKey(ch) &&
                    tMap.get(ch).intValue() == freqMap.get(ch).intValue()) {
                matches++;
            }

            while (matches == required) {
                if (right - left + 1 < minLengthOfWindow) {
                    minLengthOfWindow = right - left + 1;
                    startOfWindow = left;
                }

                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);

                if (tMap.containsKey(leftChar) &&
                        tMap.get(leftChar) > freqMap.get(leftChar)) {
                    matches--;
                }
                left++;
            }
        }
        return minLengthOfWindow == Integer.MAX_VALUE ? "" :
                s.substring(startOfWindow, startOfWindow + minLengthOfWindow);
    }
}
