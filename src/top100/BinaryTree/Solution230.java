package top100.BinaryTree;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution230 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{3, 1, 4, null, 2}, 0);
        int k = 1;
        System.out.println(new Solution230().kthSmallest(root, k));
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k <= 0) {
                break;
            }
            root = root.right;
        }
        assert root != null;
        return root.val;
    }
}
