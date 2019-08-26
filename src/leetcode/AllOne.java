package leetcode;

import java.util.HashMap;
import java.util.Map;

public class AllOne {

    Map<String, Integer> map;


    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (null != map.get(key)) {
            int value = map.get(key);
            if (value == 1) {
                map.remove(key);
            } else {
                map.put(key, --value);
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return "";
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return "";
    }

    class Node implements Comparable {

        String key;
        int value;

        @Override
        public boolean equals(Object obj) {
            return this.key.equals(((Node) obj).key);
        }

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(value, ((Node) o).value);
        }
    }

//    class MyHashMap<K, Integer> extends HashMap<K, Integer> implements Comparable {
//
//        K key = null;
//        Integer value = null;
//
//        public MyHashMap() {
//
//        }
//
//        @Override
//        public Integer put(K key, Integer value) {
//            this.key = key;
//            this.value = value;
//            return super.put(key, value);
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            return this.key != null && this.key.equals(((MyHashMap) o).key);
//        }
//
//        @Override
//        public int compareTo(Object o) {
//            return java.lang.Integer.compare((int) value,
//                    ((MyHashMap<K, java.lang.Integer>) o).value);
//        }
//    }
}
