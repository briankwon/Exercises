package com.brian.AlgorithmTraining.offer;

import com.brian.AlgorithmTraining.others.ListNode;

/**
 * 如图中所示，设链起点到环入口点间的距离为x，环入口点到问题1中fast与low重合点的距离为y，
 * 又设在fast与low重合时fast已绕环n周（n>0），且此时low移动总长度为s，则fast移动总长度为2s，环的长度为r。
 * 则:
 s + nr = 2s,n>0      ①
 s = x + y            ②
 由①式得  s = nr
 代入②式得
 nr = x + y
 x = nr - y           ③
 现让一指针p1从链表起点处开始遍历，指针p2从encounter处开始遍历，且p1和p2移动步长均为1。
 则当p1移动x步即到达环的入口点，由③式可知，此时p2也已移动x步即nr - y步。
 由于p2是从encounter处开始移动，故p2移动nr步是移回到了encounter处，再退y步则是到了环的入口点。
 也即，当p1移动x步第一次到达环的入口点时，p2也恰好到达了该入口点。
 */
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
