package leetcode;

import java.util.Stack;

public class StringValid {

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0){
            return false;
        }
        char[] chars = s.toCharArray();
        int[] array = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    array[i] = 1;
                    break;
                case ')':
                    array[i] = 4;
                    break;
                case '{':
                    array[i] = 2;
                    break;
                case '}':
                    array[i] = 5;
                    break;
                case '[':
                    array[i] = 3;
                    break;
                case ']':
                    array[i] = 6;
                    break;
            }
        }
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < array.length ; i++) {
           if (array[i]<4){
               stack.push(array[i]);
           }else if (stack.isEmpty()&&array[i]>=4){
               return false;
           }else if (array[i]-stack.peek()==3){
               stack.pop();
           }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("isValid: " + isValid("))"));
    }
}
