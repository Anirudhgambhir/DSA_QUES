package Practise;

import java.util.ArrayDeque;

public class InfixToPrefix {
    public static void main(String[] args) {
        String s = infixToPostfix("(A-B/C)*(A/K-L)");
        System.out.println(s);
    }
    // ( -> )
    public static String infixToPostfix(String exp) {
        StringBuilder sb = new StringBuilder(exp);
        sb.reverse();
        StringBuilder answer = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : sb.toString().toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                answer.append(ch);
            } else if (ch == ')') {
                stack.push(ch);

            } else if (ch == '(') {
                while (stack.peek() != ')') {
                    answer.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && prec(ch) < prec(stack.peek())) {
                    answer.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty())
            answer.append(stack.pop());
        return answer.reverse().toString();
    }

    static int prec(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        if (x == '^')
            return 3;
        return -1;
    }
}
