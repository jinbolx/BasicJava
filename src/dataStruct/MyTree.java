package dataStruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MyTree<E extends Comparable<? super E>> {


    private static class BinaryNode<E> {

        E element;
        BinaryNode<E> leftChild;
        BinaryNode<E> rightChild;

        BinaryNode(E element) {
            this(element, null, null);
        }

        BinaryNode(E element, BinaryNode<E> leftChild, BinaryNode<E> rightChild) {
            this.element = element;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private BinaryNode<E> root;

    public MyTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean contains(E element) {
        return contains(element, root);
    }

    private boolean contains(E element, BinaryNode<E> root) {
        if (root == null) {
            return false;
        }
        int compareResult = element.compareTo(root.element);
        if (compareResult > 0) {
            return contains(element, root.rightChild);
        } else if (compareResult < 0) {
            return contains(element, root.leftChild);
        } else {
            return true;
        }
//        while (root!=null){
//            if (compareResult>0){
//                root=root.rightChild;
//            }else if (compareResult<0){
//                root=root.leftChild;
//            }else {
//                return true;
//            }
//        }
//        return false;
    }


    public E findMin() {
        return findMin(root);
    }

    private E findMin(BinaryNode<E> root) {
        if (root == null) {
            return null;
        }
        if (root.leftChild == null) {
            return root.element;
        } else {
            return findMin(root.leftChild);
        }
    }


    public E findMax() {
        return findMax(root);
    }

    private E findMax(BinaryNode<E> root) {
        if (root == null) {
            return null;
        }
        while (root.rightChild != null) {
            root = root.rightChild;
        }
        return root.element;
    }

    public void insert(E element) {
        root = insert(element, root);
    }

    public void remove(E element) {
        root = remove(element, root);
    }

    private BinaryNode<E> insert(E element, BinaryNode<E> root) {
        if (root == null) {
            root = new BinaryNode<>(element, null, null);
        } else {
            int compareResult = element.compareTo(root.element);
            if (compareResult > 0) {
                root.rightChild = insert(element, root.rightChild);
            } else if (compareResult < 0) {
                root.leftChild = insert(element, root.leftChild);
            }
        }
        return root;
    }

    private BinaryNode<E> remove(E element, BinaryNode<E> root) {
        if (root == null) {
            return null;
        } else {
            int compareResult = element.compareTo(root.element);
            if (compareResult < 0) {
                root.leftChild =
                        remove(element, root.leftChild);
            } else if (compareResult > 0) {
                root.rightChild =
                        remove(element, root.rightChild);
            } else {
                if (root.leftChild != null && root.rightChild != null) {
                    root.element = findMin(root.rightChild);
                    root.rightChild = remove(root.element, root.rightChild);
                } else {
                    root = root.leftChild == null ? root.rightChild : root.leftChild;
                }
            }

        }
        return root;
    }

    //    private E findMax(BinaryNode<E> eBinaryNode) {
////        if (eBinaryNode == null) {
////            return null;
////        } else if (eBinaryNode.rightChild == null) {
////            return eBinaryNode.element;
////        } else {
////            return findMax(eBinaryNode.rightChild);
////        }
//        if (eBinaryNode != null) {
//            while (eBinaryNode.rightChild != null) {
//                eBinaryNode = eBinaryNode.rightChild;
//            }
//            return eBinaryNode.element;
//        }
//        return null;
//    }
    public static void main(String[] args) {
//        MyTree<Integer> tree = new MyTree<>();
//        tree.insert(1);
//        tree.insert(3);
//        tree.insert(2);
//        tree.insert(0);
//        tree.insert(6);
//        tree.insert(4);
//        tree.insert(5);
//        tree.insert(7);
//        tree.remove(3);

        //  System.out.println(levelOrder(CreateTreeNode()));
        //  System.out.println(zigzagLevelOrder(CreateTreeNode()));
        //  System.out.println(preorderTraversal(CreateTreeNode()));
        System.out.println(inorderTraversal(createNode1()));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inOrderTraversal(p, q);
    }

    private boolean inOrderTraversal(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return inOrderTraversal(p.left, q.left) && (p.val == q.val) && inOrderTraversal(p.right,
                    q.right);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return inOrderTraversal1(root.left, root.right);
    }

    private boolean inOrderTraversal1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return inOrderTraversal1(p.left, q.right) && (p.val == q.val) && inOrderTraversal1(
                    p.right, q.left);
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        return maxDepth(root, maxDepth);
    }

    public int maxDepth(TreeNode treeNode, int currentMax) {
        if (treeNode == null) {
            return currentMax;
        } else {
            currentMax++;
            if (treeNode.left == null && treeNode.right == null) {
                return currentMax;
            } else {
                return Math.max(maxDepth(treeNode.left, currentMax),
                        maxDepth(treeNode.right, currentMax));
            }
        }
    }

    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    public TreeNode invert(TreeNode treeNode) {
        if (treeNode != null) {

        } else {
            return null;
        }
        return null;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        lists = setLevel(lists, 0, root);
        return lists;
    }

    private static List<List<Integer>> setLevel(List<List<Integer>> lists, int index,
            TreeNode treeNode) {
        if (treeNode != null) {
            if (lists.size() < index + 1) {
                List<Integer> list = new ArrayList<>();
                list.add(treeNode.val);
                lists.add(list);
            } else {
                List<Integer> list = lists.get(index);
                list.add(treeNode.val);
                lists.set(index, list);
            }
            index++;
            setLevel(lists, index, treeNode.left);
            setLevel(lists, index, treeNode.right);
        }
        return lists;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        lists = setLevelWithDirection(lists, 0, root, true);
        return lists;
    }

    private static List<List<Integer>> setLevelWithDirection(List<List<Integer>> lists, int index,
            TreeNode treeNode, boolean leftToRight) {
        if (treeNode != null) {
            if (lists.size() < index + 1) {
                List<Integer> list = new LinkedList<>();
                list.add(treeNode.val);
                lists.add(list);
            } else {
                List<Integer> list = lists.get(index);
                if (leftToRight) {
                    list.add(treeNode.val);
                } else {
                    ((LinkedList<Integer>) list).addFirst(treeNode.val);
                }

                lists.set(index, list);
            }
            index++;
            setLevelWithDirection(lists, index, treeNode.left, !leftToRight);
            setLevelWithDirection(lists, index, treeNode.right, !leftToRight);
        }
        return lists;
    }


    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    private static TreeNode CreateTreeNode() {
        TreeNode treeNode1 = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(10);
        TreeNode treeNode8 = new TreeNode(22);
        treeNode1.left = treeNode6;
        treeNode1.right = treeNode7;
        treeNode2.left = treeNode8;
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode2;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode3;
        return treeNode5;
    }

    private static TreeNode createNode1() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(35);
        TreeNode treeNode2 = new TreeNode(30);
        TreeNode treeNode3 = new TreeNode(33);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(21);
        TreeNode treeNode6 = new TreeNode(2);
        treeNode1.left = treeNode;
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode2;
        treeNode5.right = treeNode6;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode5;
        return treeNode4;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        //  return preOrder(root, new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                if (!stack.isEmpty()) {
                    root = stack.pop();
                    list.add(root.val);
                }
                root = root.right;
            }
        }
        return list;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // return post(root, list);
        return list;
    }

    private static List<Integer> post(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            post(treeNode.left, list);
            post(treeNode.right, list);
            list.add(treeNode.val);
        }
        return list;
    }

    //
//    public static List<Integer> preOrder(TreeNode treeNode, List<Integer> list) {
//        if (treeNode != null) {
//            list.add(treeNode.val);
//            preOrder(treeNode.left, list);
//            preOrder(treeNode.right, list);
//        }
//        return list;
//    }
    public void flatten(TreeNode root) {

    }

    private int hashCode1(String s) {
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            val += 31 * val + s.charAt(i);
        }
        return val;
    }
}
