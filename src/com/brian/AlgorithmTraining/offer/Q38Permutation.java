package com.brian.AlgorithmTraining.offer;

import java.util.TreeSet;

public class Q38Permutation {
    public static void main(String[] args) {
        String str = "abc";
        TreeSet<String> set = permutation(str);
        for (String s : set) {
            System.out.println(s);
        }
    }

    public static TreeSet<String> permutation(String str) {
        TreeSet<String> res  = new TreeSet<>();
        if (str == null || str.length() == 0) {
            return res;
        }

        char[] chars = str.toCharArray();
        TreeSet<String> set = new TreeSet<>();
        helper(chars, 0, set);
        return set;
    }

    public static void helper(char[] chars, int start, TreeSet<String> set) {
        if (chars == null || chars.length == 0 || start < 0 || start > chars.length - 1) {
            return;
        }

        if (start == chars.length - 1) {
            set.add(String.valueOf(chars));
        } else {
            for (int i = start; i < chars.length; i++) {
                swap(chars, start, i);
                helper(chars, start + 1, set);
                swap(chars, start, i);
            }
        }
    }

    public static void swap(char[] chars, int a ,int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
