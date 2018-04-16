package com.brian.AlgorithmTraining.offer;

public class Q68LowestCommanAncestorI {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
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

        System.out.println(getLCA(t1, t1.left.left.right, t1.left.right.left).value);
    }

    // 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null
    public static Node getLCA(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        //divide
        Node left = getLCA(root.left, p, q);
        Node right = getLCA(root.right, p, q);

        //conquer
        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right!= null) {
            return right;
        }

        return null;
    }
}
