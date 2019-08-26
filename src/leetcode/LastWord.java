package leetcode;

public class LastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(s.length() - 1) == ' ') {
            s = s.trim();
        }
        char[] chars = s.toCharArray();
        int startIndex = 0;
        int endIndex = 0;
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            endIndex++;
            if (chars[i] == ' ') {
                length = endIndex - startIndex;
                startIndex = endIndex;
            }
            if (i == chars.length - 1) {
                length = endIndex - startIndex;
            }
        }
        return length;
    }

    public static int lengthOfLastWordReverse(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.trim().toCharArray();

        int startIndex = chars.length - 1;
        int endIndex = chars.length - 1;
        int length = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                length = endIndex - startIndex;
                break;
            }else if (i==0){
                length=chars.length;
                break;
            }
            startIndex--;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println("lastWordLength: " + lengthOfLastWord(" hello world me"));
        System.out.println("lastWordLengthReverse: " + lengthOfLastWordReverse("a"));
    }
}
