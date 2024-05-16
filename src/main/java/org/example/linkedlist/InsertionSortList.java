package org.example.linkedlist;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        Solution18 solution18 = new Solution18();
        ListNode res = solution18.insertionSortList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}


class Solution18 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head.next;
        ListNode lastSorted = head;

        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = curr;
            } else {
                ListNode pre = dummy;
                while (pre.next.val <= curr.val) {
                    pre = pre.next;
                }
                lastSorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummy.next;
    }

}