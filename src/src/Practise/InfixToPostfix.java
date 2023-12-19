package Practise;

import java.util.ArrayDeque;

public class InfixToPostfix {
    public static void main(String[] args) {
        String answet = infixToPostfix("3^(1+1)");
        System.out.println(answet);
    }


    public static String infixToPostfix(String exp) {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character c : exp.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c))
                sb.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (stack.peek() != '(')
                    sb.append(stack.pop());
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek()))
                    sb.append(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
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
