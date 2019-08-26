package leetcode;

public class StringExit {

    public static int strStr(String haystack, String needle) {
        if (haystack == null
                || needle == null
                || haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == 0 || needle.length() == 0) {
            return 0;
        }
        char[] hayChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.length() - i >= needle.length()) {
                    int currentIndexOut = i + 1;
                    int increase = 0;
                    for (int j = 1; j < needle.length(); j++) {
                        if (needleChars[j] == hayChars[currentIndexOut]) {
                            increase++;
                            currentIndexOut++;
                        } else if (increase == needle.length() - 1) {
                            return i;
                        }
                    }
                    if (currentIndexOut - i == needle.length()) {
                        return i;
                    }
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static int strUseSolution(String haystack, String needle) {
        if (haystack == null
                || needle == null
                || haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == 0 || needle.length() == 0) {
            return 0;
        }
        char[] hayChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int offset = hayChars.length - needleChars.length;
        for (int i = 0; i <= offset; i++) {
            for (int j = 0; j < needleChars.length; j++) {
                if (hayChars[i + j] != needleChars[j]) {
                    break;
                }
                if (j == needleChars.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //System.out.println("index: " + strStr("aabaaabaaac", "aabaaac"));
        System.out.println("officialSolution: " + strUseSolution("aabaaabaaac", "aabaaac"));
    }
}
