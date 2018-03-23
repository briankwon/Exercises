package com.brian.AlgorithmTraining.offer;

import java.util.*;

public class Q38PermutationII {
    public static void main(String[] args) {
        String str = "abb";
        List<List<Character>> res = subsets(str);
        for (List<Character> list : res) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Character>> subsets(String str) {
        List<List<Character>> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        helper(new ArrayList<Character>(), chars, 0, res);
        return res;
    }

    public static void helper(List<Character> subset, char[] chars, int start, List<List<Character>> res) {
        res.add(new ArrayList<Character>(subset));

        for (int i = start; i < chars.length; i++) {
            if (i != start && chars[i] == chars[i - 1]) {
                continue;
            }

            subset.add(chars[i]);
            helper(subset, chars, i + 1, res);
            subset.remove(subset.size() - 1);
        }
    }
}
