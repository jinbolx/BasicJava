package dataStruct;

public class MyQueue {

    private int front = -1;
    private int back = -1;
    private int currentSize;
    private int[] items;
    private final int DEFAULT_SIZE = 1000;

    public MyQueue() {
        items = new int[DEFAULT_SIZE];
    }

    public void push(int x) {
        if (currentSize < DEFAULT_SIZE) {
            items[++back] = x;
            currentSize++;
        } else {
            throw new IllegalStateException();
        }
    }

    public int pop() {
        if (currentSize > 0) {
            currentSize--;
            return items[++front];
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }
}
