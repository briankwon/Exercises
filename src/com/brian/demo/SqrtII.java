package com.brian.demo;

/**
 * Created by briankwon on 2017/7/7.
 */
public class SqrtII {
    public static double sqrt(double x) {
        double start = 0.0;
        double end = x;
        double eps = 1e-12;

        if (end < 1.0) {
            end = 1.0;
        }

        while (end - start > eps) {
            double mid = start + (end - start) / 2;

            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2));
    }
}
