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
        //第一次相遇后将快指针指向head，和慢指针一起移动，相遇的点即是入口点
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

    /**
     * 牛客AC方法
     * @param head
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        int R = 1;

        while (slow != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode node = slow;

                //这里一定要有个node临时存相遇点
                while (slow.next != node) {
                    slow = slow.next;
                    R++;
                }

                fast = head;
                slow = head;

                for (int i = 0; i < R; i++) {
                    fast = fast.next;
                }

                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return fast;
            }
        }

        return null;

    }
}
