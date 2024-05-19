package org.example.binarytree;

import java.util.*;

public class RightSideView {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(5));
        solution15.rightSideView(treeNode).forEach(System.out::println);
    }
}


class Solution15 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        //层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size - 1) {
                    res.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }
}