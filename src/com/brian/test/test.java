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

    public static void swapArray(int[] arr) {

    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    public static void main(String[] args) {
//        f(new String[]{"111", "on fire!"});
//        spend(paperMoney.fifity);
//        for (paperMoney pm : paperMoney.values()) {
//            System.out.println(pm + pm.name() + pm.ordinal());
//        }
//
//        for (byte b : intToByte(6513215)) {
//            System.out.println(b);
//        }
//
//        int[] arr = {1,2,3,4,5};
//        swap(arr, 0, 1);
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }

        System.out.println('5' - '0' + 1);

        Car c1 = new Car(1);
        Car c2 = new Car(2);
        System.out.println(c1.equals(c2));

        BigCar b1 = new BigCar(1, 100);
        System.out.println(c1.equals(b1));
        System.out.println(b1.equals(c1));

        BigCar b2 = new BigCar(1, 100);
        System.out.println(b1.equals(c1));
        System.out.println(c1.equals(b2));
        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(null));

        String str1 = "str";
        String str2 = new String("Str");
        System.out.println((str1 == str2) + "");
        Integer i1 = 100;

//        Person p1 = new Person("brian");
//        Person p2 = new Person("brian");
//        System.out.println(p1.equals(p2));
//
//        Employee e1 = new Employee("brian", 1);
//        Employee e2 = new Employee("brian", 2);
//        System.out.println(p1.equals(e1));
//        System.out.println(e1.equals(e2));
//        System.out.println(p1.equals(e2));
//        System.out.println(e1.equals(p1));
//        System.out.println(p1.getClass().getName());
//        System.out.println(e1.getClass().getName());
//        System.out.println(p1.getClass().getSimpleName());

    }
}
