package dataStruct;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {

    private int size;
    private int modCount;
    private Node<E> beginMaker;
    private Node<E> endMaker;

    @Override
    public Iterator<E> iterator() {

        return new MyLinkedListIterator();
    }

    public MyLinkedList() {
        doClear();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(int index, E data) {
        addBefore(getNode(index, 0, size()), data);
    }

    public boolean add(E data) {
        add(size(), data);
        return true;
    }

    public boolean contains(E data) {
        for (E current : this) {
            if (data == current) {
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        return remove(getNode(index)).data;
    }

    public E set(int index, E data) {
        Node<E> node = getNode(index);
        E oldVal = node.data;
        node.data = data;
        return oldVal;
    }

    private static class Node<E> {

        private E data;
        private Node<E> pre;
        private Node<E> next;

        private Node(E data, Node<E> pre, Node<E> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    private void doClear() {
        beginMaker = new Node<>(null, null, null);
        endMaker = new Node<>(null, beginMaker, null);
        beginMaker.next = endMaker;
        size = 0;
        modCount++;
    }

    private void addBefore(Node<E> p, E data) {
        Node<E> current = new Node<>(data, p.pre, p);
        p.pre.next = current;
        p.pre = current;
        size++;
        modCount++;
    }

    private Node<E> remove(Node<E> p) {
        p.pre.next = p.next;
        p.next.pre = p.pre;
        size--;
        modCount++;
        return p;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    private Node<E> getNode(int index) {
        return getNode(index, 0, size() - 1);
    }

    private Node<E> getNode(int position, int lower, int higher) {
        Node<E> data;
        if (position < lower || position > higher) {
            throw new IndexOutOfBoundsException();
        }
        int center = size() / 2;
        if (center > position) {
            data = beginMaker.next;
            for (int i = 0; i < position; i++) {
                data = data.next;
            }
        } else {
            data = endMaker;
            for (int i = size(); i > position; i--) {
                data = data.pre;
            }
        }
        return data;
    }

    private class MyLinkedListIterator implements Iterator<E> {

        private Node<E> current = beginMaker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMaker;
        }

        @Override
        public E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            okToRemove = true;
            return data;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            expectedModCount++;
            MyLinkedList.this.remove(current.pre);
            okToRemove = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName()).append("[");
        for (E data : this) {
            stringBuilder.append(data).append(",");
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        stringBuilder.substring(0, stringBuilder.toString().length() - 10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
