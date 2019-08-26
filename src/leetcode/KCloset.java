package leetcode;

import java.util.Arrays;

public class KCloset {
//    public int[][] kClosest(int[][] points, int K) {
//        int[] array=new int[points.length];
//        for (int i = 0; i < points.length; i++) {
//            int currentLength=0;
//            for (int j = 0; j < points[i].length; j++) {
//                currentLength+=points[i][j]*points[i][j];
//            }
//        }
//
//    }

    public static void main(String[] args) {
        int[]A={2,1,2};
        System.out.println("max: "+largestPerimeter(A));
    }

    public static int largestPerimeter(int[] A) {

        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i-2] + A[i-1] > A[i]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }


}
