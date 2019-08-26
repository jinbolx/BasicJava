package leetcode;

import java.util.List;

public class AlienSorted {

    public boolean isAlienSorted(String[] words, String order) {
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(toLowerCase("Hello"));
        // System.out.println(detectCapitalUse("FFFFFFf"));
        System.out.println(reverseString("a-bC-dEf-ghIj"));
    }

    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            int ascCode = str.charAt(i);
            if (ascCode >= 65 && ascCode <= 90) {
                int newCode = ascCode + 32;
                str = str.replace(str.charAt(i), (char) newCode);
            }
        }
        return str;
    }

    public static boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0 || word.length() == 1) {
            return true;
        }
        char[] chars = word.toCharArray();
        if (word.length() == 2) {
            return isUpperCase(chars[0]) || !isUpperCase(chars[1]);
        }
        for (int i = 2; i < chars.length; i++) {
            if (isUpperCase(chars[0]) && isUpperCase(chars[1])) {
                if (!isUpperCase(chars[i])) {
                    return false;
                }
            } else if (!isUpperCase(chars[1])) {
                if (isUpperCase(chars[i])) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isUpperCase(int ascCode) {
        return ascCode >= 65 && ascCode <= 90;
    }

    public boolean isLowerCase(int ascCode) {
        return ascCode >= 97 && ascCode <= 122;
    }

    public static String reverseString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        char[] chars = S.toCharArray();
        int endIndex=chars.length-1;
        for (int i = 0; i < chars.length; i++) {
            int ascCode = chars[i];
            int startIndex;
            if ((ascCode >= 97 && ascCode <= 122) || (ascCode >= 65 && ascCode <= 90)) {
               startIndex=i;
            }
            for (int j = endIndex; j>i; j--) {
                if ((ascCode >= 97 && ascCode <= 122) || (ascCode >= 65 && ascCode <= 90)) {
                    endIndex=j;
                    break;
                }
            }
//            char oldChar = chars[i];
//            chars[i] = chars[chars.length - 1 - i];
//            chars[chars.length - 1 - i] = oldChar;
        }

        return new String(chars);
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (words.length == 0 || pattern.length() == 0) {
            return null;
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == pattern.length()) {

            }
        }
        return null;
    }
}
