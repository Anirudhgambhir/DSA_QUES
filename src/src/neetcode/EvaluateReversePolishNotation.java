package neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"1","2","+","3","*","4","/"}));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            performOperation(stack, token);
        }
        return stack.peekFirst();
    }


    private void performOperation(final Deque<Integer> stack, final String token) {
        int element1 = 0, element2 = 0;
        if (stack.size() > 1 && isOperator(token)) {
            element1 = stack.pollFirst();
            element2 = stack.pollFirst();
        }
        switch (token) {
            case "+":
                stack.offerFirst(element1 + element2);
                break;
            case "-":
                stack.offerFirst(element2 - element1);
                break;
            case "*":
                stack.offerFirst(element1 * element2);
                break;
            case "/":
                stack.offerFirst(element2 / element1);
                break;
            default:
                // Assume apart from operations it will always be a number
                stack.offerFirst(Integer.parseInt(token));
                break;
        }
    }

    private boolean isOperator(final String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
