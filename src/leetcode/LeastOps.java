package leetcode;

public class LeastOps {

    public static void main(String[] args) {
        System.out.println("leastOps " + leastOpsExpressTarget(3, 365));
    }

    public static int leastOpsExpressTarget(int x, int target) {
        int remainder = target % x;
        int count = 0;
        if (remainder != 0) {
            int temp1, temp2;
            //if (remainder > x / 2) {
            //
            temp1 = 2 * (x - remainder);
            // } else {
            //remainder*(x/x)
            temp2 = 2 * remainder - 1;
            //  }
            count = Math.min(temp1, temp2);
        }
        int dividend = target - remainder;
        int dividendCount = 0;
        int current = 0;
        if (dividend > 0) {
            if (remainder != 0) {
                dividendCount++;
            }
            while (dividend / x > 0) {
                dividend = dividend / x;
                current++;
            }
            int temp1, temp2;
            // if (dividend>x/2){
            //x^(current+1)-(x-dividend)*x^current
            temp1 = current + 1 + (current - 1) * (x - dividend) + x - dividend - 1;
            //  }else {
            //n*(x/x)
            temp2 = (current - 1) * dividend + dividend - 1;
            //   }
            dividendCount += Math.min(temp1, temp2);
        }
        count += dividendCount;
        return count;
    }

}
