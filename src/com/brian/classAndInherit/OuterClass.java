package com.brian.classAndInherit;

public class OuterClass{
    int out_x = 100;

    class InnerClass {
        int x = 10;
        int y = 11;
        int z = 12;
        void display() {
            System.out.println("outer x = " + out_x);
        }
    }

    class Inner2 {
        InnerClass inner2 = new InnerClass();
        void display() {
            //System.out.println(x);
        }
    }
}


