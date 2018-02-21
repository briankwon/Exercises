package com.brian.classAndInherit;

public class testStudent {
    public static void main(String[] args) throws Exception {
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

        System.out.println("----------------");
        Student x1 = new Student("A", 15, "1-1");
        System.out.println(x1);

        Class objClass = Class.forName("com.brian.classAndInherit.Student");
        Student x2 = (Student) objClass.newInstance();
        System.out.println(x2);

        Student x3 = Student.class.newInstance();
        System.out.println(x3);

        Student x4 = (Student) x1.clone();
        System.out.println(x4);

        Person x5 = new Student();
        x5.printSth("hh");

    }
}
