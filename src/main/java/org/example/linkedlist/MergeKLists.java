package org.example.linkedlist;

public class MergeKLists {
    public static void main(String[] args) {
        ListNode node = new Solution19().mergeKLists2(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        });

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}

class Solution19 {

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        /**
         * 1归并排序
         */

        return sortGui(lists, 0, lists.length - 1);
    }

    private ListNode sortGui(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }
        int mid = i + (j - i) / 2;

        ListNode left = sortGui(lists, i, mid);
        ListNode right = sortGui(lists, mid + 1, j);

        return sort(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        /**
         * 2递归，先只排序两个，让后排序剩下的
         */

        return merge(lists, 0, lists.length - 1)[lists.length - 1];
    }

    private ListNode[] merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists;
        }
        ListNode node1 = lists[left];
        ListNode node2 = lists[left + 1];

        ListNode sort = sort(node1, node2);
        lists[left + 1] = sort;
        merge(lists, left + 1, right);
        return lists;
    }

    private ListNode sort(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }

        return dummy.next;
    }
}
