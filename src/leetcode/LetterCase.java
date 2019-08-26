package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LetterCase {

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity1(array)));
    }

    public static int[] sortArrayByParity(int[] A) {
        if (A.length == 0) {
            return A;
        }
        Stack<Integer> evenStack = new Stack<>();
        Stack<Integer> oddStack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evenStack.push(A[i]);
            } else {
                oddStack.push(A[i]);
            }
        }
        for (int i = 0; i < evenStack.size(); i++) {
            A[i] = evenStack.get(i);
        }
        for (int i = 0; i < oddStack.size(); i++) {
            A[i + evenStack.size()] = oddStack.get(i);
        }
        return A;
    }

    public static int[] sortArrayByParity1(int[] A) {
        if (A.length == 0) {
            return A;
        }
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                if (A[index] % 2 != 0) {
                    int temp = A[index];
                    A[index] = A[i];
                    A[i] = temp;
                }
                index++;
            }
        }
        return A;
    }

    public static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }
    public static int fib1(int N) {
        int i_2=0;
        int i_1=1;
        int i_=0;
        if (N==0)
            return 0;
        if (N==1)
            return 1;
        for (int i = 2; i <= N; i++) {
            i_=i_1+i_2;
            i_2=i_1;
            i_1=i_;
        }
        return i_;
    }
}
