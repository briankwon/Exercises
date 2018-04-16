package com.brian.AlgorithmTraining.offer;

public class Q56NumbersAppearOnceInArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5,6,7};
        find(arr);
    }

    public static void find(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int diff = 0;

        for (int n : arr) {
            diff ^= n;
        }

        int index = find1BitPos(diff);

        int c1 = 0;
        int c2 = 0;

        for (int n : arr) {
            if (isBit(n, index)) {
                c1 ^= n;
            } else {
                c2 ^= n;
            }
        }

        System.out.println(c1 + " " + c2);
    }

    public static int find1BitPos(int num) {
        int index = 0;

        while ((num & 1) == 0 && index <= 32) {
            num >>>= 1;
            index++;
        }

        return index;
    }

    public static boolean isBit(int n, int index) {
        n >>>= index;

        if ((n & 1) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
