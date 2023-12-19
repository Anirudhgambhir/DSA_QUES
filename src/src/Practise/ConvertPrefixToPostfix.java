package Practise;

import java.util.ArrayDeque;

public class ConvertPrefixToPostfix {
    public static String preToPost(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (char ch : sb.toString().toCharArray()) {
            if (Character.isLetter(ch))
                stack.push(Character.toString(ch));
            else if (isOperator(ch))
                stack.push(stack.pop() + stack.pop() + ch);
        }

        return stack.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '%';
    }
}
