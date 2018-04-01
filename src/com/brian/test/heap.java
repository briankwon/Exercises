package com.brian.test;

import java.util.*;

public class heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = new Random().nextInt(15);
            pq.add(arr[i]);
            System.out.print(arr[i] + " ");
        }

        Map<Integer, Integer> map = new HashMap<>();
        int k = 0;
        int count = 0;
        for (int i = 0; i < 15; i++) {
            int num = pq.poll();
            if (i == 7) {
                k = num;
                while (num != 0) {
                    //if (pq.poll() == )
                }
            }
        }
    }
}
