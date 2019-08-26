package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {

    public static void main(String[] args) {
        //System.out.println("climb: " + climbStairs(3));
        int[] array = {7, 1, 5, 3, 6, 4};
       // System.out.println("maxProfit: " + maxProfit(array));
        int[] array1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //System.out.println(maxSubArray(array1));
        //System.out.println(fizzBuzz(3));
       // System.out.println(isPowerOfThree(1162261466));
//        Scanner in = new Scanner(System.in);
//        List<Integer> integerList=new ArrayList<>();
//        while (in.hasNextInt()) {
//            int b = in.nextInt();
//            integerList.add(b);
//        }
        System.out.println(getMiniNumber(27,1,27));
    }

    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int nNum = 0;
        int nNum_1 = 2;
        int nNum_2 = 1;
        for (int i = 3; i <= n; i++) {
            nNum = nNum_1 + nNum_2;
            nNum_2 = nNum_1;
            nNum_1 = nNum;
        }
        return nNum;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        //   int currentProfit;
        int maxProfit = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = prices.length-1; j>i; j--) {
//                if (prices[j] > prices[i]) {
//                    currentProfit = prices[j] - prices[i];
//                    if (currentProfit > maxProfit) {
//                        maxProfit = currentProfit;
//                    }
//                }
//            }
//        }
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        return maxProfit;

    }

    public static int maxSubArray(int[] nums) {
        //-2, 1, -3, 4, -1, 2, 1, -5, 4
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int preTotal = nums[nums.length - 1];
        int maxTotal = 0;
        if (nums.length == 1) {
            return preTotal;
        }
        for (int i = nums.length - 2; i >= 1; i--) {
            if (preTotal > 0) {
                maxTotal = nums[i] + preTotal;
            } else {
                maxTotal = nums[i];
            }
            preTotal = nums[i];
        }

        return maxTotal;
    }

    public static int rob(int[] nums) {
        int total = 0;
        if (nums.length == 0) {
            return total;
        }
        int maxTotal = 0;
        int secondTotal = 0;
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            maxTotal += nums[i];
        }
        for (int i = 1; i < nums.length - 1; i = i + 2) {
            secondTotal += nums[i];
        }
        return Math.max(maxTotal, secondTotal);

    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = "";
            boolean is3Size = i % 3 == 0;
            boolean is5Size = i % 5 == 0;
            if (is3Size) {
                s = "Fizz";
            }
            if (is5Size) {
                s = s + "Buzz";
            }
            if (!is3Size && !is5Size) {
                s = "" + i;
            }
            list.add(s);
        }
        return list;
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        int i=1;
        double a=3*n;
        while (i<a){
            i=i*3;
        }

        return a%i==0;
    }
    public static int getMiniNumber(int n,int s,int L){
        int perMax=(L+1)/(s+1);
        if (perMax%13==0){
            perMax=perMax-1;
        }
        int num;
        if (n<perMax&&n%13==0){
            num=2;
        }else {
            if (n%perMax==0){
                num=n/perMax;
            }else {
                num=n/perMax+1;
            }

        }
        System.out.println(num);

        return num;
    }
}
