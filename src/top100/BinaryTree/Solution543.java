package top100.BinaryTree;

import common.TreeNode;

public class Solution543 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 3, 4, 5}, 0);
//        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{3,1,null,null,2}, 0);
        System.out.println(new Solution543().diameterOfBinaryTree(root));
    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
