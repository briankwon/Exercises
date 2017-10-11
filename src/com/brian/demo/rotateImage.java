package com.brian.demo;

public class rotateImage {
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int length = matrix.length;

        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < (length + 1) / 2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length -j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;

                int count = 0;
                for (int m = 0; m < matrix.length; m++) {
                    for (int n = 0; n < matrix[0].length; n++) {
                        System.out.print(matrix[m][n]);
                        count++;
                        if (count == matrix.length) {
                            System.out.println("");
                            count = 0;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
