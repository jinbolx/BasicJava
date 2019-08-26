package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortClass {

    public static void main(String[] args) {
        int[] arr = {43, 20, 17, 13, 28, 14, 23, 15};
        //System.out.println(Arrays.toString(bubbleSor(arr)));
        // System.out.println(Arrays.toString(selectionSort(arr)));
        // System.out.println(Arrays.toString(insertSort(arr)));
        // System.out.println(isAnagram("abc", "bcd"));
        int[] arrs = {12, 13, 14, 12, 14, 13, 11};
        int[] arr1 = {3, 0, 6, 1, 5};
        //   System.out.println(hIndex(arr1));
        System.out.println("start");
        int testFrequency = 10000000;
        int testNumber = 145;
        // fibTest(testFrequency,testNumber);
//        int index = 9;
//        for (int i = 0; i < 10; i++) {
//            index = ~index;
//            System.out.println(index);
//        }
        numJewelsInStones("z", "ZZ");
        System.out.println("number: "+getTotalNumber(4));
    }

    //冒泡排序，相邻比较大数下沉，小数上浮时间复杂度o(n^2)
    public static int[] bubbleSor(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int temp;
        for (int i = 0; i < arr.length; i++) {
            //设置标志位，当一次循环之后flag未改变说明顺序已经排好下面不需要在进行循环比较
            boolean flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            if (!flag) {
                return arr;
            }
        }
        return arr;
    }

    //选择排序，从n-1个数里面找出最小的和第一个数交换
    //第二遍从n-2个数里面找出最小的和第二个数交换....直到第n-1遍找到最小的数与第n-1个数交换
    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int tempCode;
        for (int i = 0; i < arr.length; i++) {
            int temp = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[temp] > arr[j]) {
                    temp = j;
                }
            }
            if (temp != i) {
                tempCode = arr[i];
                arr[i] = arr[temp];
                arr[temp] = tempCode;
            }
        }
        return arr;
    }

    //插入排序
    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i1 : nums1) {
            set1.add(i1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i1 : nums2) {
            if (set1.contains(i1)) {
                list.add(i1);
                set1.remove(i1);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public int[] sortArrayByParityII(int[] A) {
        int[] oddArr = new int[A.length / 2];
        int[] evenArr = new int[A.length / 2];
        int oddIndex = -1;
        int evenIndex = -1;
        for (int i1 : A) {
            if (i1 % 2 != 0) {
                oddArr[++oddIndex] = i1;
            } else {
                evenArr[++evenIndex] = i1;
            }
        }
        for (int i = 0; i < oddArr.length; i++) {
            A[i * 2] = evenArr[i];
            A[i * 2 + 1] = oddArr[i];
        }
        return A;

    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            sArr[index - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i);
            tArr[index - 'a']++;
        }
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] != sArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i1 : nums1) {
            if (map.containsKey(i1)) {
                map.put(i1, map.get(i1) + 1);
            } else {
                map.put(i1, 1);
            }
        }
        int size = Math.max(nums1.length, nums2.length);
        int index = -1;
        int[] arr = new int[size];
        for (int i1 : nums2) {
            if (map.containsKey(i1) && map.get(i1) > 0) {
                map.put(i1, map.get(i1) - 1);
                arr[++index] = i1;
            }
        }
        return Arrays.copyOfRange(arr, 0, index + 1);
    }

    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int num : nums) {
            arr[num]++;
        }
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                nums[++index] = i;
            }
        }
    }

    public String largestNumber(int[] nums) {

        return "0";
    }

    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        int[] array = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            array[chars[i] - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        if (max > (array.length + 1) / 2) {
            return "";
        } else {

        }
        return "";
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, Math.abs(nums[i] - nums[i + 1]));
        }
        return max;
    }

    public static int singleNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) {
//                set.remove(num);
//            } else {
//                set.add(num);
//            }
//        }
//        return set.iterator().next();
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        if (citations.length == 1) {
            if (citations[0] == 0) {
                return 0;
            }
            return 1;
        }
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - i <= citations[i]) {
                return citations[i];
            }
        }
        return 0;

    }

    public static int FibonacciNumber(int position) {
        if (position == 0) {
            return 0;
        }
        if (position == 1) {
            return 1;
        }
        return FibonacciNumber(position - 1) + FibonacciNumber(position - 2);
    }

    public static int FibonacciMemo(int n) {
        if (n <= 0) {
            return n;
        }
        int[] Memo = new int[n + 1];
        for (int i = 0; i < Memo.length; i++) {
            Memo[i] = -1;
        }
        return fib(n, Memo);
    }

    public static int fib(int n, int[] Memo) {
        if (n <= 0) {
            Memo[n] = 0;
        }
        if (Memo[n] != -1) {
            return Memo[n];
        }

        if (n == 1) {
            Memo[n] = 1;
        } else {
            Memo[n] = fib(n - 1, Memo) + fib(n - 2, Memo);
        }
        return Memo[n];

    }

    public static int fibFromBottomToTOp(int n) {
        if (n <= 0) {
            return n;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static int fibFromBottomToTOp2(int n) {
        if (n <= 0) {
            return n;
        }
        int a = 1;
        int a_i_1 = 1;
        int a_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            a = a_i_1 + a_i_2;
            a_i_2 = a_i_1;
            a_i_1 = a;
        }
        return a;
    }

    public static void fibTest(int testFrequency, int testNumber) {
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < testFrequency; i++) {
            fibFromBottomToTOp2(testNumber);
        }
        System.out.println(fibFromBottomToTOp2(testNumber));
        long end3 = System.currentTimeMillis();
        System.out.println("during3: " + (end3 - start3));
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < testFrequency; i++) {
            fibFromBottomToTOp(testNumber);
        }
        System.out.println(fibFromBottomToTOp(testNumber));
        long end1 = System.currentTimeMillis();
        System.out.println("during1: " + (end1 - start1));
        for (int i = 0; i < testFrequency; i++) {
            FibonacciMemo(testNumber);
        }
        System.out.println(FibonacciMemo(testNumber));
        long end2 = System.currentTimeMillis();
        System.out.println("during2: " + (end2 - end1));
        FibonacciNumber(50);
        long end4 = System.currentTimeMillis();
        System.out.println("during4: " + (end4 - end2));
    }

    public static int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) {
            return 0;
        }
        int[] arr = new int[58];
        for (int i = 0; i < J.length(); i++) {
            arr[J.charAt(i) - 'A'] = 1;
        }
        int num = 0;
        for (int i = 0; i < S.length(); i++) {
            if (arr[S.charAt(i) - 'A'] != 0) {
                num++;
            }
        }
        return num;
    }
    public static int getTotalNumber(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        return getTotalNumber(n-1)+getTotalNumber(n-2);
    }
}
