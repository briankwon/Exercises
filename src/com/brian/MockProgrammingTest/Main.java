package com.brian.MockProgrammingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int rNum = 0;
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') {
                rNum++;
            }
        }

        int gNum = str.length() - rNum;

        for (int i = 0; i < rNum; i++) {
            if (str.charAt(i) != 'R') {
                res++;
            }
        }

        System.out.println(res * 2);

        Map<String, String> map = new HashMap<>();
        double d = Math.random();

    }
}
