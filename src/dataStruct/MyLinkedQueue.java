package dataStruct;

public class MyLinkedQueue<E> {

    private Node<E> front;
    private Node<E> back;
    private int size;

    public MyLinkedQueue() {
        front = new Node<>(null, null, null);
        back = new Node<>(front, null, null);
        front.next = back;
        size = 0;
    }

    public void push(E x) {
        Node<E> node = new Node<>(back.pre, x, back);
        back.pre.next = node;
        back.pre = node;
        size++;
    }


    public E pop() {
        Node<E> node = front.next;
        front.next=node.next;
        size--;
        return node.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<E> {

        private Node<E> pre;
        private E val;
        private Node<E> next;

        Node(Node<E> pre, E val, Node<E> next) {
            this.pre = pre;
            this.val = val;
            this.next = next;
        }
    }

}
