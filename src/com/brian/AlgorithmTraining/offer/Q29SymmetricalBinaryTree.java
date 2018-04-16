package com.brian.AlgorithmTraining.offer;

public class Q29SymmetricalBinaryTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);
        t1.left.left.right = new TreeNode(8);
        t1.left.right.left = new TreeNode(9);

        System.out.println(isSymmetrical(t1));
    }

    public static boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetrical(root.left, root.right);
    }

    public static boolean isSymmetrical(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSymmetrical(p.left, q.right) && isSymmetrical(p.right, q.left);
    }
}
