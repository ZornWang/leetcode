package top100.BinaryTree;

import common.TreeNode;

public class Solution226 {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNode.createBinaryTreeByArray(list, 0);
        new Solution226().invertTree(root);
        TreeNode.preOrder(root);

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
