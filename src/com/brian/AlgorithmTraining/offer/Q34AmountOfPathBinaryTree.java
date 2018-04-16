package com.brian.AlgorithmTraining.offer;

import java.util.ArrayList;
import java.util.List;

public class Q34AmountOfPathBinaryTree {
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

        find(t1, 11);
    }

    public static void find(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        findPath(root, 0, target, new ArrayList<Integer>());
    }

    public static void findPath(TreeNode root, int count, int target, List<Integer> list) {
        if (root == null) {
            return;
        }

        count += root.val;
        list.add(root.val);

        if (count == target) {
            if (root.left == null && root.right == null) {
                System.out.println(list.toString());
            }
        }

        if (count < target) {
            findPath(root.left, count, target, list);
            findPath(root.right, count, target, list);
        }

        list.remove(list.size() - 1);
    }
}
