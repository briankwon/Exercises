package com.brian.AlgorithmTraining.VII;

/**
 * 给一个数组arr和一个整数aim。
 * 如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者false
 */
public class moneyProblem {
    public static boolean moneyDP(int[] arr, int aim) {
        //矩阵的列数从0 ~ aim，共aim + 1列
        //i 可以到 arr.length，算上 0 一共有 arr.length + 1行
        //注意boolean的默认值是false
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];


        /**
         * arr = {2,7,3}, aim = 10
         *
         *   0 1 2 3 4 5 6 7 8 9 10
         * 0 F F F F F F F F F F T
         * 1 F F F F F F F F F F T
         * 2 F F F F F F F F F F T
         * 3 F F F F F F F F F F T
         *
         * 这个循环是将最右侧一列的值置为true
         */
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }

        /**
         * 最右下角的值已经确定，最后一行和最后一列也已经确定，我们可以依次往回递推到dp[0][0]。
         * i 和 j 都要避开最右下角的位置，因此初始值 - 1。
         */
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                //根据依赖关系，一个点会依赖下面的一个点，或者下面同时向右移动arr[i]个位置的点
                dp[i][j] = dp[i + 1][j];
                //保证移动点的距离不出界
                if (j + arr[i] <= aim) {
                    //依赖于两个点中的一个，因此任意一个为true当前点就为true
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        //返回0 0点的布尔值，此位置的意思是『给定数组arr和目标aim，0位置之前的sum为0，从0位置开始选择若干数字，能否使得sum = aim』
        return dp[0][0];
    }

    //从 i 开始到arr末尾，在可以任意选择的情况下，能不能得到aim，其中 0 ~ i - 1 位置中选中的数字的和为sum
    public static boolean money1(int[] arr, int aim, int i, int sum) {
        if (i == arr.length) {
            return sum == aim;
        }

        //左边是加上当前位置的数字，继续递归；右边是不加当前位置的数字，继续递归
        //左右节点中有一个能返回true就返回true
        return money1(arr, aim, i + 1, sum + arr[i]) || money1(arr, aim, i + 1, sum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8};
        int aim = 12;
        System.out.println(money1(arr, aim, 0, 0));
        System.out.println(moneyDP(arr, aim));
    }
}
