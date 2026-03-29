package practise;

import java.util.ArrayDeque;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        char[] strArray = s.toCharArray();
        int start = 0;
        int end;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] == '(') {
                if (stack.isEmpty()) {
                    start = i;
                }
                stack.push(strArray[i]);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    end = i;
                    strArray[start] = ' ';
                    strArray[end] = ' ';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : strArray) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
