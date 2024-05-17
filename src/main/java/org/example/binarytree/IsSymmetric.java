package org.example.binarytree;

public class IsSymmetric {
    public static void main(String[] args) {

        // 测试代码

        // 创建一个对称的二叉树
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);

        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);

        root.right.right = new TreeNode(3);

        // 判断该二叉树是否是对称的

        Solution6 solution = new Solution6();

        boolean isSymmetric = solution.isSymmetric(root);

        System.out.println(isSymmetric); // 输出 true

    }
}


class Solution6 {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}