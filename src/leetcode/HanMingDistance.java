package leetcode;

public class HanMingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        String stringX = Integer.toBinaryString(x);
        String stringY = Integer.toBinaryString(y);
        int diff = stringX.length() - stringY.length();
        StringBuilder stringBuilder = new StringBuilder();
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                stringBuilder.append("0");
            }
            stringY = stringBuilder.toString() + stringY;
        } else if (diff < 0) {
            for (int i = 0; i < -diff; i++) {
                stringBuilder.append("0");
            }
            stringX = stringBuilder.toString() + stringX;
        }
        int count = 0;
        for (int i = 0; i < stringX.length(); i++) {
            if (stringX.charAt(i) != stringY.charAt(i)) {
                count++;
            }
        }
        return count;
    }
//    输入: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
//
//    解释:
//
//            master.guess("aaaaaa") 返回 -1, 因为 "aaaaaa" 不在 wordlist 中.
//            master.guess("acckzz") 返回 6, 因为 "acckzz" 就是秘密，6个字母完全匹配。
//            master.guess("ccbazz") 返回 3, 因为 "ccbazz" 有 3 个匹配项。
//            master.guess("eiowzz") 返回 2, 因为 "eiowzz" 有 2 个匹配项。
//            master.guess("abcczz") 返回 4, 因为 "abcczz" 有 4 个匹配项。
//
//    我们调用了 5 次master.guess，其中一次猜到了秘密，所以我们通过了这个测试用例。

    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < wordlist.length; i++) {
            master.guess(wordlist[i]);
        }

    }
    class Master{
        public int guess(String word){
            return 0;
        }
    }
}
