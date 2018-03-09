package com.brian.AlgorithmTraining.others;

public class quickSortLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(1);

        /*ListNode p = l1;
        System.out.println(p.equals(head));
        System.out.println(p == head);*/

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        ListNode p = head;
        while (p.next != null) {
            System.out.print(p.val);
            p = p.next;
        }
        System.out.print(p.val);
        System.out.println();

        ListNode begin = head, end = p;
        quickSort(begin, end);

        p = head;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }

    /**
     * 第一个节点为pivot
     * 创建两个指针p q，p指向头结点，q指向头结点的下一个节点
     * 遍历q，如果发现q.val < pivot，那么将p = p.next，并交换p和q的值，q遍历到end位置（end最开始为链表的尾节点）
     * 将头结点和p的val交换，实现将pivot放在中间，之后分别递归左右部分。
     * @param start
     * @param end
     */
    private static void quickSort(ListNode start, ListNode end) {
        //递归的出口：start = end时，前面两个是
        if (start == null || end == null || start == end) {
            return;
        }

        ListNode first = start;
        ListNode second = start.next;
        int mid = start.val;

        //防止越界，second只能到end为止，end之后是另一个递归
        while (second != end.next && second != null) {
            if (second.val < mid) {
                first = first.next;

                if (first != second) {
                    int temp = first.val;
                    first.val = second.val;
                    second.val = temp;
                }
            }
            //second向后移动
            second = second.next;
        }

        //将pivot换到中间(first的位置)，但是当start = first时不用换
        if (start != first) {
            int temp = first.val;
            first.val = start.val;
            start.val = temp;
        }

        //递归前后排序
        quickSort(start, first);
        quickSort(first.next, end);
    }
}



















