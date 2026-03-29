package neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.offerFirst(c);
            }
            else if (c == ')' && stack.peekFirst() != '(' ||
                    c == '}' && stack.peekFirst() != '{' ||
                    c == ']' && stack.peekFirst() != '[') {
                return false;
            }
            else {
                stack.pollFirst();
            }
        }
        return true;
    }
}
