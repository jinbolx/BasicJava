package dataStruct;

@SuppressWarnings("unchecked")
public class BinaryHeap<E extends Comparable<? super E>> {

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private E[] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int size) {
        this((E[]) new Comparable[size]);
    }

    public BinaryHeap(E[] array) {
        this.array = array;
        currentSize = 0;
    }

    public void insert(E e) {
        if (currentSize == array.length - 1) {
            ensureLargeArray(2 * array.length + 1);
        }
        int currentIndex = ++currentSize;
        while (array[currentIndex / 2] != null && e.compareTo(array[currentIndex / 2]) < 0) {
            array[currentIndex] = array[currentIndex / 2];
            currentIndex = currentIndex / 2;
        }
        array[currentIndex] = e;
    }

    public E findMin() {
        if (currentSize == 0) {
            return null;
        }
        return array[1];
    }

    public E deleteMin() {
        if (!isEmpty()) {
            E e = findMin();
            array[1] = array[currentSize--];
            int i = 1;
            while ((2 * i < currentSize) && (array[i].compareTo(array[2 * i]) > 0
                    || array[i].compareTo(array[2 * i + 1]) > 0)) {

                if (array[2 * i].compareTo(array[2 * i + 1]) > 0) {
                    array[i] = array[2 * i + 1];
                    i = 2 * i + 1;
                    array[i] = array[currentSize + 1];
                } else {
                    array[i] = array[2 * i];
                    i = 2 * i;
                    array[i] = array[currentSize + 1];
                }
            }
            return e;
        } else {
            return null;
        }
    }


    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        array = ((E[]) new Comparable[DEFAULT_CAPACITY]);
        currentSize = 0;
    }

    public void ensureLargeArray(int length) {
        E[] oldArray = array;
        array = ((E[]) new Comparable[length]);
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }

    public <T extends Number> T addNumber(T x, T y) {
        if (x != null && y != null) {
            if (x instanceof Double) {
                return ((T) new Double(x.doubleValue() + y.doubleValue()));
            } else if (x instanceof Integer) {
                return ((T) new Integer(x.intValue() + y.intValue()));
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>();
        binaryHeap.insert(13);
        binaryHeap.insert(14);
        binaryHeap.deleteMin();
        for (int i = 1; i <= binaryHeap.currentSize; i++) {
            System.out.println(binaryHeap.array[i].toString());
        }
//        BinaryHeap<Double> binaryHeap1 = new BinaryHeap<>();
//        binaryHeap1.insert(1.2);
//        binaryHeap1.insert(2d);
//        for (int i = 1; i <= binaryHeap1.currentSize; i++) {
//            System.out.println(binaryHeap1.array[i].toString());
//        }
    }
}
