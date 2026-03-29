package neetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncodeDecodeString {

    public static void main(String[] args) {
        EncodeDecodeString encodeDecodeString = new EncodeDecodeString();
        String s = encodeDecodeString.encode(new ArrayList<>(Collections.singletonList("")));
        List<String> ss = encodeDecodeString.decode(s);
        System.out.println(ss.toString());
    }

    private final String CHARACTER_DELIMETER = ",";
    private final String WORD_DELIMETER = "#";

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();

        for (String s : strs) {
            for (char ch : s.toCharArray()) {
                int asciiVal = ch;
                str.append(asciiVal).append(CHARACTER_DELIMETER);
            }
            str.append(WORD_DELIMETER);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> results = new ArrayList<>();
        String[] words = str.split(WORD_DELIMETER);
        for (String word : words) {
            String[] letters = word.split(CHARACTER_DELIMETER);
            StringBuilder decodedWord = new StringBuilder();
            for (String letter : letters) {
                int asciiVal = Integer.parseInt(letter);
                char ch = (char) asciiVal;
                decodedWord.append(ch);
            }
            results.add(decodedWord.toString());
        }
        return results;
    }
}
