package com.brian.lintcode;

public class oddEvenBit {
    public static void main (String[] args) {
        int[] arr = {1,3,5,4};
        int len = arr.length;
        int i = 0;
        int j = 1;

        while (i < len && j < len) {
            if (arr[i] % 2 != 0 && arr[j] % 2 == 0) {
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                i += 2;
                j += 2;
                continue;
            }

            if (arr[i] % 2 == 0) {
                i += 2;
            }

            if (arr[j] % 2 != 0) {
                j += 2;
                System.out.println("j = " + j);
            }
        }

        for (int value : arr) {
            System.out.println(value);
        }
    }
}
