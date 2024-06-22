package top100.BinaryTree;

import common.TreeNode;

public class Solution236 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 0);
        assert root != null;
        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode node = new Solution236().lowestCommonAncestor(root, p, q);
        System.out.println(node.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        // 左
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 中
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        } else return right;
    }
}
