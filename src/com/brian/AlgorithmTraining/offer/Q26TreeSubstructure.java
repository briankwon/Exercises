package com.brian.AlgorithmTraining.offer;

public class Q26TreeSubstructure {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isSubTree(Node t1, Node t2) {
        String s1 = serialize(t1);
        String s2 = serialize(t2);
        return getIndexOf(s1, s2) != -1;
    }

    public static int getIndexOf(String s1, String s2) {

        return 1;
    }

    public static String serialize(Node head) {
        if (head == null) {
            return "#!";
        }

        String res = head.value + "!";
        res += serialize(head.left);
        res += serialize(head.right);

        return res;
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

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(serialize(t1));

        System.out.println(isSubTree(t1, t2));
    }
}
