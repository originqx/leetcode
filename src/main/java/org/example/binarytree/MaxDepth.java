package org.example.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {

        // 测试代码

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution4 solution = new Solution4();

        System.out.println(solution.maxDepth(root)); // 输出 3

    }
}

class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);

        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

class Solution4 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            res++;
        }
        return res;
    }
}