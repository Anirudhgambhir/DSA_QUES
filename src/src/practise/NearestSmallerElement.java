package practise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class NearestSmallerElement {
    private static ArrayList<Integer> answerConverter(int[] ints) {
        ArrayList<Integer> intList = new ArrayList<Integer>(ints.length);
        for (int i : ints) {
            intList.add(i);
        }
        return intList;
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        // Stack Creation
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Answer Creation -  Array to be returned
        int[] answer = new int[A.size()];

        // Filling the Array with default value of -1
        Arrays.fill(answer, -1);

        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) > A.get(i))
                answer[stack.pop()] = A.get(i);

            stack.push(i);
        }
        return answerConverter(answer);

    }
}
