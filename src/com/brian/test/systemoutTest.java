package com.brian.test;

public class systemoutTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println((int) (Math.random() * 6));
        }
    }
}
