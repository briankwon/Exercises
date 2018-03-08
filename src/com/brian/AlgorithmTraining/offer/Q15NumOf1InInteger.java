package com.brian.AlgorithmTraining.offer;

public class Q15NumOf1InInteger {
    public static void main(String[] args) {
        System.out.println(process(5));
    }

    private static int process(int n) {
        int count = 0;

        while(n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }
}
