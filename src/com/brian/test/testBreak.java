package com.brian.test;

public class testBreak {
    public static void main (String[] args) {
        for (int i = 0; i < 5; i++) {
            int j;
            for (j = 0; j < 3; j++) {
                if (j == 2) {
                    break;
                }
                System.out.println("in J, value = " + j);
            }
        }
    }
}
