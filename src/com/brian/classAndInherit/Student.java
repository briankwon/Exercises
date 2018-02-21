package com.brian.classAndInherit;

public class Student extends Person implements Cloneable {
    private String banji = "empty";

    public Student (String name, int age, String banji) {
        super(name, age);
        this.banji = banji;
    }

    public Student () {}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void printSth(String str) {
        System.out.println("from Student.Class = " + str);
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getAge() + " " + banji;
    }

    public String getClassName() {
        return banji;
    }

    public void setClassName(String className) {
        this.banji = className;
    }
}
