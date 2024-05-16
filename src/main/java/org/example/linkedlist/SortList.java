package org.example.linkedlist;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        ListNode listNode = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode result = solution17.sortList(listNode);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution17 {
    public ListNode sortList(ListNode head) {
        // 使用list
        List<ListNode> list = new ArrayList<>();

        final ListNode[] cur = {head};
        while (cur[0] != null) {
            list.add(cur[0]);
            cur[0] = cur[0].next;
        }
        ListNode dummy = new ListNode(0);

        cur[0] = dummy;
        list.sort(Comparator.comparingInt(o -> o.val));

        for (ListNode node : list) {
            cur[0].next = node;
            cur[0] = cur[0].next;
        }
        cur[0].next = null;
        return dummy.next;
    }
}