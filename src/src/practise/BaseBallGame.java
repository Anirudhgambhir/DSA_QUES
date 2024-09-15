package practise;

import java.util.List;

public class BaseBallGame {
    private final List<Integer> answers = new java.util.ArrayList<>();

    public int calPoints(String[] operations) {
        for (String operation : operations) {
            handleOperation(operation);
        }
        return answers.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Handles operation based on the input string
     *
     * @param operation - operation to be performed
     */
    private void handleOperation(final String operation) {
        switch (operation) {
            case "+":
                answers.add(answers.get(answers.size() - 1) +
                        answers.get(answers.size() - 2));
                break;
            case "D":
                answers.add(answers.get(answers.size() - 1) * 2);
                break;
            case "C":
                answers.remove(answers.size() - 1);
                break;
            default:
                answers.add(Integer.parseInt(operation));
                break;
        }
    }
}
