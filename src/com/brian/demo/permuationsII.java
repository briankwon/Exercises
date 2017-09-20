package com.brian.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by briankwon on 2017/7/10.
 */
public class permuationsII {
    public static List<List<Integer>> permuteUniqueDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), new int[nums.length], results);
        return results;
    }

    public static void helper(int[] nums, ArrayList<Integer> list, int[] visited, List<List<Integer>> results) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 ||(i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            helper(nums, list, visited, results);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUniqueDup(new int[] {1,2,2}));
    }
}
