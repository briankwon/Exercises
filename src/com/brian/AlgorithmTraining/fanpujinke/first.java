package com.brian.AlgorithmTraining.fanpujinke;

import java.util.Arrays;
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] t = new int[6];
        t[0] = a + b + c;
        t[1] = a * b * c;
        t[2] = a + b * c;
        t[3] = a * (b + c);
        t[4] = (a + b) * c;
        t[5] = (a * b) + c;
        Arrays.sort(t);
        System.out.println(t[5]);
    }
}
