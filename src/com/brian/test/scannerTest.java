package com.brian.test;

import java.util.ArrayList;
import java.util.Scanner;

public class scannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//
//        for (int i = 0; i < m; i++) {
//            list1.add(sc.nextInt());
//        }
//
//        for (int i = 0; i < n; i++) {
//            list2.add(sc.nextInt());
//        }
//
//        System.out.println(list1.toString());
//        System.out.println(list2.toString());


        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.equals("exit")) {
                break;
            }

            list.add(str);
            //System.out.println(str);
        }

        System.out.println(list.toString());

        }
}
