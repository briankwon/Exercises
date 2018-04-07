package com.brian.multithreading.printAB;

public class printAB implements Runnable {
    private Object object;
    private String name;

    printAB(Object object, String name) {
        this.object = object;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                try {
                    //注意这里就需要notify了
                    object.notify();
                    System.out.println(name);
                    object.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        new Thread(new printAB(object, "A")).start();
        new Thread(new printAB(object, "B")).start();

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
