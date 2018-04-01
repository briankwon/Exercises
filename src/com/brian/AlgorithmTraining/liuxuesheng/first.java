package com.brian.AlgorithmTraining.liuxuesheng;

import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();

            if (n <= 4) {
                System.out.println(1);
            }

            int remainder = n % 4;

            if (remainder == 0) {
                System.out.println(n/4);
            } else {
                System.out.println((n - 4) / 4 + 1);
            }
        }
    }
}
