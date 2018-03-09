package com.brian.AlgorithmTraining.offer;

public class Test57 {
    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    private static ListNode delete(ListNode head) {
        if (head == null) {
            return null;
        }

        //临时节点
        ListNode root = new ListNode();
        root.next = head;
        //前驱结点，最开始和root指向同一个node，和root指向的内存地址一样
        ListNode pre = root;
        //当前节点
        ListNode node = head;

        //当node和node.next不为空
        while (node != null && node.next != null) {
            //有重复节点
            if (node.val == node.next.val) {
                //找到最后一个和node重复的节点，并赋值给node
                //    0    ->    1   ->2->3->3->4->4->5
                //root/pre   head/node
                //pre和node都向后移
                //    0    ->    1    >2   ->3->3->4->4->5
                //  root        pre  node
                //pre和node都向后移
                //    0    ->    1      ->2   ->3->   3->4->4->5
                //  root                 pre  node
                //node向后移
                //    0    ->    1      ->2   ->3->  3   ->4->4->5
                //  root                 pre        node
                //这时出while循环，pre.next指向node（最后一个重复元素，这里是3）的next（也就是4）
                //node变成node.next，因此链表相当于变成了
                //    0    ->    1      ->2  ->   4    ->4->5
                //  root                 pre     node
                while (node.next != null && node.next.val == node.val) {
                    node = node.next;
                }
                //pre的next指向最后一个重复元素的next
                //如果此时root和pre指向同一个node的话，node.text也一起更改，保证最后返回root.next时一定能返回头结点
                //node赋值为最后一个重复元素的next
                pre.next = node.next;
                node = node.next;
            } else {
                //node和node.next的val不同，pre和node都向后走一个
                pre = pre.next;
                node = node.next;
            }
        }

        return root.next;
    }

    private static ListNode deleteDuplication(ListNode head) {
        // 为null
        if (head == null) {
            return null;
        }

//        // 只有一个结点
//        if (head.next == null) {
//            return head;
//        }

        // 临时的头结点
        ListNode root = new ListNode();
        root.next = head;
        // 记录前驱结点
        ListNode prev = root;
        // 记录当前处理的结点
        ListNode node = head;
        while (node != null && node.next != null) {
            // 有重复结点，与node值相同的结点都要删除
            if (node.val == node.next.val) {
                // 找到下一个不同值的节点，注意其有可能也是重复节点
                while (node.next != null && node.next.val == node.val) {
                    node = node.next;
                }
                // 指向下一个节点，prev.next也可能是重复结点
                // 所以prev不要移动到下一个结点
                // 对于1->1->1->2
                // 一开始root = prev，root和prev指向的是一个node，所以变更prev.next后root.next会一起变化，
                prev.next = node.next;
            }
            // 相邻两个值不同，说明node不可删除，要保留
            else {
                //prev.next = node;
                //这个时候root和prev就不是一个node了
                prev = prev.next;

            }
            node = node.next;
        }

        return root.next;

    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
//        test07();
//        test08();
//        test09();
//        test10();
    }

    // 1->2->3->3->4->4->5
    private static void test01() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->2->3->4->5->6->7
    private static void test02() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->1->1->1->1->1->2
    private static void test03() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }


    // 1->1->1->1->1->1->1
    private static void test04() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->1->2->2->3->3->4->4
    private static void test05() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->1->2->3->3->4->5->5
    private static void test06() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->1->2->2->3->3->4->5->5
    private static void test07() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(5);
        ListNode n9 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->2
    private static void test08() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1
    private static void test09() {
        ListNode n1 = new ListNode(1);
        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // null
    private static void test10() {
        ListNode result = deleteDuplication(null);
        print(result);
    }
}
