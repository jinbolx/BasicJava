package dataStruct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Test {
    private int[] weight = {2, 4, 2, 5, 9, 10, 11};
    private Random rnd = new Random();
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new Test().print();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("during: " + (endTime - startTime));
    }

    public void print() {
        int[] array = new int[16];
        int index = 0;
        int[] temp = weight.clone();
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                array[index++] = i;
                if(index >= array.length)
                {
                    int[] tempArray = new int[index * 2];
                    System.arraycopy(array, 0, tempArray, 0, index - 1);
                    array = tempArray;
                }
            }
        }

        for (int i=array.length; i>1; i--)
        {
            swap(array, i-1, rnd.nextInt(i));
        }

        for (int i : array) {
            System.out.print(i);
        }
        System.out.println();
    }

    /**
     * Swaps the two specified elements in the specified array.
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private static void queueTest(){
        Queue<Integer> queue=new LinkedList<>();
    }
}
