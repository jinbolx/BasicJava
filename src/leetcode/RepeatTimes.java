package leetcode;

import java.util.HashMap;

public class RepeatTimes {

    public static void main(String[] args) {
        int []array=new int[]{5,1,5,2,5,3,5,4};
        System.out.println("repeat: "+repeatedNTimes(array));
    }

    public static int repeatedNTimes(int[] A) {
        if (A.length == 0||A.length%2!=0) {
            return -1;
        }
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i <A.length; i++) {
            int current=A[i];
            if (hashMap.get(current)!=null){
                return current;
            }else {
                hashMap.put(current,1);
            }
        }
       return -1;
    }
}
