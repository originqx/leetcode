package org.example.linkedlist;

public class MergeTwoLists {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution9.mergeTwoLists(list1, list2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution9 {
    // 递归
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = null;
        ListNode resHead = null;

        if (list1.val < list2.val) {
            res = resHead = list1;
            list1 = list1.next;
        }else {
            res = resHead= list2;
            list2 = list2.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            }else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 != null) {
            res.next = list1;
        }
        if (list2 != null) {
            res.next = list2;
        }
        return resHead;
    }
}


class Solution8 {
    // 递归
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
