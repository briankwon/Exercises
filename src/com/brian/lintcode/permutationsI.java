package com.brian.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by briankwon on 2017/7/10.
 */
public class permutationsI {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), results);
        return results;
    }

    public static void helper(int[] nums, ArrayList<Integer> list, List<List<Integer>> results) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, list, results);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[] {1,2,3}));
    }
}
