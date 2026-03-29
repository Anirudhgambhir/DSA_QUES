package neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseBallGame {
    public static void main(String[] args) {
        System.out.println(new BaseBallGame().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
    public int calPoints(String[] operations) {
        Deque<Integer> operators = new ArrayDeque<>();

        for (String operation : operations) {
            if (isNumeric(operation)) {
                operators.offerFirst(Integer.parseInt(operation));
            } else {
                performOperation(operation, operators);
            }
        }

        int maxScore = 0;

        for (int score : operators) {
            maxScore += score;
        }

        return maxScore;
    }

    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) { // Check for null or empty string
            return false;
        }
        try {
            Integer.parseInt(str); // or Integer.parseInt(str) for integers only
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void performOperation(String operation, Deque<Integer> operator) {
        if (operation.equals("+")) {
            final int firstElement = operator.pollFirst();
            final int secondElement = operator.pollFirst();
            operator.offerFirst(secondElement);
            operator.offerFirst(firstElement);
            operator.offerFirst(firstElement + secondElement);
        } else if (operation.equals("D")) {
            operator.offerFirst(operator.peekFirst() * 2);
        } else {
            operator.pollFirst();
        }


    }

}
