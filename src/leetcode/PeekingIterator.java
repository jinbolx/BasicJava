package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> integerIterator;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        integerIterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (next == null && hasNext()) {
            next = integerIterator.next();
            return next;
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (next == null && hasNext()) {
            return integerIterator.next();
        } else if (next != null) {
            int value = next;
            next = null;
            return value;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return next != null || integerIterator.hasNext();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
        peekingIterator.next();
        peekingIterator.peek();
        peekingIterator.next();
        peekingIterator.next();
        peekingIterator.hasNext();
    }
}
