package com.brian.test;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("hello");
        String s2 = s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");

        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
