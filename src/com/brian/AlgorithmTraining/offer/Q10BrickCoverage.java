package com.brian.AlgorithmTraining.offer;

public class Q10BrickCoverage {
    public static void main(String[] args) {
        System.out.println(process(10));
    }

    private static int process(int n) {
        if (n < 2) {
            return n;
        }

        int zero = 1;
        int one = 1;
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = zero + one;
            zero = one;
            one = res;
        }

        return res;
    }
}
