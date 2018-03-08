package com.brian.AlgorithmTraining.offer;

public class Q03findDuplicateInArray {
    public static void main(String[] args) {
        int[] arr = {2,3,5,4,1,2,3,4,6};
        System.out.println(process(arr));
        System.out.println(process1(arr));
    }

    /**
     * 可以修改原数组
     * 遍历数组，对于在i位置上的数如果等于i继续循环
     * 否则看i位置上的数和arr[i]位置上的数字是否相等，相等说明重复，直接返回
     * 不等的话交换i位置上的数和arr[i]位置上的数字，直到i位置上的数等于i
     * @param arr
     * @return
     */
    private static int process(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    swap(arr, arr[i], arr[arr[i]]);
                }
            }
        }

        return -1;
    }

    /**
     * 禁止修改原数组
     * @param arr
     * @return
     */
    private static int process1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        //这里start是最小值，end为最大值，并不是数组坐标
        int start = 1;
        int end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //得到arr中大小分布在[start, mid]的数字有多少个
            int count = getCount(arr, start, mid);

            //如果大于(mid - start + 1)，说明重复数字的大小在[start,mid]之间
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        //根据我们的while循环最终start和end不会重合，分别计算arr中大小为start和end的数字有多少个，大于1说明是有重复的
        int count1 = getCount(arr, start, start);
        int count2 = getCount(arr, end, end);

        if (count1 > 1) {
            return start;
        }

        if (count2 > 1) {
            return end;
        }

        return -1;
    }

    private static int getCount(int[] arr, int start, int end) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }

        return count;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
