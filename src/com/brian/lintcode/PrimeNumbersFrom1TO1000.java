package com.brian.lintcode;

import java.util.ArrayList;

public class PrimeNumbersFrom1TO1000 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //process(list);
        improved(list);

        for (Integer num : list) {
            System.out.println(num);
        }
    }

    /**
     * 双层循环，外层循环2-1000的数字，内层是除数，当i能被j整除时说明i不为质数，此时i>j，当i<=j时说明i为质数
     * @param list
     */
    public static void process(ArrayList<Integer> list) {
        int j = 2;
        for (int i = 2; i <= 1000; i++) {
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j >= i) {
                list.add(i);
            }
        }
    }

    /**
     * 优化版
     * 外层循环不必循环所有的数字，只需要循环所有的奇数
     * @param list
     */
    public static void improved(ArrayList<Integer> list) {
        boolean flag;
        for (int i = 3; i <= 1000; i += 2) {
            flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                list.add(i);
            }
        }
    }
}
