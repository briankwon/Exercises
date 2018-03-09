package com.brian.AlgorithmTraining.offer;

import com.brian.AlgorithmTraining.others.ListNode;

public class Q23EntranceOfRingInLinkedList {
    public static void main(String[] args) {

    }

    private static int find(ListNode head) {
        if (head == null) {
            return -1;
        }

        ListNode fast = head;
        ListNode slow = head;

        //从表头到入口点的距离，等于从相遇点到入口点的距离。
        //第一次相遇后将快指针指向head，和满指针一起移动，相遇的点即是入口点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //第一次相遇
            if (fast == slow) {
                fast = head;

                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return fast.val;
            }
        }

        return -1;
    }
}
