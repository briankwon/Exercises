package com.brian.AlgorithmTraining.lianjia;

import java.util.*;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            //List<Integer> index = new ArrayList<>();
            int[] index = new int[n];
            List<List<Integer>> ref = new ArrayList<>();
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                int key = sc.nextInt();
                //index.add(key);
                index[i] = key;
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < key; j++) {
                    int num = sc.nextInt();
                    temp.add(num);
                    set.add(num);
                }
                ref.add(temp);
            }

//            System.out.println(ref);
//
//            for (int num : index) {
//                System.out.println(num);
//            }

            int num = set.size();
            boolean[] bool = new boolean[num + 1];
            int count = Integer.MIN_VALUE;

            //获取所有index子集
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = i;
            }

            List<List<Integer>> results = subsets(arr);

            results.remove(0);
//            System.out.println(results);

//            for (int i = 0; i < results.size(); i++) {
//                for (int j = 0; j < results.get(i).size(); j++) {
//
//                }
//            }

            for (List<Integer> list : results) {
                int len = list.size();
                for (Integer integerI : list) {
                    for (Integer integerJ : ref.get(integerI)) {
                        bool[integerJ] = !bool[integerJ];
                    }
                }
                //统计count
                int tempCount = 0;
                for (int i = 0; i < bool.length; i++) {
                    if (bool[i]) {
                        tempCount++;
                        bool[i] = false;
                    }
                }
                count = tempCount >= count ? tempCount : count;

            }

            System.out.println(count);

        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

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
    private static void helper (List<Integer> subset,
                                int[] nums,
                                int startindex,
                                List<List<Integer>> results) {
        // 2.递归的拆解
        // deep copy
        results.add(new ArrayList<Integer>(subset));

        for (int i = startindex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(subset, nums, i + 1, results);
            subset.remove(subset.size() - 1);
        }
        // 3.递归的出口
    }
}
