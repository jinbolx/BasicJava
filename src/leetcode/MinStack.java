package leetcode;

public class MinStack {

    private int[] data;
    private int[] minElement;
    private int size = 0;

    public MinStack() {
        data = new int[1000];
        minElement = new int[1001];
        minElement[0] = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x < minElement[size]) {
            minElement[size + 1] = x;
        } else {
            minElement[size + 1] = minElement[size];
        }
        data[size++] = x;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size-1];
    }

    public int getMin() {
        return minElement[size];
    }
}
