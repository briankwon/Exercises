package com.brian.lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by briankwon on 2017/4/28.
 */
public class subsetII {
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
    public static void main(String[] args) {
        int[] data = {1,2,2};
        System.out.println(subsets(data));
    }
}