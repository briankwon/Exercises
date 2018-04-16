package com.brian.AlgorithmTraining.offer;

public class Q55IsBalancedBinaryTree {
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
        //t1.left.left.right.left = new TreeNode(10);

        System.out.println(isBalanced(t1));
    }

    public static boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getDepth(root, 1, res);
        return res[0];
    }

    public static int getDepth(TreeNode node, int level, boolean[] res) {
        if (node == null) {
            return level;
        }

        int left = getDepth(node.left, level + 1, res);

        if (!res[0]) {
            return level;
        }

        int right = getDepth(node.right, level + 1, res);

        if (!res[0]) {
            return level;
        }

        if (Math.abs(left - right) > 1) {
            res[0] = false;
        }

        return Math.max(left, right);
    }
}
