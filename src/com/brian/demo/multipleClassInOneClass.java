package com.brian.demo;

public class multipleClassInOneClass {
    public static void main(String[] args) {
        System.out.println("hello");

        xx x1 = new xx();
        yy y1 = new yy();
    }
}


class xx {
    private String name = "xx";

    public xx() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        System.out.println("helloXX");
    }
}

class yy {
    private String name = "yy";

    public yy() {
        System.out.println(name);
    }
}