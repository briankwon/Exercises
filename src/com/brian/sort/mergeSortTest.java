package com.brian.sort;

public class mergeSortTest {
    public static void sort(int[] arr, int L, int R, int[] result) {
        //递归的出口：当L和R相遇时，退出递归
        if (L == R) {
            return;
        }
        //注意这里是(R-L)
        int M = L + (R - L) / 2;
        sort(arr, L, M, result);
        sort(arr, M + 1, R, result);
        merge(arr, L, M, R, result);
    }

    public static void merge(int[] arr, int L, int M, int R, int[] result) {
        int i = L, j = M + 1;
        int index = L;

        while (i <= M && j <= R) {
            if (arr[i] <= arr[j]) {
                result[index++] = arr[i++];
            } else {
                result[index++] = arr[j++];
            }
        }

        //左右两边一定又一遍遍历完
        while (i <= M) {
            result[index++] = arr[i++];
        }
        while (j <= R) {
            result[index++] = arr[j++];
        }
        //将result数组中同位置上的数字拷贝到原数组中
        for (int k = L; k <= R; k++) {
            arr[k] = result[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1234,2345,3456,34,53,24,12,4,231,4123,6,5,67,576,54,67};
        int[] result = new int[arr.length];
        sort(arr, 0, arr.length - 1, result);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
