package com.brian.classAndInherit;

public class Person {
    private String name = "nobody";
    private int age = -1;
    static int i;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printSth(String str) {
        System.out.println("Some str: " + str);
    }
}
