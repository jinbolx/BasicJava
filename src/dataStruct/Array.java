package dataStruct;

public class Array {

    private Object[] intArray;
    private int arrayLength;
    private int elementIndex;

    public Array(int size) {
        intArray = new Object[size];
        arrayLength = size;
        elementIndex = 0;
    }

    public void add(Object o) {
        if (elementIndex == arrayLength) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        intArray[elementIndex] = o;
        elementIndex++;
    }

    public Object findIndex(int i) {
        if (i < arrayLength) {
            return intArray[i];
        } else {
            throw new IndexOutOfBoundsException("数据越界");
        }
    }

    public int findValueIndex(Object o) {
        int i;
        for (i = 0; i < elementIndex; i++) {
            if (intArray[i] == o) {
                break;
            }
        }
        if (i == elementIndex) {
            return -1;
        }
        return i;
    }

    public boolean deleteValue(Object o) {
        int i = findValueIndex(o);
        if (i == -1) {
            return false;
        }
        for (int j = i; j < elementIndex - 1; j++) {
            intArray[j] = intArray[j + 1];
        }
        elementIndex--;
        return true;
    }

    public boolean update(Object oldValue, Object newValue) {
        int i = findValueIndex(oldValue);
        if (i == -1) {
            return false;
        }
        intArray[i] = newValue;
        return true;
    }

}
