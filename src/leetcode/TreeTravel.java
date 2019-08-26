package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeTravel {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        insertNode(list, root);
        return list;
    }

    private void insertNode(List<Integer> list, TreeNode root) {
        if (root != null) {
            insertNode(list, root.left);
            list.add(root.val);
            insertNode(list, root.right);
        }
    }

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
