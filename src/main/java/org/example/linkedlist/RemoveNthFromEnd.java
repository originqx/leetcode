package org.example.linkedlist;

// 19. Remove Nth Node From End of List
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode result = new Solution11().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution11 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode leftPre = new ListNode(0);
        ListNode res = leftPre;
        leftPre.next = head;
        ListNode left = head;
        ListNode right = head;
        while (n-- > 0) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            leftPre = leftPre.next;
            left = left.next;
        }
        leftPre.next = left.next;
        return res.next;

    }
}
