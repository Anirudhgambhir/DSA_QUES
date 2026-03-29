package neetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(new int[]{2, 4, -4, -1})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean shouldPush = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peekFirst() > 0) {
                int element = stack.peekFirst();
                if (Math.abs(element) == Math.abs(asteroid)) {
                    stack.pollFirst();
                    shouldPush = false;
                    break;
                } else if (Math.abs(element) < Math.abs(asteroid)) {
                    stack.pollFirst();
                } else {
                    shouldPush = false;
                    break;
                }
            }
            if (shouldPush) stack.offerFirst(asteroid);
        }
        int[] answer = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            answer[i++] = stack.pollFirst();
        }
        return answer;
    }
}
