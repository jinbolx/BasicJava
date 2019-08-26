package leetcode;

public class MyLinkedList {

//    private Node<Integer> head;
//    private int size;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public MyLinkedList() {
//        head = new Node<>(null, null);
//        size = 0;
//    }
//
//    /**
//     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
//     */
//    public int get(int index) {
//        if (index < 0 || index > size - 1) {
//            return -1;
//        }
//        Node<Integer> preNode = head;
//        while (index > 0) {
//            preNode = preNode.next;
//            index--;
//        }
//        return preNode.next.val;
//    }
//
//    /**
//     * Add a node of value val before the first element of the linked list. After the insertion, the
//     * new node will be the first node of the linked list.
//     */
//    public void addAtHead(int val) {
//        addAtIndex(0, val);
//    }
//
//    /**
//     * Append a node of value val to the last element of the linked list.
//     */
//    public void addAtTail(int val) {
//        addAtIndex(size, val);
//    }
//
//    /**
//     * Add a node of value val before the index-th node in the linked list. If index equals to the
//     * length of linked list, the node will be appended to the end of linked list. If index is
//     * greater than the length, the node will not be inserted.
//     */
//    public void addAtIndex(int index, int val) {
//        if (index < 0 || index > size) {
//            return;
//        }
//        if (index == size) {
//            Node<Integer> currentNode = head;
//            while (currentNode.next != null) {
//                currentNode = currentNode.next;
//            }
//            currentNode.next = new Node<>(null, val);
//        } else {
//            int count = 0;
//            Node<Integer> preNode = head;
//            while (count < index) {
//                preNode = preNode.next;
//                count++;
//            }
//            preNode.next = new Node<>(preNode.next, val);
//        }
//        size++;
//    }
//
//    /**
//     * Delete the index-th node in the linked list, if the index is valid.
//     */
//    public void deleteAtIndex(int index) {
//        if (index >= 0 && index <= size - 1) {
//            Node<Integer> preNode = head;
//            while (index > 0) {
//                preNode = preNode.next;
//                index--;
//            }
//            preNode.next = preNode.next.next;
//            size--;
//        }
//    }
//
//    private class Node<E> {
//
//        Node<E> next;
//        E val;
//
//        Node(Node<E> next, E val) {
//            this.next = next;
//            this.val = val;
//        }
//    }
//
//    public static void main(String[] args) {
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2);
//        System.out.println(linkedList.get(1));
//        linkedList.deleteAtIndex(1);
//        System.out.println(linkedList.get(1));
//    }

    private DoubleNode<Integer> head;
    private DoubleNode<Integer> tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new DoubleNode<>(null, null, null);
        tail = new DoubleNode<>(head, null, null);
        head.next = tail;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        if (index > size / 2) {
            int count = size;
            DoubleNode<Integer> nextNode = tail;
            while (count > index) {
                nextNode = nextNode.pre;
                count--;
            }
            return nextNode.val;

        } else {
            int count = 0;
            DoubleNode<Integer> preNode = head;
            while (count < index) {
                preNode = preNode.next;
                count++;
            }
            return preNode.next.val;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the
     * new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the
     * length of linked list, the node will be appended to the end of linked list. If index is
     * greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            DoubleNode<Integer> currentNode = tail;
            currentNode.val = val;
            tail = new DoubleNode<>(currentNode, null, null);
            currentNode.next = tail;
        } else {
            if (index > size / 2) {
                int count = size;
                DoubleNode<Integer> nextNode = tail;
                while (count > index) {
                    nextNode = nextNode.pre;
                    count--;
                }
                DoubleNode<Integer> newNode=new DoubleNode<>(nextNode.pre,val,nextNode);
                nextNode.pre.next=newNode;
                nextNode.pre=newNode;
            } else {
                int count = 0;
                DoubleNode<Integer> preNode = head;
                while (count < index) {
                    preNode = preNode.next;
                    count++;
                }
                DoubleNode<Integer> currentNode = new DoubleNode<>(preNode, val, preNode.next);
                preNode.next.pre = currentNode;
                preNode.next = currentNode;
            }

        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index <= size - 1) {
            if (index >= size / 2) {
                int count = size;
                DoubleNode<Integer> nextNode = tail;
                while (count > index) {
                    nextNode = nextNode.pre;
                    count--;
                }
                DoubleNode<Integer> currentNode = nextNode;
                nextNode.pre.next = currentNode.next;
                nextNode.next.pre = currentNode.pre;
            } else {
                int count = 0;
                DoubleNode<Integer> preNode = head;
                while (count < index) {
                    preNode = preNode.next;
                    count++;
                }
                DoubleNode<Integer> currentNode = preNode.next;
                preNode.next = currentNode.next;
                currentNode.next.pre = preNode;
            }
            size--;
        }
    }

    private class DoubleNode<E> {

        DoubleNode<E> pre;
        E val;
        DoubleNode<E> next;

        DoubleNode(DoubleNode<E> pre, E val, DoubleNode<E> next) {
            this.pre = pre;
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(56);
        linkedList.get(1);
        linkedList.addAtHead(41);
        linkedList.addAtTail(98);
        linkedList.get(3);
        linkedList.addAtIndex(1,33);
        linkedList.addAtHead(72);
        linkedList.addAtHead(52);
        linkedList.addAtHead(89);
        linkedList.addAtHead(0);
        linkedList.addAtHead(98);
        linkedList.addAtIndex(7,97);
        linkedList.addAtIndex(2,51);
        linkedList.get(1);
        System.out.println(linkedList.get(6));
        linkedList.deleteAtIndex(7);

    }
}
