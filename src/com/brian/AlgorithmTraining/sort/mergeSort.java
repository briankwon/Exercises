package com.brian.AlgorithmTraining.sort;

public class mergeSort {
    public static void sort(int[] arr, int L, int R, int[] result) {
        if (L == R) {
            return;
        }

        int M = L + (R - L) / 2;
        sort(arr, L, M, result);
        sort(arr, M + 1, R, result);
        merge(arr, L, M, R, result);
    }

    public static void merge(int[] arr, int L, int M, int R, int[] result) {
        int i = L;
        int j = M + 1;
        int index = L;

        while (i <= M && j <= R) {
            //加上=变成稳定排序
            if (arr[i] < arr[j]) {
                result[index++] = arr[i++];
            } else {
                result[index++] = arr[j++];
            }
        }

        while (i <= M) {
            result[index++] = arr[i++];
        }

        while (j <= R) {
            result[index++] = arr[j++];
        }

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
