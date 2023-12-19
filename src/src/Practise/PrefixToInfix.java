package Practise;

import java.util.ArrayDeque;

public class PrefixToInfix {

    public static void main(String[] args) {
        String s = prefixToInfixConversion("*-a/bc-/dkl");
        System.out.println(s);
    }

    /**
     * Process -
     * 1. Reverse the prefix expression
     * 2. If Character is operand push it to stack
     * 3. If character is operator, pop 2 items from stack and combine them e.g. -> a,b,+ - a + b
     * 4. Push combined expr in stack again.
     * 5. repeat the steps.
     *
     * @param exp Prefix expression which is to be converted to Infix Form
     * @return String containing infix form of Expression provided
     */

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
