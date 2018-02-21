package com.brian.test;

public class testOverrideEquals {
    public static void main(String[] args) {
        Car c1 = new Car(1);
        Car c2 = new Car(1);
        System.out.println(c1.equals(c2));
    }
}
