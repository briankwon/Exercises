package com.brian.sort;

public class bubbleSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // i < end 保证了在比较前一个数和后一个数的时候不会越界
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i ,i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("array is null");
            return;
        }

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,7,3,76,2,56,34,68,88,42,32,65,63,6,1,25,5};
        sort(arr);
        printArray(arr);
    }
}
