package com.brian.multithreading;

public class TheThread extends Thread {
    @Override
    public void run() {
        try {
            Object lock = new Object();
            synchronized (lock) {
                for (int i = 0; i < 50000; i++) {
                    System.out.println("From " + Thread.currentThread().getName() + " i = " + i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
