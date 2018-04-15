package com.brian.AlgorithmTraining.offer;

public class Q21AdjustArrayBeforeAfter {
    public static void main(String[] args) {
        int[] arr = {1,34,45,6,56,34,55,43,6,53,78,7,86,98,67,8,451};
        adjust(arr);

        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void adjust(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            while (start < end && !isEven(arr[start])) {
                start++;
            }

            while (end > 0 && isEven(arr[end])) {
                end--;
            }

            //start可能等于end
            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
    }

    //判断是否是偶数，是返回true
    public static boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
