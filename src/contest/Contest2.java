package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Contest2 {

    public static void main(String[] args) {
        Contest2 contest2 = new Contest2();
        System.out.println(contest2.lastRemaining(8));
        int a = 9;
        double m = (double) a / 4;
        double n = (double) (a / 4);
        System.out.println(String.format("m=%s,n=%s", m, n));
        int frequency = 100000;
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < frequency; i++) {
            shellInsert();
        }
        System.out.println(replaceUrl("http://220.163.102.61:18000/api/url/dpi"));
        mapModify();
    }

    //1
    public char findTheDifference(String s, String t) {
//        int sCount = 0;
//        int tCount = 0;
//        for (int i = 0; i < s.length(); i++) {
//            sCount += s.charAt(i);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            tCount += t.charAt(i);
//        }
//        return (char) (tCount - sCount);
        char temp = 0;
        for (int i = 0; i < s.length(); i++) {
            temp ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            temp ^= t.charAt(i);
        }
        return temp;
    }

    //2
    public int lastRemaining(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return removeNumber(list, true);
    }

    public int removeNumber(List<Integer> list, boolean leftToRight) {
        if (list.size() == 1) {
            return list.get(0);
        } else {
            if (leftToRight) {
                for (int i = 0; i < list.size(); i++) {
                    if (i % 2 == 0) {
                        list.set(i, -1);
                    }
                }
            } else {
                for (int i = list.size() - 1; i >= 0; i--) {
                    if ((list.size() - 1 - i) % 2 == 0) {
                        list.set(i, -1);
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == -1) {
                    list.remove(i);
                    i--;
                }
            }
            return removeNumber(list, !leftToRight);
        }
    }

    public static void shellInsert() {
        int[] arr = {10, 4, 0, 33, 44, 23, 90, 44, 34, 22, 41, 22, 32, 11};
        int gap = 1;
        while (gap < arr.length) {
            gap = 3 * gap + 1;
        }
        while (gap > 0) {
            for (int i = 0; i < arr.length - gap; i++) {
                int index = -1;
                int current = arr[i + gap];
                for (int j = i; j >= 0; j -= gap) {
                    if (arr[j] > current) {
                        index = j;
                        arr[j + gap] = arr[j];
                    } else {
                        break;
                    }
                }
                if (index != -1) {
                    arr[index] = current;
                }
            }
            gap = (int) Math.floor(gap / 3);
//            for (int i = gap; i < arr.length; i++) {
//                int temp = arr[i];
//                int j = i - gap;
//                while (j >= 0 && arr[j] > temp) {
//                    arr[j + gap] = arr[j];
//                    j = j - gap;
//                }
//               arr[j+gap]=temp;
//            }
//            gap = gap/3;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort() {
        int[] arr = {10, 4, 0, 33, 44, 23, 90, 44, 34, 22, 41, 22, 32, 11};
        merge(0,arr.length,arr);
    }

    public static void merge(int left, int right, int[] array) {
       if (left+1<right){
           int middle=left+right>>1;
           merge(left,middle,array);
           merge(middle,right,array);
           doMerge(left,middle,right,array);
       }
    }
    public static void doMerge(int left,int middle,int right,int[] array){

    }
    public static String replaceUrl(String url) {
        if (url.contains("://www")) {
            return url.replace("://www", "://fileio");
        }
        int ip_port = 122;
        if ( ip_port != 0) {
            String baseUrl = "http://220.163.102.61:18000/";
            if (url.startsWith(baseUrl)) {
                String apiUrl = url.substring(baseUrl.length()-1);
                int index = baseUrl.lastIndexOf(':');
                String oldPort = baseUrl.substring(index + 1);
                return baseUrl.replace(oldPort, ip_port + "") + apiUrl;
            }
        }
        return url.replace("://", "://fileio-");
    }
    public static void mapModify(){
        HashMap<String,Long> hashMap=new HashMap<>();
        HashMap<String ,Long> subHashMap=new HashMap<>();
        hashMap.putAll(subHashMap);
    }
}