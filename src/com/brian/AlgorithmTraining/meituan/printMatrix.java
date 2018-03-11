package com.brian.AlgorithmTraining.meituan;

/**
 * 按对角线打印矩阵
 *       | 1  2  3  4 |               4
 *       | 5  6  7  8 |     ----->    3 8
 *       | 9 10  11 12|               2 7 12
 *       |13 14  15 16|               1 6 11 16
 *                                    5 10 15
 *                                    9 14
 *                                    13
 *
 *       第一行输出：(0, n-1)
 *       第二行输出：(0, n-2), (1, n-1)
 *       第三行输出：(0, n-3), (1, n-2), (2, n-3)
 *       设第一行的长度为n，cur = n
 *       从第一行开始cur--
 *       col - row + 1 = cur
 */
public class printMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        doPrint(matrix);
    }

    private static void doPrint(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int n = matrix.length;
        int cur = n;

        for (int i = 0; i < 2 * n - 1; i++) {
            for (int row = 0; row < n; row++) {
                for (int col = n - 1; col >= 0; col--) {
                    if (col - row + 1 == cur) {
                        System.out.print(matrix[row][col] + " ");
                    }
                }
            }

            System.out.println();
            cur--;
        }
    }
}
