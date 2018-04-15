package com.brian.AlgorithmTraining.lianjia;

import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] list = new int[100];
        list[0] = 1;
        list[1] = 2;
        for (int i = 2; i < 100; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int curPos = 0;
            for (int i = 0; list[i] <= n; i++) {
                curPos = i;
            }

            System.out.println(n - curPos - 1);
        }
    }
}
