package com.brian.bitOperation;

//给你1-1000个连续自然数，然后从中随机去掉两个，再打乱顺序，要求只遍历一次，求出被去掉的两个数。
public class findTwoMissingNumbersFromTwoArray {
    public static int[] find(int[] arr1, int[] arr2) {
        int[] results = new int[4];
        if (arr1 == null || arr2 == null || (arr1.length < 2 && arr2.length < 2)) {
            return results;
        }

        int XORResult1 = 0;
        int XORResult2 = 0;

        for (int i = 0; i < arr1.length; i++) {
            XORResult1 ^= arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            XORResult2 ^= arr2[i];
        }

        int XORResult = XORResult1 ^ XORResult2;
        int index = findPlaceOfFirst1(XORResult);

        for (int i = 0; i < arr1.length; i++) {
            if (classify(arr1[i], index) == 1) {
                results[0] ^= arr1[i];
            } else {
                results[1] ^= arr1[i];
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (classify(arr2[i], index) == 1) {
                results[2] ^= arr2[i];
            } else {
                results[3] ^= arr2[i];
            }
        }

        results[0] ^= results[2];
        results[1] ^= results[3];

        return new int[] {results[0],results[1]};
    }

    public static int findPlaceOfFirst1(int num) {
        int index = 0;

        while ((num & 1) == 0 && index < 32) {
            num = num >> 1;
            index++;
        }

        return index;
    }

    public static int classify(int num, int index) {
        num = num >> index;
        return (num & 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {24,35,45,6,67,8,96,4,56,13,4,512,554,36};
        int[] arr2 = {45,6,67,8,96,4,56,13,4,512,554,36};
        for (int num : find(arr1, arr2)) {
            System.out.println(num + " ");
        }
    }
}
