package leetcode;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.remove(0);
    }

    /** Get the front element. */
    public int peek() {
     return stack.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return stack.isEmpty();
    }
}
