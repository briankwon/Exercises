package com.brian.multithreading;

public class RunnableDemo03 {
    public static void main(String[] args) {
        Num num = new Num();
        printOu ou = new printOu(num);
        printJi ji = new printJi(num);

        new Thread(ou).start();
        new Thread(ji).start();
    }
}

class printOu implements Runnable {
    Num num;

    public printOu(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (num.i <= 100) {
            synchronized (num) {
                if (num.flag) {
                    try {
                        num.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("奇数, " + num.i);
                    num.i++;
                    num.flag = true;
                    num.notify();
                }
            }
        }

    }
}

class printJi implements Runnable {
    Num num;

    public printJi(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (num.i <= 100) {
            synchronized (num) {
                if (!num.flag) {
                    try {
                        num.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("偶数, " + num.i);
                    num.i++;
                    num.flag = false;
                    num.notify();
                }
            }
        }

    }
}

class Num {
    int i = 1;
    boolean flag = false;
}
