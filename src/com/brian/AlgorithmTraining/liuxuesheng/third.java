//package com.brian.AlgorithmTraining.liuxuesheng;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.*;
//
//public class third {
//    public static void main(String[] args) {
////        int[] nums = {1,2,3,3,5};
////        List<List<Integer>> results = subsets(nums, 3);
////        System.out.println(results.toString());
//
//
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int[] netWeight = new int[n];
////            int n = 4;
////            int[] netWeight = {20,15,17,10};
//            int count = 0;
//            int a =  n / 2;
//            int b = n - a;
//
//            for (int i = 0; i < n; i++) {
//                netWeight[i] = sc.nextInt();
//                count += netWeight[i];
//            }
//
//            //System.out.println("count = " + count);
//
//            List<List<Integer>> results = subsets(netWeight, a);
//            //System.out.println(results.toString());
//            Map<Integer, struct> map = new TreeMap<>();
//            int min = Integer.MAX_VALUE;
//
//            for (List<Integer> list : results) {
//                int aCount = 0;
//
//                for (Integer integer : list) {
//                    aCount += integer;
//                }
//
//                int bCount = count - aCount;
//
//                //System.out.println(aCount + " " + bCount);
//
//                int diff = Math.abs(aCount - bCount);
//
//                if (diff < min) {
//                    min = diff;
//                }
//
//                map.put(diff, (new struct(aCount, bCount)));
//            }
//
//            if (map.get(min).a > map.get(min).b) {
//                System.out.println(map.get(min).b + " " + map.get(min).a);
//            } else {
//                System.out.println(map.get(min).a + " " + map.get(min).b);
//            }
//
//        }
//    }
//
//    public static List<List<Integer>> subsets(int[] nums, int limit) {
//        List<List<Integer>> results = new ArrayList<>();
//
//        if (nums == null) {
//            return results;
//        }
//
//        if (nums.length == 0) {
//            results.add(new ArrayList<Integer>());
//            return results;
//        }
//
//        Arrays.sort(nums);
//        helper(nums, new ArrayList<Integer>(), 0, results, limit);
//        return results;
//    }
//
//    public static void helper(int[] nums, ArrayList<Integer> subset, int startIndex, List<List<Integer>> results, int limit) {
//        if (subset.size() == limit) {
//            results.add(new ArrayList<Integer>(subset));
//            return;
//        }
//
//        for (int i = startIndex; i < nums.length; i++) {
//            if (i != startIndex && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            subset.add(nums[i]);
//            helper(nums, subset, i + 1, results, limit);
//            subset.remove(subset.size() - 1);
//        }
//    }
//}
//
//class struct {
//    int a;
//    int b;
//
//    public struct(int a, int b) {
//        this.a = a;
//        this.b = b;
//    }
//}
