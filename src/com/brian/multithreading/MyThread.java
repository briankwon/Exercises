package com.brian.multithreading;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("this.getName = " + this.getName());
            System.out.println("Thread.currentThread.getName = " + Thread.currentThread().getName());
//            for (int i = 0; i < 500000; i++) {
//                if (this.interrupted()) {
//                    System.out.println("already stopped");
//                    throw new InterruptedException();
//                }
//                System.out.println("i = " + i);
//            }
            System.out.println("flag after for");
        } catch (Exception e) {
            System.out.println("in catch of MyThread, e.getMessage = " + e.getMessage());
            e.printStackTrace();
        }
    }
}
