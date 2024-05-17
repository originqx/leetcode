package org.example.binarytree;

public class InvertTree {
    public static void main(String[] args) {

        // 测试用例
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Solution5 solution = new Solution5();
        TreeNode invertedRoot = solution.invertTree(root);

        // 输出翻转后的二叉树
        System.out.println("Inverted Tree:");
        printTree(invertedRoot);
    }

    private static void printTree(TreeNode invertedRoot) {
        if (invertedRoot == null) {
            return;
        }
        System.out.print(invertedRoot.val + " ");
        printTree(invertedRoot.left);
        printTree(invertedRoot.right);
    }
}

class Solution5 {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        reverse(root.left);
        reverse(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


}