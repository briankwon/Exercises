package com.brian.sort;

/**
 * 定义局部最小的概念。
 * arr长度为1时，arr[0]是局部最小。
 * arr的长度 为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小;
 * 如果 arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小;
 * 如果0<i<N-1，既有 arr[i]<arr[i-1]，又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等。
 * 写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class seminarIII {
    public static int process(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        if (arr[0] < arr[1]) {
            return arr[0];
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        int start = 0;
        int end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid - 1]) {
                end = mid;
            } else if (arr[mid] > arr[mid + 1]) {
                start = mid;
            } else {
                return arr[mid];
            }
        }

        return arr[start] > arr[end] ? arr[end] : arr[start];
    }


    public static void main(String[] args) {
        int[] arr = {17,16,15,14,13,12,11,3,4,5,16,17};
        System.out.println(process(arr));
    }
}
