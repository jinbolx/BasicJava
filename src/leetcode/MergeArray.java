package leetcode;

import java.util.Arrays;

public class MergeArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m + n - m >= 0) {
            System.arraycopy(nums2, 0, nums1, m, m + n - m);
        }
        Arrays.sort(nums1);

    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(num1, m, num2, n);
        int[] n1 = {1, 0};
        dominantIndex(n1);
    }

    public int threeSumClosest(int[] nums, int target) {
        if (target > 0) {

        } else {

        }
        return 0;
    }

    public static int dominantIndex(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] < nums[j] * 2) {
                        break;
                    } else {
                        count++;
                    }
                }
            }
            if (count == nums.length - 1) {
                index = i;
            }
        }
        return index;
    }

    public int[] plusOne(int[] digits) {
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum += multiply(digits.length - 1 - i, digits[i]);
        }
        sum++;
        return digits;
    }

    public int multiply(int times, int num) {
        for (int i = 0; i < times; i++) {
            num = num * 10;
        }
        return num;
    }
}
