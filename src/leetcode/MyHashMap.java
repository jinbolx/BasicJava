package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

    private List<Integer> list;

    public MyHashMap() {
       list=new ArrayList<>();

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        list.set(key,value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public int get(int key) {
       return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {

    }
}
