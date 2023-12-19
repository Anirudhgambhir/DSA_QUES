package Practise;

import java.util.ArrayDeque;

public class PrefixToInfix {

    public static void main(String[] args) {
        String s = prefixToInfixConversion("*-a/bc-/dkl");
        System.out.println(s);
    }

    public static String prefixToInfixConversion(String exp) {
        // Reverse Expression
        StringBuilder sb = new StringBuilder(exp);
        sb.reverse();

        // Stack Declaration
        ArrayDeque<String> stack = new ArrayDeque<>();

        // Logic to convert
        for (char ch : sb.toString().toCharArray()) {
            if (Character.isLetter(ch))
                stack.push(Character.toString(ch));
            else if (isOperator(ch)) {
                stack.push("(" + stack.pop() + ch + stack.pop() + ")");
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '%';
    }
}
