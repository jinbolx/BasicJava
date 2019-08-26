package leetcode;

import java.util.Stack;

public class StackImpQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public static void main(String[] args) {

    }

    /**
     * Initialize your data structure here.
     */
    public StackImpQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return 0;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return 0;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
}
