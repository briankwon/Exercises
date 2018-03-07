package com.brian.AlgorithmTraining.sort;

public class mergeSortTest {
    private static void sort(int[] arr, int L, int R) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (L == R) {
            return;
        }

        int M = L + (R - L) / 2;
        sort(arr, L, M);
        sort(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] cache = new int[R - L + 1];
        int index = 0;
        int i = L;
        int j = M + 1;

        while (i <= M && j <= R) {
            if (arr[i] <= arr[j]) {
                cache[index++] = arr[i++];
            } else {
                cache[index++] = arr[j++];
            }
        }

        while (i <= M) {
            cache[index++] = arr[i++];
        }

        while (j <= R) {
            cache[index++] = arr[j++];
        }

        for (int k = 0; k < cache.length; k++) {
            arr[L + k] = cache[k];
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
