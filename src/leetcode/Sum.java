package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class Sum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                hashMap.put(nums[i], i);
            }
        }
        for (Integer integer :
                hashMap.keySet()) {
            if (hashMap.get(target - integer) != null) {
                return new int[]{hashMap.get(integer), hashMap.get(target - integer)};
            }

        }
        return new int[0];
    }


    public static int[] twoSum1(int[] nums, int target) {
        int size = 2048;
        int[] map = new int[size];
        int length = 2047;
        int index;
        int a = 2047 & -4;
        for (int i = 0; i < nums.length; i++) {
            index = nums[i] & length;
            if (map[index] != 0) {
                return new int[]{map[index] - 1, i};
            } else {
                map[(target - index) & length] = i + 1;
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumPlus(int[] nums, int target) {
        int[] map = new int[2048];
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (map[index] != 0) {
                return new int[]{map[index] - 1, i};
            } else {
                map[target - index] = i + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int[] twoSumCommon(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println("twoSum: " + Arrays.toString(twoSum1(new int[]{0, 4, 3, 0}, 0)));
        //  System.out.println("twoSum: " + Arrays.toString(twoSumCommon(new int[]{3, 2,4}, 6)));
        System.out.println(findTheDifference("a", "aa"));
//        RecentCounter recentCounter = new RecentCounter();
//        System.out.println(recentCounter.ping(1));
//        System.out.println(recentCounter.ping(100));
//        System.out.println(recentCounter.ping(3001));
//        System.out.println(recentCounter.ping(3002));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> returnLists = new ArrayList<>();
        if (nums.length < 3) {
            return returnLists;
        } else {
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = i + 1; k < j + 1; k++) {
                        if (nums[i] + nums[j] + nums[k] == target) {
                            List<Integer> validList = new ArrayList<>();
                            returnLists.add(validList);
                        }
                    }
                }
            }
            return returnLists;
        }
    }

    public static char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        int sum1 = 0;
        int sum2 = 0;
        for (char aChar : chars) {
            sum1 += aChar;
        }
        for (char c : chars1) {
            sum2 += c;
        }
        return (char) (sum2 - sum1);
    }

    static class RecentCounter {

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue != null && queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

    //    static class MyCircularDeque {
//
//        private int[] array;
//        private int startIndex;
//        private int endIndex;
//        private int currentSize;
//        private int length;
////
//
//        /**
//         * Initialize your data structure here. Set the size of the deque to be k.
//         */
//        public MyCircularDeque(int k) {
//            array = new int[k];
//            startIndex = k;
//            endIndex = k;
//            currentSize = 0;
//            length = k;
//        }
//
//        /**
//         * Adds an item at the front of Deque. Return true if the operation is successful.
//         */
//        public boolean insertFront(int value) {
//            if (!isFull()) {
//                int currentStart = --startIndex;
//                if (currentStart == -1) {
//                    startIndex = startIndex + length;
//                    array[startIndex] = value;
//                } else {
//                    array[currentStart] = value;
//                }
//                currentSize++;
//                return true;
//            }
//            return false;
//        }
//
//        /**
//         * Adds an item at the rear of Deque. Return true if the operation is successful.
//         */
//        public boolean insertLast(int value) {
//            if (!isFull()) {
//                if (endIndex == length) {
//                    endIndex = 0;
//                    array[endIndex] = value;
//                } else {
//                    int currentEnd = ++endIndex;
//                    if (currentEnd == length) {
//                        endIndex = 0;
//                        array[endIndex] = value;
//                    } else {
//                        array[currentEnd] = value;
//                    }
//
//                }
//                currentSize++;
//                return true;
//            }
//            return false;
//        }
//
//        /**
//         * Deletes an item from the front of Deque. Return true if the operation is successful.
//         */
//        public boolean deleteFront() {
//            if (!isEmpty()) {
//                if (++startIndex == length) {
//                    startIndex = 0;
//                }
//                currentSize--;
//                return true;
//            }
//
//            return false;
//        }
//
//        /**
//         * Deletes an item from the rear of Deque. Return true if the operation is successful.
//         */
//        public boolean deleteLast() {
//            if (!isEmpty()) {
//                if (--endIndex == -1) {
//                    endIndex = length - 1;
//                }
//                currentSize--;
//                return true;
//            }
//            return false;
//        }
//
//        /**
//         * Get the front item from the deque.
//         */
//        public int getFront() {
//            if (!isEmpty()) {
//                return array[startIndex];
//            }
//            return -1;
//        }
//
//        /**
//         * Get the last item from the deque.
//         */
//        public int getRear() {
//            if (!isEmpty()) {
//                return array[endIndex];
//            }
//            return -1;
//        }
//
//        /**
//         * Checks whether the circular deque is empty or not.
//         */
//        public boolean isEmpty() {
//            return currentSize == 0;
//        }
//
//        /**
//         * Checks whether the circular deque is full or not.
//         */
//        public boolean isFull() {
//            return currentSize == length;
//        }
//
////        public MyCircularDeque(int x) {
////            startMarker = new Node<Integer>(null, null, null);
////            endMarker = new Node<Integer>(null, startMarker, startMarker);
////            startMarker.pre = endMarker;
////            startMarker.next = endMarker;
////        }
////
////        Node startMarker;
////        Node endMarker;
////        int currentSize;
////
////        class Node<E> {
////
////            E val;
////            Node pre;
////            Node next;
////
////            public Node(E val, Node pre, Node next) {
////                this.val = val;
////                this.pre = pre;
////                this.next = next;
////            }
////
////        }
//    }
}
