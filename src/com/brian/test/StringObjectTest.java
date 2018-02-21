package com.brian.test;

public class StringObjectTest {
//    public static final String A; // 常量A
//    public static final String B;    // 常量B
//    static {
//        A = "ab";
//        B = "cd";
//    }
    public static void main(String[] args) {
        // 将两个常量用+连接对s进行初始化
//        String s = A + B;
//        String t = "abcd";
//        if (s == t) {
//            System.out.println("s等于t，它们是同一个对象");
//        } else {
//            System.out.println("s不等于t，它们不是同一个对象");
//        }
//
//        String s1 = new String("计算机");
//        String s2 = s1.intern();
//        String s3 = "计算机";
//        System.out.println("s1 == s2? " + (s1 == s2));
//        System.out.println("s3 == s2? " + (s3 == s2));
        String s1 = new String("a1");
        String s2 = "a1";
        String s3 = "a13";
        String s4 = s1 + "3";
        System.out.println((s3 == s4.intern()) + "");
    }
}
