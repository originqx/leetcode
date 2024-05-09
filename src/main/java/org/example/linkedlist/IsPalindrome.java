package org.example.linkedlist;

import java.security.Principal;

public class IsPalindrome {
    // 请判断一个链表是否为回文链表。
    // 示例 1:
    // 输入: 1->2
    // 输出: false
    // 示例 2:
    // 输入: 1->2->2->1
    // 输出: true
    public static void main(String[] args) {
        boolean palindrome = new Solution5().isPalindrome(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1)))));
        System.out.println(palindrome);
    }
}

class Solution5 {
    ListNode left = null;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return recur(head);
    }

    private boolean recur(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = recur(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}