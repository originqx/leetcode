package org.example.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.kthSmallest(root, 1));
    }
}

class Solution14 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        int count = 0;
        while (!stack.isEmpty() || root != null){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            count++;
            if (count == k) {
                return pop.val;
            }
            root = pop.right;
        }
        // 永远不会走到
        return 0;
    }
}