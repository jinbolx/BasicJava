package dataStruct;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        list = new ArrayList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        list.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * Get the top element.
     */
    public int top() {
        return list.get(list.size()-1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list.size()==0;
    }
}
