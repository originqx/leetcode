package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        node7.next = node3;
        Solution2 solution = new Solution2();
        ListNode result = solution.getIntersectionNode(node1, node6);
        System.out.println(result.val);
    }
}

class Solution2 {
    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     * @param headA
     * @param headB
     * @return
     * 遍历的第一个节点为相交的起始节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 使用List存储节点
        List<ListNode> set = new ArrayList<>();
        ListNode rootA = headA;
        ListNode rootB = headB;
        while (rootA != rootB) {
            if (rootA != null) {
                rootA = rootA.next;
            } else {
                rootA = headB;
            }

            if (rootB != null) {
                rootB = rootB.next;
            } else {
                rootB = headA;
            }
        }
        return rootB;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     * @param headA
     * @param headB
     * @return
     * 遍历的第一个节点为相交的起始节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 使用List存储节点
        List<ListNode> set = new ArrayList<>();
        ListNode rootA = headA;
        ListNode rootB = headB;
        while (rootA != null) {
            set.add(rootA);
            rootA = rootA.next;
        }
        while (rootB != null) {
            if (set.contains(rootB)) {
                return rootB;
            }
            rootB = rootB.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
