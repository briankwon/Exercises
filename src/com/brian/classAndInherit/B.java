package com.brian.classAndInherit;

public class B implements A {
    public int add(int a) {
        System.out.println("hi");
        return 2;
    }

    public static void main(String[] args) {
        A a = new B();
        a.add(2);
    }

}
