package com.brian.AlgorithmTraining.sort;

public class selectionSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            //注意是 i，这里老错
            int minPoint = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPoint] > arr[j]) {
                    minPoint = j;
                }
            }
            swap(arr, minPoint, i);
        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,7,4,7,8,2,2,56,67,456,1,1,546,7,9,4,3};
        sort(arr);
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}
