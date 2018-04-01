package com.brian.AlgorithmTraining.liuxuesheng;

import java.util.*;

public class third2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] netWeight = new int[n];
            //int n = 4;
            //int[] netWeight = {20,15,17,10};
            int count = 0;
            int a =  n / 2;
            int b = n - a;

            for (int i = 0; i < n; i++) {
                netWeight[i] = sc.nextInt();
                count += netWeight[i];
            }

            Map<Integer, struct> results = subsets(netWeight, a, count);
            for (Map.Entry<Integer, struct> entry : results.entrySet()) {
                if (entry.getValue().a > entry.getValue().b) {
                    System.out.println(entry.getValue().b + " " + entry.getValue().a);
                } else {
                    System.out.println(entry.getValue().a + " " + entry.getValue().b);
                }
                break;
            }

        }
    }

    public static Map<Integer, struct> subsets(int[] nums, int limit, int inCount) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, struct> map = new TreeMap<>();
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), 0, results, limit, inCount, map);
        return map;
    }

    public static void helper(int[] nums, ArrayList<Integer> subset, int startIndex, List<List<Integer>> results, int limit, int inCount, Map<Integer, struct> inMap) {
        if (subset.size() == limit) {
            int aCount = 0;
            int min = Integer.MAX_VALUE;

            for (Integer integer : subset) {
                aCount += integer;
            }

            int bCount = inCount - aCount;

            int diff = Math.abs(aCount - bCount);

            if (diff < min) {
                min = diff;
            }

            inMap.put(diff, (new struct(aCount, bCount)));

            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, subset, i + 1, results, limit, inCount, inMap);
            subset.remove(subset.size() - 1);
        }
    }
}

class struct {
    int a;
    int b;

    public struct(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
