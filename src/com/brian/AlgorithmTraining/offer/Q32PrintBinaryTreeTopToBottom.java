package com.brian.AlgorithmTraining.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q32PrintBinaryTreeTopToBottom {
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

    public static void level(TreeNode head) {
        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        List<List<Integer>> results = new ArrayList<>();

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();

            while (len > 0) {
                TreeNode node = queue.poll();
                len--;
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            results.add(list);
        }

        for (List<Integer> list : results) {
            System.out.println(list.toString());
        }
    }
}
