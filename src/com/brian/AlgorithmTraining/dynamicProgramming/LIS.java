package com.brian.AlgorithmTraining.dynamicProgramming;

/**
 * 最长递增子序列
 * input: 4,2,4,3,5,7
 * output: 4
 */
public class LIS {
    public static void main(String[] args) {
        int[] arr = {4,2,4,3,5,7};
        System.out.println(doDP(arr));
    }

    private static int doDP(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int[] dp = new int[arr.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
