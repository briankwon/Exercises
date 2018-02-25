package com.brian.test.constructOrder;

public class first {
    private int age = 10;
    static {
        System.out.println("first static block");
    }
    public first() {
        System.out.println("first constructor");
    }
}
