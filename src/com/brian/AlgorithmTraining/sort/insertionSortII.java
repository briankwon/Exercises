package com.brian.AlgorithmTraining.sort;

import java.util.Random;

public class insertionSortII {
    private static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("parameter error.");
            return null;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    insertionSort.swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            arr[i] = random.nextInt();
        }
        long start = System.nanoTime();
        arr = sort(arr);
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
