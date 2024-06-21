package top100.BinaryTree;

import common.TreeNode;

public class Solution101 {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeNode.createBinaryTreeByArray(list, 0);
        System.out.println(new Solution101().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

}
