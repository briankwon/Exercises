package com.brian.reflect;

public class easyReflect {
    public static class Person {
        private int age = 18;
        public String name = "kate";
    }

    public static void main(String[] args) throws ClassNotFoundException{
        Class c1 = Person.class;
        Class c2 = Class.forName("com.brian.reflect.easyReflect");
        Class c3 = new Person().getClass();

        System.out.println("c1 == c2? " + String.valueOf(c1 == c2));
        System.out.println("c2 == c3?" + String.valueOf(c2 == c3));
        System.out.println("c1 == c3?" + String .valueOf(c1 == c3));



    }
}
