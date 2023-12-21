package Practise;

import java.util.ArrayDeque;

public class PostFixToInfix {
    public static void main(String[] args) {
        String s = postToInfix("ab+c+");
        System.out.println(s);
    }

    public static String postToInfix(String postfix) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isLetter(ch))
                stack.push(Character.toString(ch));
            else if (isOperator(ch)) {
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push("(" + s2 + ch + s1 + ")");
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '%';
    }
}
