package com.brian.AlgorithmTraining.offer;

import java.util.Stack;

public class Q06printListReversely {
    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        process(l1);
    }

    private static void process(ListNode head) {
        if (head == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();

        //当节点不为空，入栈，head = head.next
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }
}
