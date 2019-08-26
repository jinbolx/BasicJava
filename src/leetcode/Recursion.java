package leetcode;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    }

    public static int kthGrammar(int N, int K) {
        return 0;
    }

    public static String getString(int N) {

        String s = "";
        if (N == 0) {
            s = "0";
        } else if (N == 1) {
            s = "01";
        } else {
            s = getString(N - 1).replace("0", "01");
        }
        return s;
    }

    public static String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        char[] chars = S.toCharArray();
        int startIndex=0;
        int endIndex=chars.length-1;
        while (startIndex<endIndex){
            while (startIndex<endIndex&&!isLetter(chars[startIndex])){
                startIndex++;
            }
            while (startIndex<endIndex&&!isLetter(chars[endIndex])){
                endIndex--;
            }
            char ch=chars[startIndex];
            chars[startIndex]=chars[endIndex];
            chars[endIndex]=ch;
            startIndex++;
            endIndex--;
        }
//        char[] s = S.toCharArray();
//        int i = 0;
//        int j = s.length-1;
//
//        while(i<j) {
//            while(i<j&&!isLetter(s[i])) {
//                i++;
//            }
//            while(i<j&&!isLetter(s[j])) {
//                j--;
//            }
//            char ch = s[i];
//            s[i] = s[j];
//            s[j] = ch;
//            i++;
//            j--;
//        }
        return new String(chars);
    }
    public static boolean isLetter(char c){
        return (c>='A'&&c<='Z')||(c>='a'&&c<='z');
    }
}
