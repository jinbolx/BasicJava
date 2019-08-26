package contest;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Contest3 {

    public static void main(String[] args) {
        Contest3 contest3 = new Contest3();
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(contest3.isSubsequence(s, t));
        int[] array = {228, 189, 160, 229, 165, 189, 13, 10};
        System.out.println(contest3.validUtf8(array));
        System.out.println(contest3.decodeString("abccdef"));
    }

    //1
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int cur = -1;
        for (int i = 0; i < s.length(); i++) {
            cur = t.indexOf(s.charAt(i), cur + 1);
            if (cur == -1) {
                return false;
            }
        }
        return true;
    }

    //2错误
    public boolean validUtf8(int[] data) {
        if (data.length == 0) {
            return false;
        }
        return validSubArray(0, data);
    }

    public boolean validSubArray(int cur, int[] data) {

        if (cur > data.length - 1) {
            return true;
        }

        String binaryString = Integer.toBinaryString(data[cur]);
        if (data.length == 1 || cur == data.length - 1) {
            if (binaryString.length() < 8) {
                return true;
            } else {
                return binaryString.startsWith("0");
            }
        }

        if (binaryString.length() < 8) {
            return validSubArray(cur + 1, data);
        } else {

            int count = 0;
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') {
                    count++;
                } else {
                    break;
                }
            }
            if (count > data.length) {
                return false;
            }
            if (count > 4) {
                return false;
            }
            for (int i = cur + 1; i < cur + count; i++) {
                String toBinaryString = Integer.toBinaryString(data[i]);
                if (toBinaryString.length() < 8) {
                    return false;
                }
                if (!toBinaryString.startsWith("10")) {
                    return false;
                }
            }
            return validSubArray(cur + count, data);
        }

    }

    //3
    public String decodeString(String s) {
        Stack<Integer> integers = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        stringStack.push(new StringBuilder());
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = 10 * num + (s.charAt(i) - '0');
            } else {
                if (s.charAt(i) == '[') {
                    integers.push(num);
                    stringStack.push(new StringBuilder());
                    num = 0;
                } else if (s.charAt(i) == ']') {
                    int repeat = integers.pop();
                    StringBuilder subStringBuilder = stringStack.pop();
                    for (int j = 0; j < repeat; j++) {
                        stringStack.peek().append(subStringBuilder);
                    }
                } else {
                    stringStack.peek().append(s.charAt(i));
                }
            }
        }
        return stringStack.pop().toString();
    }

    //4
    public int longestSubstring(String s, int k) {
        if (s.length() < k || s.length() == 0) {
            return 0;
        }
        char ch = 0;
        int repeatTimes = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                ch = s.charAt(i);
            } else {
                if (s.charAt(i) == ch) {
                    repeatTimes++;
                }else {
                    repeatTimes=1;
                }
                if (repeatTimes >= k) {
                    set.add(ch);
                }
                ch = s.charAt(i);
            }
        }
        return 0;
    }
}
