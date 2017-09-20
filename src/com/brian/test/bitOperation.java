package com.brian.test;

public class bitOperation {
    public static void factorial(int num){
        String a = "1";
        String b = "5";
        if (a != null || b != null) {
            System.out.println("有一个不为null");
        }
    }

    public static void main(String[] args) {
        String s1 = new String("A");
        String s2 = new String("A");
        System.out.println("s1 == s2? " + (s1 == s2));

        String s3 = "A";
        String s4 = new String("A").intern();
        String s5 = new String("A").intern();
        System.out.println("s3 == s4? " + (s3 == s4));
        System.out.println("s5 == s4? " + (s5 == s4));
    }
}
