package dataStruct;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int thisSize;
    private E[] thisItems;


    public void ensureCapacity(int newCapacity) {
        if (newCapacity < thisSize) {
            return;
        }
        E[] oldItems = thisItems;
        thisItems = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            thisItems[i]=oldItems[i];
        }
    }

    public void doClear() {
        thisSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public MyArrayList() {
        doClear();
    }

    public int size() {
        return thisSize;
    }

    public boolean isEmpty() {
        return thisSize == 0;
    }

    public void add(int index, E e) {
        if (thisItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = size(); i > index; i++) {
            thisItems[i] = thisItems[i - 1];
        }
        thisItems[index] = e;
        thisSize++;
    }

    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    public E remove(int index) {
        E e = thisItems[index];
        if (size() - 1 - index >= 0) {
            System.arraycopy(thisItems, index + 1, thisItems, index, size() - 1 - index);
        }
        thisSize--;
        return e;
    }

    public void trimToSize() {
        ensureCapacity(thisSize);
    }

    public boolean remove(Object e) {
        if (e == null) {
            for (int i = 0; i < size(); i++) {
                if (thisItems[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (thisItems[i] == e) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public E set(int index, E newVal) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        E oldVal = thisItems[index];
        thisItems[index] = newVal;
        return oldVal;
    }

    public E get(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        return thisItems[index];
    }

    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<E> {

        int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return thisItems[current++];
            }

        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName()).append("[");
        for (int i = 0; i < size(); i++) {
            stringBuilder.append(thisItems[i]).append(",");
        }
        stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length(),"");
        stringBuilder.substring(0,stringBuilder.toString().length()-10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
