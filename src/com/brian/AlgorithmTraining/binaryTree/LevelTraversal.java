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

        List<Integer> res = new ArrayList<>();
        getLeafNodes(head, res);
        System.out.println(res);
        //levelTravse(head);
    }

    public static boolean TreeEquals(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }

        List<Integer> la = new ArrayList<>();
        getLeafNodes(a, la);

        return true;
    }

    public static void getLeafNodes(TreeNode root, List<Integer> res) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }

        if (root.left != null) {
            getLeafNodes(root.left, res);
        }

        if (root.right != null) {
            getLeafNodes(root.right, res);
        }
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

    //practice
    public static void levelTravse(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //每次遍历一层，用len表示一层的节点数量
            int len = queue.size();
            List<Integer> list = new ArrayList<>();

            //弹出队列的同时加入每一层的结果list，同时将弹出节点的左右节点依次放入队列
            while (len > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                len--;
            }

            results.add(list);
        }

        for (List<Integer> list : results) {
            System.out.println(list.toString());
        }
    }
}
