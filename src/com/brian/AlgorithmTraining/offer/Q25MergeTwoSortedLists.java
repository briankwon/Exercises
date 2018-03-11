package com.brian.AlgorithmTraining.offer;

import com.brian.AlgorithmTraining.others.ListNode;

public class Q25MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null && second == null) {
            return null;
        }

        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        }

        ListNode node = null;

        //得到头部节点
        if (first.val <= second.val) {
            node = first;
            first = first.next;
        } else {
            node = second;
            second = second.next;
        }

        //临时保存头部节点
        ListNode head = node;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                node.next = first;
                node = first;
                first = first.next;
            } else {
                node.next = second;
                node = second;
                second = second.next;
            }
        }

        //当一个链表先遍历完，说明剩下链表里面的元素比已经排序的部分都大，直接连接起已排序链表和剩下的链表就可以了
        if (first == null) {
            node.next = second;
        } else {
            node.next = first;
        }

        return head;
    }
}
