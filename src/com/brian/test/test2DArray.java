package com.brian.test;

import java.util.*;

public class test2DArray {
    private static int[][] v = {{1,1},{2,2},{1,2}};
    public static void main (String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int width = 2;
        int height = 3;
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < width; i++) {
            int j;
            for (j = 0; j < height; j++) {
                if (map.containsKey(v[j][i])) {
                    System.out.println(v[j][i]);
                } else {
                    map.put(v[j][i], 1);
                    System.out.println(v[j][i]);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                ans.add(entry.getKey());
            }
        }


        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        for (int i : answer) {
            System.out.println(i);
        }

    }
}
