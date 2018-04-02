package com.brian.AlgorithmTraining.wuba58;

import java.util.Random;

public class first2017 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        shuffle(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void shuffle(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i >= 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
