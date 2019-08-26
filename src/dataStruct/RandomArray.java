package dataStruct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class RandomArray {

    private int[] weight = {2, 4, 2, 5, 9, 10, 11};

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new RandomArray().print();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("during: " + (endTime - startTime));
    }

    public void print() {
        List<Integer> list = new ArrayList<>();
        int[] temp = weight.clone();
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                list.add(i);
            }
        }
        Collections.shuffle(list);
        // list.forEach(System.out::print);
        for (Integer i : list) {
            System.out.print(i);
        }
        System.out.println();
        Map<String,String> map=new HashMap();
        Collections.synchronizedMap(map);
        Hashtable<String,String> hashtable=new Hashtable<>();
    }

}
