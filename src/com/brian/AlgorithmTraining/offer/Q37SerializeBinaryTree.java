package com.brian.AlgorithmTraining.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q37SerializeBinaryTree {
    private static String[] strs;
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serialize(Node head) {
//        if (head == null) {
//            return "#,";
//        }
//
//        String res = head.value + ",";
//        res += serialize(head.left);
//        res += serialize(head.right);
//        return res;

        if (head == null) {
            return "#";
        }

        return head.value + "," + serialize(head.left) + "," + serialize(head.right);
    }

    public static Node preDe(String s) {
        String[] strs = s.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s1 : strs) {
            queue.offer(s1);
        }
        return deserilize(queue);
    }

    //整体上是先构造头结点，再构造左子树，再构造右子树，#标志着一个子树的结束
    //[头结点 | 左子树 # | 右子树 #]
    //利用queue先进先出的特性，一个用过的元素就直接出队列了，剩下的就是左子树/右子树
    public static Node deserilize(Queue<String> queue) {
        String value = queue.poll();

        if (value.equals("#")) {
            return null;
        }

        Node head = new Node(Integer.valueOf(value));
        head.left = deserilize(queue);
        head.right = deserilize(queue);
        return head;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        String s = serialize(t1);
        System.out.println(s);

        pre(preDe(s));
        level(t1);
    }

    public static void pre(Node head) {
        if (head == null) {
            return;
        }

        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    public static void level(Node head) {
        if (head == null) {
            return;
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size > 0) {
                head = queue.poll();
                size--;
                list.add(head.value);

                if (head.left != null) {
                    queue.offer(head.left);
                }

                if (head.right != null) {
                    queue.offer(head.right);
                }
            }

            res.add(list);
        }

        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }
}
