package neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

    public static void main(String[] args) {
        // ["MinStack", "push", -2, "push", -2, "push", -3, "push", -3, "getMin", "pop", "getMin"]
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(-2);
        minStack.push(-3);
        minStack.push(-3);
        System.out.println("getMin: " + minStack.getMin()); // -3
        minStack.pop();
        System.out.println("getMin: " + minStack.getMin()); // -3
    }

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.offerFirst(val);
        if (minStack.isEmpty() || minStack.peekFirst() >= val) {
            minStack.offerFirst(val);
        }
    }

    public void pop() {
        int val = stack.pollFirst();
        if (minStack.peekFirst() == val)
            minStack.pollFirst();
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }
}
