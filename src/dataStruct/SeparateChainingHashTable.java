package dataStruct;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<E> {

    private static final int DEFAULT_TABLE_SIZE = 101;
    private int currentSize;
    private List<E>[] lists;

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        lists = new LinkedList[DEFAULT_TABLE_SIZE];
        lists = ((LinkedList<E>[]) new Object[DEFAULT_TABLE_SIZE]);
        for (int i = 0; i < DEFAULT_TABLE_SIZE; i++) {
            lists[i] = new LinkedList<>();
        }
    }

//    public SeparateChainingHashTable(Class<E> eClass, int size) {
//        lists = ((LinkedList<E>[]) Array.newInstance(eClass, size));
//    }

    public void insert(E e) {
        List<E> list = lists[myHash(e)];
        if (!list.contains(e)) {
            list.add(e);
            // TODO: 2019/3/11
            if (++currentSize > lists.length) {
                reHash();
            }
        }
    }

    public void remove(E e) {
        List<E> list = lists[myHash(e)];
//        if (list.contains(e)) {
//            list.remove(e);
//            currentSize--;
//        }
        if (list.remove(e)) {
            currentSize--;
        }
    }

    public boolean contains(E e) {
        List<E> list = lists[myHash(e)];
        return list.contains(e);
    }

    public void makeEmpty() {
        for (List<E> list : lists) {
            list.clear();
        }
        currentSize = 0;
    }

    private void reHash() {
        List<E>[] oldLists = lists;
        lists= (LinkedList<E>[]) new Object[2*lists.length];
        currentSize=0;
        for (List<E> oldList : oldLists) {
            for (E e : oldList) {
                insert(e);
            }
        }
    }

    private int myHash(E e) {
        int hashVal = e.hashCode();
        hashVal %= lists.length;
        return hashVal;
    }

    public static class Employee {

        private String name;
        private int age;

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Employee && name.equals(((Employee) obj).name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
