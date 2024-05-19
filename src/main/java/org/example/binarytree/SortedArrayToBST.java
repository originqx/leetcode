package org.example.binarytree;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Solution10 solution = new Solution10();
        TreeNode root = solution.sortedArrayToBST(nums);
        // 输出二叉搜索树的中序遍历结果
        System.out.println(inorderTraversal(root));
    }

    private static boolean inorderTraversal(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorderTraversal(root.left)) {
            return false;
        }
        System.out.print(root.val + " ");
        return inorderTraversal(root.right);
    }
}

class Solution10 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTMN(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTMN(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTMN(nums, left, mid - 1);
        root.right = sortedArrayToBSTMN(nums, mid + 1, right);
        return root;
    }
}