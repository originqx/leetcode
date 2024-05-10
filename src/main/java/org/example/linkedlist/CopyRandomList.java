package org.example.linkedlist;

import jdk.nashorn.internal.ir.ReturnNode;

public class CopyRandomList {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        Node node = new Node(1);
        node.next = new Node(2);
        node.random = new Node(3);
        Node result = solution15.copyRandomList(node);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution15 {
    public Node copyRandomList(Node head) {
        // 两次遍历
        if (head == null) {
            return null;
        }
        // 第一次遍历：复制每个节点，并插在原节点的后面
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }

        Node newHead = head.next;

        for (Node node = head; node != null; node = node.next) {
            Node newNode = node.next;
            node.next = newNode.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}