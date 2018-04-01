package com.brian.multithreading.printAB;

public class printAB implements Runnable {
    private Object obj;
    private String name;

    printAB(Object obj, String name) {
        this.obj = obj;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                obj.notify();
                try {
                    System.out.println(name);
                    obj.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object obj = new Object();
        printAB pa = new printAB(obj, "A");
        printAB pb = new printAB(obj, "B");

        new Thread(pa).start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(pb).start();
    }
}
