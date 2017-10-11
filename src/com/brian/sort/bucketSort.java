package com.brian.sort;

import java.util.ArrayList;

public class bucketSort {
    private static String sort(int[] arr, int step) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        int bucketCount = (max - min) / step + 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(bucketCount);

        //初始化结果list
        for (int i = 0; i < bucketCount; i++) {
            result.add(new ArrayList<Integer>());
        }

        int start;
        int end;
        int mid;
        int pos;
        //将arr中的每个元素放入对应的桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] - min ) / step;

            //如果桶是空的直接添加元素
            ArrayList<Integer> bucket = result.get(index);
            if (bucket.size() == 0) {
                bucket.add(arr[i]);
                continue;
            }

            //在桶中二分查找arr[i]应该插入的位置
            start = 0;
            end = bucket.size() - 1;

            while (start + 1 < end) {
                mid = start + (end - start) / 2;

                if (bucket.get(mid) > arr[i]) {
                    end = mid;
                } else if (bucket.get(mid) < arr[i]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            if (bucket.get(end) <= arr[i]) {
                pos = end + 1;
            } else if (bucket.get(start) >= arr[i]){
                pos = start;
            } else {
                pos = end;
            }

            bucket.add(pos, arr[i]);
        }

        return result.toString();
        //将每个桶排序


//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < arr.length; i++) {
//            max = Math.max(arr[i], max);
//            min = Math.min(arr[i], min);
//        }
//
//        // + 1 是考虑到边界条件，假如arr中有100个元素，step设置为5，arr[99] = 100
//        int bucketCount = (max - min) / step + 1;
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>(bucketCount);
//
//        for (int i = 0; i < bucketCount; i++) {
//            result.add(new ArrayList<Integer>());
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            int index = (arr[i] - min) / step;
//            result.get(index).add(arr[i]);
//        }
//
//        for (int i = 0; i < result.size(); i++) {
//            Collections.sort(result.get(i));
//        }

//        Iterator<ArrayList<Integer>> iterator = result.iterator();
//        while (iterator.hasNext()) {
//            Iterator<Integer> iterator1 = iterator.next().iterator();
//            while (iterator1.hasNext()) {
//                System.out.println(iterator1.next());
//            }
//        }
//
//        return result.toString();
    }


    public static void main(String[] args) {
        int[] arr = {2,4,77,44,27,84,24,25,14,67,46,11,12,56,76,94,45,43};
        long start = System.nanoTime();
        System.out.println(sort(arr, 10));
        long end = System.nanoTime();
        System.out.println("time = " + (end - start));
    }
}
