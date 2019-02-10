package leetcode;

/**
 * @author rexthk
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */

public class SameTree {
    public static void main(String[] args) {
        System.out.println(isSameTree(new TreeNode(1), new TreeNode(1)));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null) return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
