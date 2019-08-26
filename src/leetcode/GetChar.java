package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GetChar {

    public static void main(String[] args) {
        String[] strings = {"bella", "label", "roller"};
        commonChars(strings);
        int[] array = {69, 39, 79, 78, 16, 6, 36, 97, 79, 27, 14, 31, 4};
        int K = 2;
        System.out.println(mergeStones(array, K));
        String s = "abcabcbb";
        lengthOfLongestSubstring(s);
    }

    public static List<String> commonChars(String[] A) {
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < A[0].length(); i++) {
            tempList.add(String.valueOf(A[0].charAt(i)));
        }
        if (A.length == 1) {
            return tempList;
        } else {
            for (int i = 1; i < A.length; i++) {
                List<String> stringList = new ArrayList<>();
                for (int j = 0; j < A[i].length(); j++) {
                    stringList.add(String.valueOf(A[i].charAt(j)));
                }
                for (int j = 0; j < tempList.size(); j++) {
                    boolean isExit = false;
                    for (int k = 0; k < stringList.size(); k++) {
                        if (tempList.get(j).equals(stringList.get(k))) {
                            isExit = true;
                            stringList.remove(k);
                            break;
                        }
                    }
                    if (!isExit) {
                        tempList.remove(j);
                        j--;
                    }
                }
            }
        }
        return tempList;
    }

    public static int mergeStones(int[] stones, int K) {
        if (stones.length == 1) {
            return 0;
        }
        int remainder = stones.length;
        while (remainder > K) {
            remainder = remainder - (K - 1);
        }
        if (remainder % K == 0) {
            List<Integer> list = new ArrayList<>();
            for (int stone : stones) {
                list.add(stone);
            }
            int total = 0;
            while (list.size() >= K) {
                int minCount = 0;
                int minStartIndex = 0;
                for (int i = 0; i < K; i++) {
                    minCount += list.get(i);
                }
                for (int i = 1; i <= list.size() - K; i++) {
                    int tempCount = 0;
                    for (int j = i; j < i + K; j++) {
                        tempCount += list.get(j);
                    }
                    if (minCount >= tempCount) {
                        minCount = tempCount;
                        minStartIndex = i;
                    }
                }
                total += minCount;
                list.set(minStartIndex, minCount);
                for (int i = K - 1; i >= 1; i--) {
                    list.remove(minStartIndex + i);
                }
            }

            return total;
        } else {
            return -1;
        }
    }

    public boolean isValid(String S) {
        while (S.contains("abc")) {
            S = S.replace("abc", "");
        }
        return S.length() == 0;
    }

    public int longestOnes(int[] A, int K) {
        return -1;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxCount = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    break;
                }
            }
            maxCount = Math.max(maxCount, set.size());
        }
        return maxCount;
    }

}
