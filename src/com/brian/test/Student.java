package com.brian.test;

import java.util.Date;

public class Student extends Person{
    private String className;

    public Student(String name, int age, Date birth, String className) {
        super(name, age, birth);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void draw () {
        for (int i = 0; i < 5; i++) {
            System.out.println(getAge()+ " " + getClassName());
        }
    }
}
