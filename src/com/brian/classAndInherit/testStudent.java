package com.brian.classAndInherit;

public class testStudent {
    public static void main(String[] args) {
        Student s = new Student("brian", 24, "3-1");
        System.out.println("name: " + s.getName());
        System.out.println("age: " + s.getAge());
        System.out.println("banji:" + s.getClassName());
        s.printSth("from main");
        System.out.println(s.getClassName());
        s.i++;
        System.out.println(s.i);
        Student s2 = new Student("kwon", 25, "3-2");
        s.i += 100;
        System.out.println(s2.i);
    }
}
