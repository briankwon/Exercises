package com.brian.demo;

import java.util.List;

public class HelloWorld {
    public static void addNum (int a) {
        a = a + 10;
    }

    public static void add (List<Integer> list) {

    }
    public static void main(String[] args) {
        int[] visited = new int[10];

//        for (int element: visited
//             ) {
//            System.out.println(element);
//        }

        int x = 5;
        addNum(x);
//        System.out.println(x);

        int[] arr = {1,2,3,4,5,6};
        int j = 0;
        while (j < arr.length) {
            if (arr[j] == 5) {
                j++;
                continue;
            }
            System.out.println(arr[j]);
            j++;
        }


        int dividend = 100;
        int divisor = 9;
        System.out.println(1 << 0);
        dividend = 100 >> 9;
        System.out.println(dividend);
        int[][] a = {{1,3,5,6},{2,4,7,8},{3,5,9,10}};
        System.out.println(a[2][3]);


        System.out.println(a.length);
        System.out.println(a[0].length);
        System.out.println(a[1].length);

        String[][] s = new String[][] {{"dd"},{"bb"}};
        for (String[] element: s
             ) {
            for (String subelement: element
                 ) {
                System.out.println(subelement);
            }
        }

        double[][] matrix = new double[4][2];
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 2; k++) {
                matrix[i][k] = Math.random();
            }
        }

        System.out.println(matrix[0].length);
        System.out.println(matrix.length);
        printMatrix(matrix);
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i]);
        }
    }
}