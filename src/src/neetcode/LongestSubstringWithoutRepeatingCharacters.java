package neetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> characterToIndexMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if (characterToIndexMap.containsKey(s.charAt(right))) {
                left = Math.max(left, characterToIndexMap.get(s.charAt(right)) + 1);
            }

            characterToIndexMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
