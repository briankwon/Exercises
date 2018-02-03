package com.brian;

import com.brian.classAndInherit.Person;

import java.util.concurrent.atomic.AtomicInteger;

class Shape {
    private int counter;
    Shape() {
        System.out.println("Shape constructor");
    }

    public void rotate() {
        System.out.println("go!");
    }

    public void setCounter(int i) {
        counter = i;
    }

    public void getCounter() {
        System.out.println(counter);
    }

}

public class ex1 {
    public static void main(String[] args) {
        Person person = new Person();
        Shape[] shapes = new Shape[5];
        Shape s1 = new Shape();
        s1.rotate();
        s1.getCounter();
        s1.setCounter(100);
        s1.getCounter();
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    private volatile int value;

    public final int getValue() {
        return value;
    }

}
