package com.brian.classAndInherit;

public class Student extends Person {
    private String banji;

    public Student (String name, int age, String banji) {
        super(name, age);
        this.banji = banji;
    }

    public String getClassName() {
        return banji;
    }

    public void setClassName(String className) {
        this.banji = className;
    }
}
