package contest;

public class Contest6 {

    public static void main(String[] args) {
        Contest6 contest6 = new Contest6();
        System.out.println(contest6.sumOfLeftLeaves(contest6.createTreeNode()));
    }

    public TreeNode createTreeNode() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        return treeNode;
    }
    //1
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        return getSum(root, false, sum);
    }

    public int getSum(TreeNode treeNode, boolean leftLeaves, int currentSum) {
        int total = currentSum;
        if (treeNode != null) {
            if (treeNode.left == null && treeNode.right == null) {
                if (leftLeaves) {
                    total += treeNode.val;
                }

            }
            if (treeNode.left != null) {
                total += getSum(treeNode.left, true, currentSum);
            }
            if (treeNode.right != null) {
                total += getSum(treeNode.right, false, currentSum);
            }
        }
        return total;
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
