package com.brian.IV;

import java.util.Comparator;
import java.util.PriorityQueue;

public class heapComparator {
    public static class Student {
        public int id;
        public int age;
        public Student(int id, int age) {
            this.id = id;
            this.age = age;
        }
    }

    public static class StudentComparator implements Comparator<Student> {

        @Override
        //组成小根堆，修改成组成大根堆只需要改变不等号方向
        public int compare(Student o1, Student o2) {
            if (o1.id < o2.id) {
                return -1;
            } else if (o1.id > o2.id) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> heap = new PriorityQueue<>(new StudentComparator());
        heap.add(new Student(2, 24));
        heap.add(new Student(3, 34));
        heap.add(new Student(4, 76));
        heap.add(new Student(5, 58));
        heap.add(new Student(6, 68));
        heap.add(new Student(17, 19));

        while (!heap.isEmpty()) {
            Student std = heap.poll();
            System.out.println(std.id + " " + std.age);
        }
    }
}
