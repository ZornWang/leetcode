package top100.BinaryTree;

import common.TreeNode;

public class Solution98 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{5, 1, 4, null, null, 3, 6}, 0);
        assert root != null;
        System.out.println(new Solution98().isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode node, long down, long up) {
        if (node == null) {
            return true;
        }
        if (node.val <= down || node.val >= up) {
            return false;
        }
        return check(node.left, down, node.val) && check(node.right, node.val, up);
    }
}
