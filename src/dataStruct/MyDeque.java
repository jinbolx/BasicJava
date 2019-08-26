package dataStruct;

public class MyDeque {

    private int[] data;
    private int currentSize;
    private final int DEFAULT_CAPACITY = 16;
    private final int current_capacity= DEFAULT_CAPACITY;
    private int font = -1;
    private int back = 1;

    public MyDeque() {
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void push(int x) {
        if (font+1+1-back>currentSize-1){
            ensureCapacity(current_capacity*2);
        }
        data[++font]=x;
        currentSize++;
    }

    public int pop() {
        return -1;
    }

    public void inject(int x) {
    }

    public int eject(int x) {
        return -1;
    }

    private void ensureCapacity(int size) {
        int[] oldArray = data;
        data = new int[size];
        if (currentSize > 0) {
            for (int i = 0; i <= font; i++) {
                data[i] = oldArray[i];
            }
            for (int i = 0; i >= back; i--) {
                data[size-1+i]=oldArray[currentSize-1+i];
            }
        }

    }
}
