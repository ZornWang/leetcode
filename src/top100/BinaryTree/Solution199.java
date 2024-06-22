package top100.BinaryTree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 3, null, 5, null, 4}, 0);
        System.out.println(new Solution199().rightSideView(root).toString());
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public void helper(TreeNode node, List<Integer> list, int depth) {
        if (node == null) {
            return;
        }
        if (list.size() <= depth) {
            list.add(node.val);
        }
        depth++;
        helper(node.right, list, depth);
        helper(node.left, list, depth);
    }
}
