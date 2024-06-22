package top100.BinaryTree;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    private Map<Integer, Integer> indexMap;

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = new Solution105().buildTree(preorder, inorder);
        System.out.println(new Solution102().levelOrder(root).toString());
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历第一个节点为根节点
        // 中序遍历中找到根节点
        int inorderRoot = indexMap.get(preorder[preorderLeft]);

        // 建立根节点
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        // 左子树个数
        int leftSize = inorderRoot - inorderLeft;

        root.left = build(preorder, inorder, preorderLeft + 1, preorderLeft + leftSize, inorderLeft, inorderRoot - 1);
        root.right = build(preorder, inorder, preorderLeft + leftSize + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }
}
