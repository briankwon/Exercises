package com.brian.AlgorithmTraining.IV;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static class Node {
        public int c;
        public int p;

        public Node(int c, int p) {
            this.c = c;
            this.p = p;
        }
    }

    public static int invest(int[] cost, int[] profit, int k, int m) {
        Node[] proj = new Node[cost.length];

        for (int i = 0; i < cost.length; i++) {
            proj[i] = new Node(cost[i], profit[i]);
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>(new minNodeComparator());
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new maxNodeComparator());

        for (int i = 0; i < proj.length; i++) {
            minHeap.add(proj[i]);
        }

        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().c <= m) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.isEmpty()) {
                return m;
            }

            m += maxHeap.poll().p;
        }

        return m;
    }

    public static class minNodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class maxNodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static void main(String[] args) {
        int[] cost = {1,2,3,4};
        int[] profit = {2,1,3,4};
        int k = 2;
        int m = 2;
        System.out.println(invest(cost, profit, k, m));
    }
}
