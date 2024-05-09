package org.example.linkedlist;


public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        Solution7 solution7 = new Solution7();
        System.out.println(solution7.detectCycle(head).val);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
    }
}

class Solution7 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}