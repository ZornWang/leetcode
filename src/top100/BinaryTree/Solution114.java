package top100.BinaryTree;

import common.TreeNode;

public class Solution114 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 5, 3, 4, null, 6}, 0);
        new Solution114().flatten(root);
        TreeNode.inOrder(root);
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode left = root.left;
            if (root.right != null) {
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
            }
            root.right = root.left;
            root.left = null;
        }
    }
}
