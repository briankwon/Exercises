package com.brian.AlgorithmTraining.haikang;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Student s1 = new Student("brian", 1);
        System.out.println("s1.id = " + s1.id + " s1.name = " + s1.name);
        set.add(s1);
        System.out.println(set.size());
        System.out.println("set.contains(s1) = " + set.contains(s1));
        Student s2 = new Student("kwon", 1);
        System.out.println("s2.id = " + s2.id + " s2.name = " + s2.name);
        System.out.println("s1 == s2 ? " + s1.equals(s2));
        System.out.println("set.contains(s2) = " + set.contains(s2));
        set.add(s2);
        System.out.println(set.size());

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            System.out.println("id = " + s.id + " name = " + s.name);
        }

//        Student s2 = new Student("brian", 1);
//        System.out.println("s2.id = " + s2.id + " s2.name = " + s2.name);
//        System.out.println("s1 == s2 ? " + s1.equals(s2));
//        System.out.println("set.contains(s2) = " + set.contains(s2));
//        s1.id = 2;
//        System.out.println("s1.id = " + s1.id);
//
//        set.add(s1);
//        System.out.println("set.size() = " + set.size());
//        System.out.println("set.contains(s1) ? " + set.contains(s1));
//        Iterator<Student> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Student s = iterator.next();
//            System.out.println("id = " + s.id + " name = " + s.name);
//        }
//
//        Set<Integer> set1 = new HashSet<>();
//        Integer i1 = new Integer(1);
//        set1.add(i1);
//        System.out.println("set1.size = " + set1.size());
//        i1 = 130;
//        set1.add(i1);
//        System.out.println("set1.size = " + set1.size());
//
//        Iterator<Integer> iterator1 = set1.iterator();
//        while (iterator1.hasNext()) {
//            Integer s = iterator1.next();
//            System.out.println("value = " + s);
//        }
    }

    static class Student{
        String name;
        int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return id == student.id &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id);
        }
    }
}

