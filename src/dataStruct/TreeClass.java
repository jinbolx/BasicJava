package dataStruct;

import java.util.Stack;

public class TreeClass {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int val = root.val;
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            if (tempNode != null) {
                if (val == tempNode.val) {
                    stack.push(tempNode.right);
                    stack.push(tempNode.left);
                } else {
                    return false;
                }

            }
        }
        return true;

    }
    public void preOrderTraversal(TreeNode treeNode){
        if (treeNode!=null){
            System.out.println(treeNode.val);
        }

    }
}
