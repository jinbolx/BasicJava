package dataStruct;

import java.util.Arrays;

public class TestStudent {

    public static void main(String[] args) {

        Student[] array=new Student[5];
        for (int i = 0; i < 5; i++) {
            array[i]=new Student("name"+i, (int) (Math.random()*10+10));
        }
        getArray(array);
        for (Student student : array) {
            student.print();
        }
    }
    public static <T extends Comparable> T[] getArray(T[] ts){
        Arrays.sort(ts);
        return ts;
    }

}
