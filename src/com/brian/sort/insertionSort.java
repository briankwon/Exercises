package com.brian.sort;

public class insertionSort extends sortBase{
    private static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("parameter error.");
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j , j - 1);
                } else {
                    break;
                }
            }
        }
        for (int x: arr
             ) {
            System.out.println(x + " ");
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        sort(new int[] {4,2,7,3,8,1,5,11,6,77,54,2,7,3,8,1,5,11,6,77,54,2,7,3,8,1,5,11,6,77,54,2,7,3,8,1,5,11,6,77,54,2,7,3,8,1,5,11,6,77,54});
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
