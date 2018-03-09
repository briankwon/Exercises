package com.brian.AlgorithmTraining.offer;

public class Q16Power {
    public static void main(String[] args) {
        int n = 2;
        //processBad(n);
    }

    private static void processBad(int n) {
        int num = 1;

        for (int i = 1; i <= n; i++) {
            num *= 10;
        }

        for (int i = 1; i <num; i++) {
            System.out.println(i);
        }
    }

    private static void processGood(int n) {

    }
}
