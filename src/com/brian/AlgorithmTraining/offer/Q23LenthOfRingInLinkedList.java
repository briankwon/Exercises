package com.brian.AlgorithmTraining.offer;

import com.brian.AlgorithmTraining.others.ListNode;

public class Q23LenthOfRingInLinkedList {
    public static void main(String[] args) {


    }

    private static int find(ListNode head) {
        if (head == null) {
            return -1;
        }

        ListNode fast = head;
        ListNode slow = head;

        //当快指针和满指针第一次相遇时的点一定是在环中
        //从这个点出发遍历直到它自己走过的长度就是环的长度
        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                int len = 1;
                ListNode meetNode = slow;

                while (slow.next != meetNode) {
                    len++;
                    slow = slow.next;
                }

                return len;
            }
        }

        return -1;
    }
}
