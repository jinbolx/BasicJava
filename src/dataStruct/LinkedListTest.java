package dataStruct;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import leetcode.MyQueue;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        forByIterator(linkedList);
        forRandom(linkedList);
        forEach(linkedList);
//        Stack<Integer> stack=new Stack<>();
//        stack.add(stack.size(),1);
//        stack.add(stack.size(),2);
//        stack.add(stack.size(),3);
//        for (int i = 0; i < 3; i++) {
//            System.out.println("stack"+i+": "+stack.get(i));
//        }
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 3; i++) {
            myQueue.push(i);
        }
        System.out.println("stackPeek: "+myQueue.peek());
        System.out.println("stackPop: "+myQueue.pop());
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            System.out.println("poll: "+((LinkedList<Integer>) queue).pollLast());
            System.out.println("peek: "+queue.peek());
        }
    }

    public static void forByIterator(LinkedList<Integer> linkedList) {
        Iterator<Integer> iterator = linkedList.iterator();
        long start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("during: " + (end - start));
    }

    public static void forRandom(LinkedList<Integer> linkedList) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("during: " + (end - start));
    }

    public static void forEach(LinkedList<Integer> linkedList) {
        long start = System.currentTimeMillis();
        for (Integer integer :
                linkedList) {
            int a = integer;
        }
        long end = System.currentTimeMillis();
        System.out.println("during: " + (end - start));
    }

}
