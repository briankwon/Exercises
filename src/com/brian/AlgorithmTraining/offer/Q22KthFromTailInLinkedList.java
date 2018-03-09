package com.brian.AlgorithmTraining.offer;

import com.brian.AlgorithmTraining.others.ListNode;

public class Q22KthFromTailInLinkedList {
    public static void main(String[] args) {

    }

    /**
     * first和second之间的距离为k - 1
     * 当first走到尾节点时second正好走到倒数第k个节点
     * 此时从second到first一共有k个节点，second就是倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    private static int find(ListNode head, int k) {
        if (head == null || k <= 0) {
            return -1;
        }

        ListNode first = head;
        ListNode second = head;

        //first移动k - 1次，到达正数第k个节点
        for (int i = 0; i < k - 1; i++) {
            if (first.next != null) {
                first = first.next;
            } else {
                return -1;
            }
        }

        //此时second指向第一个节点，和first相差k - 1个节点
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second.val;
    }
}
