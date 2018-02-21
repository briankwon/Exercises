package com.brian.multithreading;

public class run {
    public static void main(String[] args) throws InterruptedException {

//        try {
//            MyThread thread1 = new MyThread();
//            thread1.setName("A");
//            thread1.start();
//            Thread.sleep(1000);
//            thread1.interrupt();
//
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }


//        CountOperate c = new CountOperate();
//        c.setName("A");
//        c.start();
//        Thread t1 = new Thread(c);
//        System.out.println("main begin t1 isAlive=" + t1.isAlive());
//        t1.setName("A");
//        t1.start();
//        System.out.println("main end t1 isAlive=" + t1.isAlive());

        try {
            TheThread theThread = new TheThread();
            TheThread theThread1 = new TheThread();
            theThread.setName("h1");
            theThread1.setName("h2");
            theThread.start();
            theThread1.start();

            theThread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}