package leetcode;

public class MyCircularDeque {

    Node<Integer> startMarker;
    Node<Integer> endMarker;
    Node<Integer> moveStart;
    Node<Integer> moveEnd;
    int currentSize;
    int length;

    class Node<E> {

        Node<E> pre;
        E val;
        Node<E> next;

        public Node(Node pre, E val, Node next) {
            this.pre = pre;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        startMarker = new Node<>(null, null, null);
        endMarker = new Node<>(startMarker, null, startMarker);
        startMarker.pre = endMarker;
        startMarker.next = endMarker;
        moveStart = startMarker;
        moveEnd = endMarker;
        currentSize = 0;
        length = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (!isFull()) {
            Node<Integer> currentNode = new Node<>(moveStart.pre, value, moveStart);
            moveStart.pre = currentNode;
            moveStart.pre.next = currentNode;
            moveStart = currentNode;
            currentSize++;
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (!isFull()) {
            Node<Integer> currentNode = new Node<>(endMarker.pre, value, endMarker);
            moveEnd.pre = currentNode;
            moveEnd.pre.next = currentNode;
            moveEnd = currentNode;
            currentSize++;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (!isEmpty()) {
            if (moveStart == startMarker) {
                deleteLast();
            }else
            {
                moveStart.next.pre = moveStart.pre;
                moveStart.pre.next = moveStart.next;
                moveStart = moveStart.next;
                currentSize--;
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (!isEmpty()) {
            if (moveEnd == endMarker) {
                deleteFront();
            } else {
                moveEnd.next.pre = moveEnd.pre;
                moveEnd.pre.next = moveStart.next;
                moveEnd = moveEnd.pre;
                currentSize--;
                return true;
            }

        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (!isEmpty()) {
            if (moveStart.val != null) {
                return moveStart.val;
            } else {
                return moveEnd.val;
            }
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (!isEmpty()) {
            if (moveEnd.val != null) {
                return moveEnd.val;
            } else {
                return moveStart.val;
            }
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return currentSize == length;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(77);
//        System.out.println(circularDeque.insertFront(1));
////        System.out.println(circularDeque.insertLast(2));
////        System.out.println(circularDeque.insertFront(3));
////        System.out.println(circularDeque.insertFront(4));
//        System.out.println(circularDeque.getRear());
//        System.out.println(circularDeque.isFull());
//        System.out.println(circularDeque.deleteLast());
//        System.out.println(circularDeque.insertFront(4));
//        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(89));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertFront(19));
        System.out.println(circularDeque.insertFront(23));
        System.out.println(circularDeque.insertFront(23));
        System.out.println(circularDeque.insertFront(82));
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.insertFront(45));
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.getRear());
    }
}
