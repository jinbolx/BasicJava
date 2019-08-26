package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int[] position = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            Stack<Integer> stack = new Stack<>();
            int during = nums2.length - 1;
            stack.push(during);
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] > nums1[i] && nums2[j] - nums1[i] < nums2[stack.peek()] - nums1[i]) {
                    stack.pop();
                    stack.push(j);
                }
            }
            if (stack.peek() == during) {
                position[i] = -1;
            } else {
                position[i] = stack.peek();
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] array1 = {4, 1, 2};
        int[] array2 = {1, 3, 4, 2};
        // System.out.println(Arrays.toString(nextGreaterElement(array1, array2)));
        String s = "aaa";
        System.out.println(largeGroupPositions(s));
    }

    //    public static boolean isAlienSorted(String[] words, String order) {
//        if (order==null||order.length()==0){
//            return false;
//        }
//        HashMap<Character,Integer> map=new HashMap<>();
//        for (int i = 0; i < order.length(); i++) {
//            map.put(order.charAt(i),i);
//        }
//        for (int i = 0; i < words.length-1; i++) {
//
//        }
//
//    }
    public static int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        int startIndex = 0;
        int endIndex = 0;
        char[] array = S.toCharArray();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            int during = 0;
            List<Integer> subList = new ArrayList<>();
            if (array[i] == array[i + 1]) {

                if (i > 0 && array[i] != array[i - 1]) {
                    startIndex = i;
                }
                if (i == array.length - 2) {
                    during = i + 1 - startIndex;
                    if (during >= 2) {
                        subList.add(startIndex);
                        subList.add(i + 1);
                    }
                }
                endIndex = i + 1;
            } else {
                during = endIndex - startIndex;
                if (during >= 2) {
                    subList.add(startIndex);
                    subList.add(endIndex);
                }
                startIndex = endIndex;
            }
            if (subList.size() > 0) {
                lists.add(subList);
            }
        }
        return lists;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] greaterElements = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            Stack<Integer> stack = new Stack<>();
            int index = -1;
            for (int i = 0; i < nums2.length; i++) {
                if (nums1[j] == nums2[i]) {
                    index = i;
                    break;
                }
            }
            for (int i = index + 1; i < nums2.length; i++) {
                if (nums2[i] > nums1[j]) {
                    stack.push(nums2[i]);
                    break;
                }
            }
            if (stack.isEmpty()) {
                greaterElements[j] = -1;
            } else {
                greaterElements[j] = stack.pop();
            }
        }
        return greaterElements;
    }

}
