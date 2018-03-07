package com.brian.MockProgrammingTest;

import java.util.Scanner;

public class iqiyiJava2018first {
    public static void main(String[] args) {
        //first();
        second();
    }

    private static void first() {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int k1 = sc.nextInt();
        int x2 = sc.nextInt();
        int k2 = sc.nextInt();

        if (String.valueOf(x1).length() * k1 < String.valueOf(x2).length() * k2) {
            System.out.println("Less");
            return;
        } else if (String.valueOf(x1).length() * k1 > String.valueOf(x2).length() * k2) {
            System.out.println("Greater");
            return;
        } else {
            StringBuffer s1 = new StringBuffer(String.valueOf(x1));
            for (int i = 1; i < k1; i++) {
                s1.append(String.valueOf(x1));
            }

            StringBuffer s2 = new StringBuffer(String.valueOf(x2));
            for (int i = 1; i < k2; i++) {
                s2.append(String.valueOf(x2));
            }

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) < s2.charAt(i)) {
                    System.out.println("Less");
                    return;
                } else if (s1.charAt(i) > s2.charAt(i)) {
                    System.out.println("Greater");
                    return;
                }
            }

            System.out.println("Equal");
        }
    }

    private static void second() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int max = 0;
        int cur = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cur++;
            }

            max = max > cur ? max : cur;

            if (str.charAt(i) == ')') {
                cur--;
            }
        }

        System.out.println(max);
    }

    private static void third() {
        Scanner sc = new Scanner(System.in);

    }
}
