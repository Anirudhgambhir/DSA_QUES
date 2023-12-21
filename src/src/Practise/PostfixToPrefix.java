package Practise;

import java.util.ArrayDeque;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String s = postfixToPrefix("ab+cd-*");
        System.out.println(s);
    }

    public static String postfixToPrefix(String exp) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (char ch : exp.toCharArray()) {
            if (Character.isLetter(ch))
                stack.push(Character.toString(ch));
            else if (isOperator(ch)) {
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push(ch + s2 + s1);
            }

        }
        return stack.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '%';
    }
}
