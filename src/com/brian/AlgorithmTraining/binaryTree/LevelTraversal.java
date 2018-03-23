package com.brian.AlgorithmTraining.binaryTree;

import com.brian.AlgorithmTraining.IV.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        level(head);
    }

    public static void level(TreeNode root) {
        if (root == null) {
            return;
        }

        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();

            while (len > 0) {
                root = queue.poll();
                len--;
                list.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            results.add(list);
        }

        for (List<Integer> list : results) {
            System.out.println(list.toString());
        }
    }
}
