package top100.BinaryTree;

import common.TreeNode;


public class Solution108 {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeNode.preOrder(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
