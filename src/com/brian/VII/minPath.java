package com.brian.VII;

import java.util.HashMap;

/**
 给一个二维数组，二维数组中的每个数都是正数，要求从左上
 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 加起来。返回最小的路径和。
 */
public class minPath {
    public static int getMinPath(int[][] matrix) {
        return processDP(matrix);
    }


    public static int processDP(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[row - 1][col - 1];


//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println("");
//        }
    }

    //缓存法，DP的一种，相对暴力递归快，比纯正DP慢
    public static HashMap<String, Integer> cache = new HashMap<>();

    public static int processRelativelySlow(int[][] matrix, int i, int j) {
        int result = 0;
        int next = 0;

        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            result = matrix[i][j] + next;
        } else if (i == matrix.length - 1) {
            String nextKey = String.valueOf(i) + " " + String.valueOf(j + 1);

            if (cache.containsKey(nextKey)) {
                next = cache.get(nextKey);
            } else {
                next = processRelativelySlow(matrix, i, j + 1);
            }

            result = matrix[i][j] + next;

        } else if (j == matrix[0].length - 1) {
            String nextKey = String.valueOf(i + 1) + "_" + String.valueOf(j);

            if (cache.containsKey(nextKey)) {
                next = cache.get(nextKey);
            } else {
                next = processRelativelySlow(matrix, i + 1, j);
            }

            result = matrix[i][j] + next;
        } else {
            String rightKey = String.valueOf(i) + "_" + String.valueOf(j + 1);
            int rightNext = 0;

            if (cache.containsKey(rightKey)) {
                rightNext = cache.get(rightKey);
            } else {
                rightNext = processRelativelySlow(matrix, i, j + 1);
            }

            String downKey = String.valueOf(i + 1) + "_" + String.valueOf(j);
            int downNext = 0;

            if (cache.containsKey(downKey)) {
                downNext = cache.get(downKey);
            } else {
                downNext = processRelativelySlow(matrix, i + 1, j);
            }

            result = matrix[i][j] + Math.min(rightNext, downNext);
        }

        String key = String.valueOf(i) + "_" + String.valueOf(j);
        cache.put(key, result);

        return result;
    }


    //暴力递归，最慢
    //返回从matrix中的i j位置出发，到达右下角的路径最小和，要加上自己本身的值
    public static int processSlow(int[][] matrix, int i, int j) {
        //到达了最后一个点，哪儿都走不了，直接返回
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        //到达了最后一行，只能往右走
        if (i == matrix.length - 1) {
            return matrix[i][j] + processSlow(matrix, i, j + 1);
        }
        //到达了最后一列，只能往下走
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + processSlow(matrix, i + 1, j);
        }
        //非上述三个情况，在中间，可以往右也可以往下走，选数值小的那个方向
        return matrix[i][j] + Math.min(processSlow(matrix, i + 1, j), processSlow(matrix, i, j + 1));
    }

    //返回从matrix中的i j位置出发，到达右下角的路径最小和，要加上自己本身的值
    public static int process(int[][] matrix, int i, int j) {
        //递归的出口
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }

        if (i == matrix.length - 1) {
            return matrix[i][j] + process(matrix, i, j + 1);
        }

        if (j == matrix[0].length - 1) {
            return matrix[i][j] + process(matrix, i + 1, j);
        }

        return matrix[i][j] + Math.min(process(matrix, i + 1, j), process(matrix, i, j + 1));
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println("processSlow = " + processSlow(m, 0, 0));
        System.out.println("processRelativelySlow = " + processRelativelySlow(m, 0, 0));

        System.out.println("processDP = " + processDP(m));
//        m = generateRandomMatrix(6, 7);
//        System.out.println(minPath1(m));
//        System.out.println(minPath2(m));
    }
}
