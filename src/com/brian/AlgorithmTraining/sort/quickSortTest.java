package com.brian.AlgorithmTraining.sort;

public class quickSortTest {
    public static void sort(int[] arr, int L, int R) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (L < R) {
            swap(arr, R, L + (int) Math.random() * (R - L + 1));
            int[] p = partition(arr, L, R);
            sort(arr, L, --p[0]);
            sort(arr, ++p[1], R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int leftIndex = L - 1;
        int rightIndex = R;

        while (L < rightIndex) {
            if (arr[L] < arr[R]) {
                swap(arr, L++, ++leftIndex);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --rightIndex);
            } else {
                L++;
            }
        }

        swap(arr, rightIndex, R);
        return new int[] {leftIndex + 1, rightIndex};
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {43,5,345,6,367,546,745,68,34567,245,6213,512,34,324};
        sort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(" " + num);
        }
    }
}
