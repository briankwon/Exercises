package com.brian.AlgorithmTraining.offer;

public class Q11MinNumInRotateAray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,2,3};
        System.out.println(process(arr));

    }

    private static int process(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        if (arr[start] < arr[end]) {
            return arr[start];
        }

        while (arr[start] >= arr[end]) {
            if (end - start == 1) {
                return arr[end];
            }

            int mid = start + (end - start) / 2;

            //如果中间的元素和左右指针指向的元素相同只能在这个区间内顺序查找最小元素的位置
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                return inorderSearch(arr, start, end);
            }

            if (arr[mid] >= arr[start]) {
                start = mid;
            }

            if (arr[mid] <= arr[end]) {
                end = mid;
            }
        }

        return -1;
    }

    private static int inorderSearch(int[] arr, int start, int end) {
        int res = arr[start];

        for (int i = start + 1; i <= end; i++) {
            //第一个小于start上元素的元素一定是右边的递增序列的第一个值，也就是整个数组中的最小值
            if (res > arr[i]) {
                res = arr[i];
                break;
            }
        }

        return res;
    }
}
