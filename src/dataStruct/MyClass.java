package dataStruct;

import java.security.SecureRandom;

public class MyClass {
    private int[] array;
    private int[] weight = {2,4,2,5,9,10,11};
    public static void main(String[] args)
    {
        long startTime= System.currentTimeMillis();
        MyClass clazz = new MyClass();
        for (int i = 0 ; i < 100000 ; i++)
        {
            clazz.createArray();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("during: "+(endTime-startTime));
    }

    private void createArray()
    {
        int[] tempWeight = weight.clone();
        SecureRandom random = new SecureRandom();
        int length = 0;
        for (int i : tempWeight)
        {
            length += i;
        }
        array = new int[length];
        for(int i = 0 ; i < length ; i++)
        {
            int temp = random.nextInt(tempWeight.length);
            temp = getInsetData(tempWeight,temp);
            array[i] = temp;
            System.out.print(temp);
        }
        System.out.println("");
    }

    private int getInsetData(int[] tempWeight, int temp)
    {
        if(tempWeight[temp] > 0)
        {
            tempWeight[temp]--;
            return temp;
        }
        else
        {
            temp++;
            temp = temp % tempWeight.length;
            return getInsetData(tempWeight, temp);
        }
    }
}
