package com.brian.test;

import java.util.Arrays;

enum paperMoney {
    one, five, ten, twenty, fifity, hundred
}

public class test {

    
    public static void spend(paperMoney currency) {
        switch (currency) {
            case one:
                System.out.println("one");
            case five:
                System.out.println("five");
            default:
                System.out.println("default");
        }
    }
    static void f(String[] args) {
        for (String str : args) {
            System.out.println(str);
        }
    }

    public static void test1() {
        String str = "i like programming and playing games";
        System.out.println(Arrays.toString(str.split(" ")));

    }

    public static byte[] intToByte(int a) {
        byte[] b = new byte[4];
        b[0] = (byte) (a >> 24 & 0xFF);
        b[1] = (byte) (a >> 16 & 0xFF);
        b[2] = (byte) (a >> 8 & 0xFF);
        b[3] = (byte) (a >> 0 & 0xFF);
        return b;
    }
    public static void main(String[] args) {
        f(new String[]{"111", "on fire!"});
        spend(paperMoney.fifity);
        for (paperMoney pm : paperMoney.values()) {
            System.out.println(pm + pm.name() + pm.ordinal());
        }

        for (byte b : intToByte(6513215)) {
            System.out.println(b);
        }
    }
}
