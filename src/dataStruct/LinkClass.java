package dataStruct;

/**
 * 单向链表，向外暴露的只有头节点
 */
public class LinkClass {

    public Node head = null;

    public static class Node<V> {

        public Node<V> next = null;
        public V data;

        public Node(V data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return this.getClass() + "[" + this.data.toString() + "]";
        }
    }

    /**
     * @param node 单向链表添加
     */
    public void add(Node node) {
        //头节点为空，放在头节点
        if (head == null) {
            head = node;
            return;
        }
        //头节点不为空，遍历获得最后一个节点，最后一个节点的next永远为空
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        //最后一个节点的next指向新的node
        temp.next = node;
    }

    /**
     * @param index 单向链表按index删除
     */
    public boolean remove(int index) {
        if (index < 0 || index > length()) {
            return false;
        }
        if (index == 0) {
            head = head.next;
        }
        int i = 1;
        Node preNode = head;
        Node currentNode = head.next;
        while (preNode.next != null) {
            if (i == index) {
                preNode.next = currentNode.next;
                return true;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
            i++;
        }

        return false;
    }

    public boolean delete(Node node) {
        return false;
    }

    public void printLink(Node node) {
        if (node != null) {
            //先输出后递归，从头到尾输出
            System.out.println("node: "+node.data);
            printLink(node.next);
            //先递归后输出，从尾到头输出
            System.out.println("node: "+node.data);
        }
    }

    private int length() {
        int length = 0;
        if (head == null) {
            return length;
        }
        Node temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
