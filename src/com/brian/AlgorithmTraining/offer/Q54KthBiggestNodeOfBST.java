package com.brian.AlgorithmTraining.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q54KthBiggestNodeOfBST {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(12);
        t1.left.left = new TreeNode(2);
        t1.left.right = new TreeNode(6);
        t1.right.left = new TreeNode(10);
        t1.right.right = new TreeNode(14);
        t1.left.left.left = new TreeNode(1);
        t1.left.left.right = new TreeNode(3);

        System.out.println(search(t1, 3));
    }

    public static int search(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1).val;
    }

    public static void inorder(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root);
                root = root.right;
            }
        }
    }
}
