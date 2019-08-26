package leetcode;

import java.util.Stack;

public class MaxWidth {

    public static int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < A.length - 1; i++) {
            int width = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] <= A[j]) {
                    width = j - i;
                }
            }
            if (stack.peek() < width) {
                stack.pop();
                stack.push(width);
            }
        }
        return stack.peek();
    }

    public static int maxWidthRamp1(int[] A) {
        int maxWidth = 0;
        int currentWidth = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] <= A[j]) {
                    currentWidth = j - i;
                }
            }
            if (currentWidth > maxWidth) {
                maxWidth = currentWidth;
            }
        }
        return maxWidth;
    }


    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println("maxWidth: " + maxWidthRamp(array));
    }
}
