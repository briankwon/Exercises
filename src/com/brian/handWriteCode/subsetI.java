package com.brian.handWriteCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetI {
    public static List<List<Integer>> process(int[] arr) {
        List<List<Integer>> results = new ArrayList<>();

        if (arr == null) {
            return results;
        }

        if (arr.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(arr);
        helper(new ArrayList<Integer>(), results, 0, arr);
        return results;
    }

    //在arr中寻找所有以subset开头的子集，并放到results里面
    public static void helper(List<Integer> subset,
                              List<List<Integer>> results,
                              int startIndex,
                              int[] arr) {
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < arr.length; i++) {
//            if (i != startIndex && arr[i] == arr[i - 1]) {
//                continue;
//            }
            subset.add(arr[i]);
            helper(subset, results, i + 1, arr);
            subset.remove(subset.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(process(arr));
    }
}
