package practise;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaximumofallsubarraysofsizeK {
    public static void main(String[] args) {
        max_of_subarrays(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 9, 3);
    }


    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (i = 0; i < k; i++) {

            while (!deque.isEmpty() && arr[i] > arr[deque.peekLast()])
                deque.removeLast();

            deque.addLast(i);
        }

        for (; i < n; i++) {
            ans.add(arr[deque.peek()]);

            while (!deque.isEmpty() && deque.peekLast() <= i-k)
                deque.removeFirst();

            while ((!deque.isEmpty()) && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();

            deque.addLast(i);

        }
        ans.add(arr[deque.peek()]);
        return ans;
    }
}
