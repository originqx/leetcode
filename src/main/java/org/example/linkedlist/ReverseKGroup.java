package org.example.linkedlist;

import java.lang.annotation.Target;
import java.security.Key;

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode result = new Solution14().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution14 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reversed = reverseMN(head, tail);
            head = reversed[0];
            tail = reversed[1];
            // 重接接上
            pre.next = head;
//            tail.next = next;
            pre = tail;
            head = tail.next;

        }
        return dummy.next;
    }


    private ListNode[] reverseMN(ListNode left, ListNode right)  {
        // 后面已经接上了
        ListNode prev = right.next;
        ListNode curr = left;
        ListNode next;
        while (prev != right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{right, left};
    }
}