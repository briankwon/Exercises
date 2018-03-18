package com.brian.AlgorithmTraining.nowcoder;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class overseas02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] p = new int[n];

        while (sc.hasNext()) {
            String cache = sc.nextLine();
            String str = sc.nextLine();
            String[] nums = str.split(" ");

            for (int i = 0; i < nums.length; i++) {
                p[i] = Integer.parseInt(nums[i]);
            }

            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }

            });

            for (int num : p) {
                maxHeap.add(num);
            }

            int res = 0;
            int count = 0;
            boolean out = false;

            while (!maxHeap.isEmpty() && out == false) {
                int top = maxHeap.poll();
                res += top;
                count++;

                if (res >= s) {
                    System.out.println(count);
                    out = true;
                }
            }
        }
    }
}
