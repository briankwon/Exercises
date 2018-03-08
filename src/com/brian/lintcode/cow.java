package com.brian.lintcode;

import java.util.Scanner;

public class cow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();

            int f1 = 1;
            int f2 = 2;
            int f3 = 3;
            int res = 0;

            if (n < 4) {
                System.out.println(n);
            } else {
                for (int i = 4; i <= n; i++) {
                    res = f1 + f3;
                    f1 = f2;
                    f2 = f3;
                    f3 = res;
                }

                System.out.println(res);
            }
        }
    }
}
