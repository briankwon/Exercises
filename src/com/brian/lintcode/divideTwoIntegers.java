package com.brian.lintcode;

/**
 * Created by briankwon on 2017/7/6.
 */
public class divideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MAX_VALUE && divisor == -1) {
            return Integer.MIN_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            a = a - (b << (shift - 1));
            result = result + (1 << (shift - 1));
        }
        return isNegative? -result: result;
    }

    public static void main(String[] args) {
        System.out.println(divide(100, 9));
    }
}