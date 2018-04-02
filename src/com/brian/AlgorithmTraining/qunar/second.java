package com.brian.AlgorithmTraining.qunar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("good");
            }

            int total = sc.nextInt();
            int[] arr = new int[n];
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            ArrayList<ArrayList<Integer>> results = subsets(arr);
            for (ArrayList<Integer> list : results) {
                int count = 0;
                for (Integer integer : list) {
                    count += integer;
                }
                if (count == total) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("perfect");
            } else {
                System.out.println("good");
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        if (nums == null ) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);

        // 找到[1,2,3]中以空集[]开头的所有集合，并放到results里面
        helper (new ArrayList<Integer>(), nums, 0, results);
        return results;
    }
    // 1.递归的定义： 在nums中找到所有以subset开头的集合，并放到results里
    private static void helper (ArrayList<Integer> subset,
                                int[] nums,
                                int startindex,
                                ArrayList<ArrayList<Integer>> results) {
        // 2.递归的拆解
        // deep copy
        results.add(new ArrayList<Integer>(subset));
        for (int i = startindex; i < nums.length; i++) {
            // 防止 i - 1越界，所以i != startIndex
            if (i != startindex && (nums[i] == nums[i - 1])) {
                continue;
            }
            subset.add(nums[i]);
            helper(subset, nums, i + 1, results);
            subset.remove(subset.size() - 1);
        }
        // 3.递归的出口
    }
}
