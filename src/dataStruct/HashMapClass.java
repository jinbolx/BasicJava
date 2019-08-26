package dataStruct;

import java.util.HashMap;
import java.util.Map;

public class HashMapClass {

    public static void printHashMap(){
//        HashMap<String,Integer> map=new HashMap<>();
//        map.put("语文", 1);
//        map.put("数学", 2);
//        map.put("英语", 3);
//        map.put("历史", 4);
//        map.put("政治", 5);
//        map.put("地理", 6);
//        map.put("生物", 7);
//        map.put("化学", 8);
//        for (Entry<String,Integer> entry:map.entrySet()
//        ) {
//            System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
//        }
        Map map=new HashMap();
        map.put(1l,"name");
        map.put(1,"value");
        long a=1;
        int b=1;
        System.out.println("1l: "+map.get(a)+" 1: "+map.get(b));
        int c=-7;
        int d=4;
        int e=c%d;
    }

}
