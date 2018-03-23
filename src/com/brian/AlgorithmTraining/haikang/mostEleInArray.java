package com.brian.AlgorithmTraining.haikang;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class mostEleInArray {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new Random().nextInt(100);
            System.out.print(arr[i] + " ");
        }



        for (int n : arr) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        int pos = 0;
        int time = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > time) {
                pos = entry.getKey();
                time = entry.getValue();
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            int key = it.next().getKey();
            int val = it.next().getValue();
        }

        System.out.println(pos + " " + time);
    }
}
