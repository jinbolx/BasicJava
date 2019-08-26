package dataStruct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import leetcode.MinStack;

public class GenericType<N> {

    public static void main(String[] args) {
        Person[] person = new Student[10];
        person[0] = new Student("teacher");
        Circle[] shapes = new Circle[5];
        for (int i = 0; i < 5; i++) {
            shapes[i] = new Circle(i);
        }
        totalArea(shapes);
        List<Circle> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Circle(i));
        }
        totalArea(list);
        isEqual(shapes, new Square(2));
        findMax(shapes, new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                return Integer.compare(o1.area, o2.area);
            }
        });
        System.out.println("number: " + getOneNumber(3));
        int[] array = {-1, -2};
        System.out.println(maxSub(array));
        System.out.println(maxSub2(array));
        System.out.println(maxSub1(array));
        int[] nums = {1, 2, 3, 4};

        System.out.println(binarySearch(nums, 1));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list1.add(i);
            list2.add(i);
        }
        long start = System.currentTimeMillis();
        remove(list1);
        long end1 = System.currentTimeMillis();
        System.out.println("arrayList remove " + (end1 - start));
        remove(list2);
        long end2 = System.currentTimeMillis();
        System.out.println("linkList remove: " + (end2 - end1));
        //forEach(list1);
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerMyArrayList.add(i);
        }
        System.out.println(integerMyArrayList.toString());
        integerMyArrayList.set(5, 4);
        integerMyArrayList.set(4, 2);
        System.out.println(integerMyArrayList.toString());
        integerMyArrayList.remove((Object) 4);
        integerMyArrayList.remove(4);
        System.out.println(integerMyArrayList.toString());
        Iterator<Integer> iterator = integerMyArrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
            iterator.remove();
        }
        int[] nu = {3, 2, 3};
        majorityElement(nu);
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.println(linkedList.toString());
        linkedList.remove(8);
        System.out.println(linkedList.toString());
        linkedList.set(3, 5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(4));
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        MyLinkedQueue<Integer> myLinkedQueue = new MyLinkedQueue<>();
        myLinkedQueue.push(1);
        myLinkedQueue.push(2);
        myLinkedQueue.push(3);
        myLinkedQueue.push(-1);
        System.out.println("queue: " + myLinkedQueue.pop());
        myLinkedQueue.push(9);
        System.out.println("queue: " + myLinkedQueue.pop());
        System.out.println("queue: " + myLinkedQueue.pop());
        System.out.println("queue: " + myLinkedQueue.pop());

        int[] num = {1, 3};
        System.out.println(searchInsert(num, 1));


    }

    public static int totalArea(Shape[] shapes) {
        int sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area;
        }
        return sum;
    }

    public static int totalArea(Collection<? extends Shape> shapes) {
        int sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area;
        }
        return sum;
    }

    public static int totalArea1(Collection<? super Circle> shapes) {
        int sum = 0;
        for (Object shape : shapes) {
            sum += shape.hashCode();
        }
        return sum;
    }

    public static <T extends Shape> boolean isEqual(T[] t, T x) {

        for (T t1 :
                t) {
            if (x.equals(t1)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable> int findMax(T[] shapes) {
        int maxIndex = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].compareTo(shapes[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static <T extends Comparable<T>> int findMax1(T[] shapes) {
        int maxIndex = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].compareTo(shapes[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static <T> T findMax(T[] t, Comparator<T> compares) {
        int maxIndex = 0;
        for (int i = 0; i < t.length; i++) {
            if (compares.compare(t[i], t[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return t[maxIndex];
    }

    public static <T> void test(T[] t) {

    }

    public static <T extends Comparable<? super T>> int findMax2(T[] shapes) {
        int maxIndex = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].compareTo(shapes[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static class Person {

        private String type;

        public Person(String type) {
            this.type = type;
            int a = 0;
            Integer b = new Integer(a);
            a = b.intValue();
            System.out.println("type: " + type);
        }

        public Person() {
        }
    }

    static class Student extends Person {

        public Student(String type) {
            super(type);
            System.out.println("type: " + type);
        }

        public Student() {

        }
    }

    static class Teacher extends Person {

        private String type;

        public Teacher() {
        }

        public Teacher(String type) {
            this.type = type;
            // System.out.println("type: "+type);
        }
    }

    static class Shape {

        int area;

        public Shape(int area) {
            this.area = area;
        }

    }

    static class Circle extends Shape {

        public Circle(int area) {
            super(area);
        }
    }

    static class Square extends Shape {

        public Square(int area) {
            super(area);
        }
    }

    public static int getOneNumber(int n) {
        int extra = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 1) {
            return getOneNumber(n / 2) + 1;
        } else {
            return getOneNumber(n / 2);
        }
    }

    public static int maxSub(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int maxSub1(int[] nums) {
        int max = nums[0];
        int thisSum = 0;
        for (int num : nums) {
            thisSum += num;
            if (thisSum > max) {
                max = thisSum;
            }
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return max;
    }

    public static int maxSub2(int[] nums) {
        return maxSum(nums, 0, nums.length - 1);
    }

    public static int maxSum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int center = (left + right) / 2;
        int maxLeftSum = maxSum(nums, left, center);
        int maxRightSum = maxSum(nums, center + 1, right);
        int maxLeftBorderSum = Integer.MIN_VALUE;
        int leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += nums[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }
        int maxRightBorderSum = Integer.MIN_VALUE;
        int rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += nums[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return Math.max(Math.max(maxLeftBorderSum + maxRightBorderSum, maxLeftSum), maxRightSum);
    }

    public static int binarySearch(int[] nums, int x) {

        int lowIndex = 0;
        int highIndex = nums.length - 1;
        while (lowIndex <= highIndex) {
            int centerIndex = (lowIndex + highIndex) / 2;
            if (nums[centerIndex] > x) {
                highIndex = centerIndex - 1;
            } else if (nums[centerIndex] < x) {
                lowIndex = centerIndex + 1;
            } else {
                return centerIndex;
            }
        }
        return -1;
    }

    public static void forEach(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == 1) {
                nums.remove(i);
                i--;
            }
        }
        System.out.println(nums);
    }

    public static void remove(List<Integer> integers) {
        integers.listIterator().hasPrevious();
        Iterator<Integer> integerIterator = integers.iterator();
        while (integerIterator.hasNext()) {
            if (integerIterator.next() % 2 == 0) {
                integerIterator.remove();
            }
        }
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] candyArray = new int[2];
        int sumA = 0;
        int sumB = 0;
        int diff = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            hashMap.put(A[i], i);
        }
        for (int i1 : B) {
            sumB += i1;
        }
        diff = (sumB - sumA) / 2;
        for (int i = 0; i < B.length; i++) {
            if (hashMap.containsKey(B[i] - diff)) {
                candyArray[0] = B[i] - diff;
                candyArray[1] = B[i];
            }
        }
        return candyArray;
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer :
                nums) {
            if (hashMap.get(integer) == null) {
                hashMap.put(integer, 1);
            } else {
                int s = hashMap.get(integer);
                hashMap.put(integer, s + 1);
                if (s > nums.length / 2 - 1) {
                    return integer;
                }
            }
        }
        return -1;
    }

    public static int majorityElement1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] < target) {
                return 1;
            } else {
                return 0;
            }
        }
        int low = 0;
        int high = nums.length - 1;
        return getIndex(low, high, nums, target);

    }

    private static int getIndex(int low, int high, int[] nums, int target) {
        if (high - low == 1) {
            if (target > nums[high]) {
                return high + 1;
            } else if (target <= nums[low]) {
                return low;
            } else {
                return high;
            }
        } else {
            int center = (high + low) / 2;
            if (nums[center] > target) {
                return getIndex(low, center, nums, target);
            } else if (nums[center] < target) {
                return getIndex(center, high, nums, target);
            } else {
                return center;
            }
        }
    }
}
