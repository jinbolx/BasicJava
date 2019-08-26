package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLength {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
        int[] array={0,1,0,3,12};
        moveZeroes(array);
        moveZeroes2(array);
    }

    public static void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }
        int length=nums.length - list.size();
        for (int i = 0; i < length; i++) {
            list.add(0);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        System.out.println(Arrays.toString(nums));

    }
    public static void moveZeroes2(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        for (int i = index; i <nums.length ; i++) {
            nums[i]=0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
