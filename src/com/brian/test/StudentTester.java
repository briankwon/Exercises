package com.brian.test;

import java.util.Date;

public class StudentTester {
    public static void main(String[] args) {
        Student brian = new Student("brian kwon", 24, new Date(), "2-4");
        brian.draw();
    }
}
