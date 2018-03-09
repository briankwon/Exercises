package com.brian.AlgorithmTraining.offer;

import com.brian.AlgorithmTraining.others.ListNode;

public class Q24ReverseLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 当反转的时候需要将当前节点node的next指向它的前一个节点pre，再将pre和node后移一个
     * 但是当node的next指向pre后，将无法通过node.next获得next，因此需要变量next临时存放node.next
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        ListNode pre = null;
        ListNode next = null;

        while (node != null) {
            next = node.next;

            //当next到达null时说明node到链表的尾巴了
            if (next == null) {
                return node;
            }

            node.next = pre;
            pre = node;
            node = next;
        }

        return null;
    }
}
