package com.brian.AlgorithmTraining.sort;

public class mergeSortTest {
    public static void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int M = L + (R - L) / 2;
        sort(arr, L, M);
        sort(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int i = L;
        int j = M + 1;
        int index = 0;
        int[] result = new int[R - L + 1];

        while (i <= M && j <= R) {
            if (arr[i] <= arr[j]) {
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

        for (int k = 0; k < result.length; k++) {
            arr[L + k] = result[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1234,2345,3456,34,53,24,12,4,231,4123,6,5,67,576,54,67};
        sort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
