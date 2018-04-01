package com.brian.multithreading.printABC;

public class printABC implements Runnable{
    private Object pre;
    private Object cur;
    private String name;

    public printABC(Object pre, Object cur, String name) {
        this.pre = pre;
        this.cur = cur;
        this.name = name;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 10) {
            synchronized (pre) {
                synchronized (cur) {
                    System.out.println(name);
                    count++;
                    cur.notify();
                }
                try {
                    pre.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        printABC pa = new printABC(c, a, "A");
        printABC pb = new printABC(a, b, "B");
        printABC pc = new printABC(b, c, "C");

        new Thread(pa).start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(pb).start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(pc).start();
    }
}
