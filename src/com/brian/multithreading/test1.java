package com.brian.multithreading;

public class test1 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("in son thread");
    }

    public static void main(String[] args) {
        test1 ex = new test1();
        ex.start();

        System.out.println("main");
    }
}
