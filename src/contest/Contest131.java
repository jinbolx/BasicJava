package contest;

import java.util.ArrayList;
import java.util.List;

public class Contest131 {

    public static void main(String[] args) {

    }
    //1
    public static String removeOuterParentheses(String S) {
        int mark = 0;
        String everyString = "";
        // String totalString="";
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (mark != 0) {
                    everyString = everyString + S.charAt(i);
                }
                mark++;
            } else {
                mark--;
                if (mark != 0) {
                    everyString = everyString + S.charAt(i);
                }
            }
        }
        return everyString;
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //2
    public static int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        String s = "";
        getSingle(root, list, s);
        int count = 0;
        for (String value : list) {
            count += Integer.valueOf(value, 2);
        }
        return count % (1000000000 + 7);
    }

    public static void getSingle(TreeNode treeNode, List<String> list, String s) {
        s = s + treeNode.val;
        if (treeNode.left != null) {
            getSingle(treeNode.left, list, s);
        }
        if (treeNode.right != null) {
            getSingle(treeNode.right, list, s);
        }
        if (treeNode.left == null && treeNode.right == null) {
            list.add(s);
        }
    }
    //4
    public static int videoStitching(int[][] clips, int T) {
        List<List<Integer>> lists = new ArrayList<>();
        int maxEnd = 0;
        int startIndex = -1;
        for (int i = 0; i < clips.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < clips[i].length; j++) {
                list.add(clips[i][j]);
            }
            lists.add(list);
            if (clips[i][0] == 0) {
                if (maxEnd < clips[i][1]) {
                    maxEnd = clips[i][1];
                    startIndex = i;
                }
            }
        }
        if (startIndex == -1) {
            return -1;
        } else {
            lists.remove(startIndex);
            return getMaxEnd(lists, maxEnd, 1, T);
        }
    }

    public static int getMaxEnd(List<List<Integer>> lists, int currentLeft, int count, int T) {
        if (currentLeft >= T) {
            return count;
        } else {
            int maxEnd = 0;
            int removeIndex = -1;
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i).get(0) <= currentLeft) {
                    if (maxEnd < lists.get(i).get(1)) {
                        maxEnd = lists.get(i).get(1);
                        removeIndex = i;
                    }
                }
            }
            count++;
            if (removeIndex == -1) {
                return -1;
            } else {
                lists.remove(removeIndex);
                return getMaxEnd(lists, maxEnd, count, T);
            }
        }
    }
    //3
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        int patternUpperCount = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (isUpper(pattern.charAt(i))) {
                patternUpperCount++;
            }
        }
        for (String query : queries) {
            int everyCount = 0;
            for (int j = 0; j < query.length(); j++) {
                if (isUpper(query.charAt(j))) {
                    everyCount++;
                }
            }
            if (everyCount == patternUpperCount) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (list.get(i)) {
                int cur = -1;
                for (int j = 0; j < pattern.length(); j++) {
                    cur = queries[i].indexOf(pattern.charAt(j), cur+1) ;
                    if (cur == -1) {
                        list.set(i, false);
                        break;
                    }
                }
            }
        }
        return list;
    }

    public static boolean isUpper(char c) {
        return c >= 65 && c <= 90;
    }

}
