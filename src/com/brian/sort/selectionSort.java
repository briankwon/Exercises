package com.brian.sort;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {2,4,7,4,7,8,2,2,56,67,456,1,1,546,7,9,4,3};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int num: arr) {
            System.out.println(num);
        }
    }
}
