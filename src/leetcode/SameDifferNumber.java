package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SameDifferNumber {

    public static void main(String[] args) {
        System.out.println(shortestToChar( "loveleetcode",'e'));
    }
    public static int[] shortestToChar(String S, char C) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (C == (S.charAt(i))) {
                list.add(i);
            }
        }
        int[] shortArray = new int[S.length()];
        for (int j = 0; j <S.length(); j++) {
            int distance = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if (Math.abs(j - list.get(i)) < distance) {
                    distance = Math.abs(j - list.get(i));
                }
            }
            shortArray[j] = distance;
        }
        return shortArray;
    }

}
