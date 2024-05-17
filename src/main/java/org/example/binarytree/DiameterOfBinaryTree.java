package org.example.binarytree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(solution.diameterOfBinaryTree(root)); // 3
    }
}


class Solution7 {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        maxDep(root);
        return res - 1;
    }

    private int maxDep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDep(root.left);

        int right = maxDep(root.right);

        res = Math.max(res, left + right + 1);

        return Math.max(left, right) + 1;
    }
}