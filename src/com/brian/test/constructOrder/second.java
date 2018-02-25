package com.brian.test.constructOrder;

public class second extends first{
    static {
        System.out.println("second static block");
    }
    public second() {
        System.out.println("second constructor");
    }
}
