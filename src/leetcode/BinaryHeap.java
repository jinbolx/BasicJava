package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BinaryHeap<E extends Comparable<? super E>> {

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private E[] array;
    Class<E> type;

    public BinaryHeap(Class<E> type) {
        this(type, DEFAULT_CAPACITY);
    }

    public BinaryHeap(Class<E> type, int size) {
        this((E[]) Array.newInstance(type, size), type);
    }

    public BinaryHeap(E[] array, Class<E> type) {
        this.type = type;
        this.array = array;
        currentSize = 0;
    }

    public void insert(E e) {
        if (currentSize == array.length - 1) {
            ensureLargeArray(type, 2 * array.length + 1);
        }
        int currentIndex = ++currentSize;
        while (array[currentIndex / 2] != null && e.compareTo(array[currentIndex / 2]) < 0) {
            array[currentIndex] = array[currentIndex / 2];
            currentIndex = currentIndex / 2;
        }
        array[currentIndex] = e;
    }

    public static <T> T[] createArray(Class<T> type, int length) {
        return (T[]) Array.newInstance(type, length);
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

    public void ensureLargeArray(Class<E> type, int length) {
        E[] oldArray = array;
        array = ((E[]) Array.newInstance(type, length));
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
//        BinaryHeap<Integer> binaryHeap=new BinaryHeap<>(Integer.class);
//        binaryHeap.insert(13);
//        binaryHeap.insert(14);
//        binaryHeap.insert(16);
//        binaryHeap.insert(24);
//        binaryHeap.insert(21);
//        binaryHeap.insert(19);
//        binaryHeap.insert(68);
//        binaryHeap.insert(65);
//        binaryHeap.insert(26);
//        binaryHeap.insert(32);
//        binaryHeap.insert(31);
//        binaryHeap.deleteMin();
//        for (int i = 1; i <= binaryHeap.currentSize; i++) {
//            System.out.println(binaryHeap.array[i].toString());
//        }
//        BinaryHeap<Double> binaryHeap1=new BinaryHeap<>(Double.class);
//        binaryHeap1.insert(1.2);
//        binaryHeap1.insert(2d);
//        for (int i = 1; i <=binaryHeap1.currentSize ; i++) {
//            System.out.println(binaryHeap1.array[i].toString());
//        }
//        int min=Integer.MAX_VALUE;
//        int max=0;
//        int num=1;
//        do {
//            if (num>max){
//                min=max;
//                max=num;
//            }
//            if (min>num){
//                min=num;
//            }
//            System.out.println(System.currentTimeMillis());
//            break;
//        }while (num!=0);
        Scanner scanner = new Scanner(System.in);
        int[] array = {-1, -2, -3, -4, -5, 0, 10};
        int index = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int num;
        do {
            num = array[index];
            if (num != 0) {
                max = Math.max(num, max);
            }
            if (num != 0) {
                min = Math.min(min, num);
            }
            index++;
        } while (num != 0 && index != array.length);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        int[] a = {6, 1, 1, 13, -1, 0, -10, 20};
        canThreePartsEqualSum(a);
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(repeatedSubstringPattern("abaab"));
        int arr[] = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0,
                1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        System.out.println(prefixesDivBy5(arr));
        convertToBinary(11);
        //  baseNeg2(65);
    }

    public void printMaxAndMin(int[] array) {

    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) {
            return 0;
        }
        char[] chars = S.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for (char aChar : chars) {
            if (!set.add(aChar)) {
                count++;
            } else {
                set.remove(aChar);
            }
        }
        return count;
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i1 : A) {
            sum += i1;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int subSum = sum / 3;
        int firstPartSum = 0;
        int count = 0;
        for (int i1 : A) {
            firstPartSum += i1;
            if (firstPartSum == subSum) {
                firstPartSum = 0;
                count++;
            }
        }
        return count == 3;
    }

    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        return -1;
    }

    public int maxScoreSightseeingPair(int[] A) {
        int sum = A[0];
        int index = 0;
        for (int i = 1; i < A.length; i++) {
            sum = Math.max(sum, A[index] + index + A[i] - i);
            if (A[index] + index < A[i] + i) {
                index = i;
            }
        }
        return sum;
    }

    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            if (!S.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {

            }
        }
        return 0;
    }

    public int rob(int[] nums) {
        int total = 0;
        if (nums.length == 0) {
            return total;
        }
        return 0;
    }

    public ListNode addTwoNumbers(leetcode.AddLinkList.ListNode l1,
            leetcode.AddLinkList.ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cal = listNode;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.x;
            int y = l2 == null ? 0 : l2.x;
            cal.next = new ListNode((x + y + sum) % 10);
            cal = cal.next;
            sum = (x + y + sum) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (sum > 0) {
            cal.next = new ListNode(sum);
        }
        listNode = listNode.next;
        return listNode;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return new int[]{i, map.get(rem)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxSubLength = 0;
        if (s == null || s.length() == 0) {
            return maxSubLength;
        }
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxSubLength = Math.max(maxSubLength, i - j + 1);
        }
        return maxSubLength;
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return false;
        }
        int leftIndex = 1;
        int rightIndex = s.length() - 1;
        String leftString = "";
        boolean exist = false;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length() && leftIndex < rightIndex + 1; i++) {
            leftString = s.substring(0, leftIndex);
            String rightString = s.substring(rightIndex);
            if (leftString.equals(rightString)) {
                exist = true;
                list.add(leftIndex);
            }
            leftIndex++;
            rightIndex--;

        }
        if (exist) {
            for (Integer integer : list) {
                String subString = s.substring(0, integer);
                if (s.replace(subString, "").trim().length() == 0) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }

    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int sum = 0;
        for (int value : A) {
            sum = sum * 2 + value;
            sum %= 5;
            list.add(sum == 0);
        }
        return list;
    }

    public static String baseNeg2(int N) {
        List<Integer> list = new ArrayList<>();
        getPosition(N, list);
        StringBuilder builder = new StringBuilder();
        for (Integer in : list) {
            builder.append(in);
        }
        return builder.toString();
    }

    public static void getPosition(int x, List<Integer> list) {
        if (x == 0) {
            list.add(0);
        } else if (x == 1) {
            list.add(1);
        } else {
            int time = 1;
            while (time < x) {
                if (time < 4) {
                    time = 4 * x;
                }
            }
            if (time - x < x - time / 4) {
                list.add(1);
                getPosition(x - time / 4, list);
            } else {
                list.add(1);
                list.add(1);
                getPosition(time - x, list);
            }

        }
    }

    public static void convertToBinary(int N) {
        System.out.println(Integer.toBinaryString(N));
        List<Integer> list = new ArrayList<>();
        while (N / 2 != 0) {
            list.add(N % 2);
            N = N / 2;
        }
        list.add(N);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i));
        }
        System.out.println(stringBuilder.toString());
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    arr[i] = list.get(j);
                    break;
                }
            }
        }
        return arr;
    }



}
