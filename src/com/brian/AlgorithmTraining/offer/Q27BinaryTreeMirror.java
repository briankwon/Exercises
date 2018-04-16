package com.brian.AlgorithmTraining.offer;

public class Q27BinaryTreeMirror {
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

        Q32PrintBinaryTreeTopToBottom.level(t1);
        mirror(t1);
        Q32PrintBinaryTreeTopToBottom.level(t1);

    }

    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //if (root.left != null) {
            mirror(root.left);
        //}

        //if (root.right != null) {
            mirror(root.right);
        //}
    }

}
