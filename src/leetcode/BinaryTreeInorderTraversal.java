package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rexthk
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        System.out.println(inorderTraversal(new TreeNode(1)));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private static void traverse(TreeNode root, List<Integer> result) {
        if (root == null) return;
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
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
