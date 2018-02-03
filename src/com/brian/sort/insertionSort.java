package com.brian.sort;

public class insertionSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("parameter error.");
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int a ,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] arr = new int[] {4,37,3,458,1,25,21,6,77,54,42,7,13,8};
        sort(arr);
        long end = System.nanoTime();
        System.out.println(end - start);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
