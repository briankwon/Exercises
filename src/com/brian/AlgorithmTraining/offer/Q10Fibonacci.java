package com.brian.AlgorithmTraining.offer;

public class Q10Fibonacci {
    public static void main(String[] args) {
        System.out.println(processSlow(10));
        System.out.println(processFast(10));
    }

    private static int processSlow(int num) {
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        return processSlow(num - 2) + processSlow(num - 1);
    }

    private static int processFast(int n) {
        int[] res = {0 ,1};

        if (n < 2) {
            return res[n];
        }

        int first = 0;
        int second = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}
