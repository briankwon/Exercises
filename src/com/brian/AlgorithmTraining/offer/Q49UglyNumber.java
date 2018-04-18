package com.brian.AlgorithmTraining.offer;

import java.util.HashMap;

public class Q49UglyNumber {
    public static void main(String[] args) {
        int n = 1500;
        System.out.println(getUglynumber(n));
        System.out.println(GetUglyNumber_Solution(n));
        new HashMap<>();
    }

    public static int getUglynumber(int index) {
        if (index <= 0) {
            return -1;
        }

        int[] dp = new int[index];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        dp[0] = 1;

        for (int i = 1; i < index; i++) {
            int n2 = dp[i2] * 2;
            int n3 = dp[i3] * 3;
            int n5 = dp[i5] * 5;
            int min = Math.min(n2, Math.max(n3, n5));

            if (dp[i] == n2) {
                i2++;
            }

            if (dp[i] == n3) {
                i3++;
            }

            if (dp[i] == n5) {
                i5++;
            }
        }

        return dp[index - 1];
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 6) return index;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int n2 = dp[i2] * 2, n3 = dp[i3] * 3, n5 = dp[i5] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) i2++;
            if (dp[i] == n3) i3++;
            if (dp[i] == n5) i5++;
        }
        return dp[index - 1];
    }
}
