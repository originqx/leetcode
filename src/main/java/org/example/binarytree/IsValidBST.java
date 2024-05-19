package org.example.binarytree;

import java.util.*;

public class IsValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        Solution11 solution = new Solution11();
        System.out.println(solution.isValidBST(root)); // true
    }
}

class Solution13 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long inorderPre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.val <= inorderPre) {
                return false;
            }
            inorderPre = pop.val;
            root = pop.right;
        }
        return true;
    }

}

class Solution12 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}

class Solution11 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root,List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}