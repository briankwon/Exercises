package com.brian.multithreading;

class RunnableDemon01Thread implements Runnable {
    private int age = 100;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class RunnableDemon01 {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemon01Thread(), "hi");
        thread.start();

    }
}