package com.brian.sort;

//originates from mergeSort
public class smallSum {
    public static int sort(int[] arr, int L, int R, int[] result) {
        if (L == R) {
            return 0;
        }

        int M = L + (R - L) / 2;
        return sort(arr, L, M, result) +
                sort(arr, M + 1, R, result) +
                merge(arr, L, M, R, result);
    }

    public static int merge(int[] arr, int L, int M, int R, int[] result) {
        int i = L;
        int j = M + 1;
        int index = L;
        int res = 0;

        while (i <= M && j <= R) {
            if (arr[i] < arr[j]) {
                res += arr[i] * (R - j + 1);
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

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1234,2345,3456,34,53,24,12,4,231,4123,6,5,67,576,54,67};
        int[] result = new int[arr.length];
        int res;
        res = sort(arr, 0, arr.length - 1, result);
        System.out.println(res);
    }
}
