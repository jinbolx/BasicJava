package contest;

public class Contest7 {

    public static void main(String[] args) {
        Contest7 contest7 = new Contest7();
        System.out.println(contest7.longestPalindrome("civilwartestingwhet"));
    }

    public int longestPalindrome(String s) {
//        if (s.length() == 0) {
//            return 0;
//        }
//        char[] chars=s.toCharArray();
//        int[] lowerCase=new int[26];
//        int[] upperCase=new int[26];
//        Map<Character,Integer> map=new HashMap<>();
//        for (char aChar : chars) {
//            if (map.containsKey(aChar)){
//                map.put(aChar,map.get(aChar)+1);
//            }else {
//                map.put(aChar,1);
//            }
//            if (aChar <= 'z' && aChar >= 'a') {
//                lowerCase[aChar - 'a']++;
//            }
//            if (aChar <= 'Z' && aChar >= 'A') {
//                upperCase[aChar - 'A']++;
//            }
//        }
//        int oldChar=0;
//        int count=0;
//        for (int i = 0; i < lowerCase.length; i++) {
//            if (lowerCase[i]%2==0){
//                count+=lowerCase[i];
//            }else {
//                oldChar=Math.max(oldChar,lowerCase[i]);
//            }
//            if (upperCase[i]%2==0){
//                count+=upperCase[i];
//            }else {
//                oldChar=Math.max(oldChar,upperCase[i]);
//            }
//        }
//        return count+oldChar;
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= 97) {
                lowercase[temp - 'a']++;
            } else {
                uppercase[temp - 'A']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            res += (lowercase[i] / 2) * 2;
            res += (uppercase[i] / 2) * 2;
        }
        return res == s.length() ? res : res + 1;
    }

    public String originalDigits(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        return "";
    }

    public int getDigit(String word) {
        int digit = -1;
        switch (word) {
            case "zero":
                digit = 0;
                break;
            case "one":
                digit = 1;
                break;
            case "two":
                digit = 2;
                break;
            case "three":
                digit = 3;
                break;
            case "four":
                digit = 4;
                break;
            case "five":
                digit = 5;
                break;
            case "six":
                digit = 6;
                break;
            case "seven":
                digit = 7;
                break;
            case "eight":
                digit = 8;
                break;
            case "nine":
                digit = 9;
                break;
        }
        return digit;
    }
}
