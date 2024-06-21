package top100.BinaryTree;

import common.TreeNode;

public class Solution104 {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{3, 9, 20, 0, 0, 15, 7};
        TreeNode root = TreeNode.createBinaryTreeByArray(list, 0);
        System.out.println(new Solution104().maxDepth(root));
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
