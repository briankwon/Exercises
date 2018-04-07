package com.brian.multithreading.MultiProducerConsumerWaitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Thread[] pro = new Thread[20];
        Thread[] con = new Thread[20];
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 10;

//        for (int i = 0; i < 20; i++) {
//            pro[i] = new Thread(new Producer(queue, maxSize), "Producer-");
//            con[i] = new Thread(new Consumer(queue, maxSize), "Consumer-");
//        }
//
//        for (int i = 0; i < 20; i++) {
//            pro[i].start();
//            con[i].start();
//        }

        for (int i = 0; i < 4; i++) {
            new Thread(new Producer(queue, maxSize), "Producer-" + i).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(queue, maxSize), "Consumer-" + i).start();
        }

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
