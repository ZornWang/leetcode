package top100.BinaryTree;

import common.TreeNode;

public class Solution437 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 0);
        int targetSum = 8;
        System.out.println(new Solution437().pathSum(root, targetSum));
    }

    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int result = rootSum(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);

        return result;
    }

    public int rootSum(TreeNode root, long targetSum) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            result++;
        }
        result += rootSum(root.left, targetSum - val);
        result += rootSum(root.right, targetSum - val);
        return result;
    }

}
