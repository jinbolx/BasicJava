package leetcode;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
//        int minLength = strs[0].length();
//        for (int i = 1; i < strs.length; i++) {
//            if (minLength > strs[i].length()) {
//                minLength = strs[i].length();
//            }
//        }

      //  String prefix=strs[0].substring(0,minLength);
        String prefix=strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strings = {"flower", "fl", "flight"};
        System.out.println("longestCommonPrefix: " + longestCommonPrefix(strings));
    }
}
