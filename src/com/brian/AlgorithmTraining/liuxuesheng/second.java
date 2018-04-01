package com.brian.AlgorithmTraining.liuxuesheng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;
            boolean flag = true;
            Set<Character> set = new HashSet<>();

            for (int i = a; i <= b; i++) {
                if (i >=0 && i <= 10) {
                    count++;
                    continue;
                }

                String si = String.valueOf(i);

                for (int j = 0; j < si.length(); j++) {
                    if (!set.contains(si.charAt(j))) {
                        set.add(si.charAt(j));
                    } else {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;
                }

                set.clear();
                flag = true;
            }

            System.out.println(count);
        }
    }
}












