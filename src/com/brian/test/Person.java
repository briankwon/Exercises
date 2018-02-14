package com.brian.test;

import java.util.Date;

public class Person {
    private String name;
    private int age;
    private Date birth;

    public Person () {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, Date birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("obj = " + obj.getClass().toString());
        System.out.println("this = " + this.getClass().toString());
        if (obj != null && obj.getClass() == this.getClass()) {
            if (((Person) obj).getName() == null || this.name == null) {
                return false;
            } else {
                return this.name.equals(((Person) obj).getName());
            }
        }

        return false;
//        if (obj instanceof Person) {
//            return ((Person) obj).name == this.name;
//        }
//
//        return false;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
