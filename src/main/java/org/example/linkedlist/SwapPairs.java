package org.example.linkedlist;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode result = new Solution12().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution12 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {

            // 交换
            prev.next = right;
            left.next = right.next;
            right.next = left;

            // 移动指针
            prev = left;
            left = left.next;
            right = left != null ? left.next : null;
        }
        return dummy.next;
    }
}
