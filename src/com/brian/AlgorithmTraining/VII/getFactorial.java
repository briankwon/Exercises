package com.brian.AlgorithmTraining.VII;

/**
 * 得到n!
 */
public class getFactorial {
    public static long getFactorial1(int num) {
        if (num == 1) {
            return 1L;
        }

        return (long) num * getFactorial1(num - 1);
    }

    public static long getFactorialDP(int num) {
        long result = 1L;
        for (int i =1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 14;
        System.out.println(getFactorial1(num));
        System.out.println(getFactorialDP(num));
    }
}
