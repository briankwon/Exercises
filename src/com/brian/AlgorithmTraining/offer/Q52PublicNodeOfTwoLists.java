package com.brian.AlgorithmTraining.offer;

import com.brian.AlgorithmTraining.others.ListNode;

public class Q52PublicNodeOfTwoLists {
    public ListNode find(ListNode first, ListNode second) {
        if (first == null || second == null) {
            return null;
        }

        int len1 = getLength(first);
        int len2 = getLength(second);
        int diff = Math.abs(len1 - len2);

        ListNode longNode = first;
        ListNode shortNode = second;

        if (len1 < len2) {
            longNode = second;
            shortNode = first;
        }

        //长的链表先往前走diff个节点
        for (int i = 0; i < diff; i++) {
            longNode = longNode.next;
        }

        while (longNode != null && shortNode != null) {
            if (longNode == shortNode) {
                return longNode;
            }

            longNode = longNode.next;
            shortNode = shortNode.next;
        }

        return null;
    }

    public int getLength(ListNode node) {
        int len = 1;
        ListNode temp = node;

        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }
}

