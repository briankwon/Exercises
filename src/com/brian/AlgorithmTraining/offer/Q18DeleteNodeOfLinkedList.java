package com.brian.AlgorithmTraining.offer;

/**
 * 在O(1)的时间内删除链表中的一个节点
 * 删除的时候将当前节点的val和next都换成next节点的val和next
 */
public class Q18DeleteNodeOfLinkedList {
    public static void main(String[] args) {

    }

    private static void delete(LNode head, LNode node) {
        if (head == null || node == null) {
            return;
        }

        //要删除的不是尾节点，将当前节点的值设置为下一个节点的值，让当前节点指向下一个节点的下一个节点
        if (node.next != null) {
            LNode next = node.next;
            node.next = next.next;
            node.val = next.val;
        } else {//是尾节点，需要找到node的前一个节点，设置它的next为node的next
            LNode pre = head;

            while (pre.next != node) {
                pre = pre.next;
            }

            pre.next = node.next;
        }
    }
}
