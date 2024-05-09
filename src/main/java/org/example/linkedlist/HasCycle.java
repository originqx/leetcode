package org.example.linkedlist;

public class HasCycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = node.next.next;
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.hasCycle(node));
    }
}

class Solution6 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (quick != slow) {
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}