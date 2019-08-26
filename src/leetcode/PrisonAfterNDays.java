package leetcode;

import java.util.Arrays;

public class PrisonAfterNDays {
    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] array = cells.clone();
        int input = N%14;
        if (input == 0) {
            input = 14;
        }
        while (input > 0) {
            array=getResetIndex(array);
            input--;
        }
        return array;
    }

    public static int[] getResetIndex(int[] cells) {
        int[]array=new int[8];
        array[0]=0;
        array[7]=0;
        for (int i = 1; i < 7; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                array[i]=1;
            } else {
                array[i]=0;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,1,1,0,0,1};
        System.out.println(Arrays.toString(prisonAfterNDays(array, 7)));
    }
}
