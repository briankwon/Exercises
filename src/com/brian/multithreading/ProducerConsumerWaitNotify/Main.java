package com.brian.multithreading.ProducerConsumerWaitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 10;

        for (int i = 0; i < 4; i++) {
            Producer producer = new Producer(queue, maxSize);
            new Thread(producer).start();
        }

        for (int i = 0; i < 3; i++) {
            Consumer consumer = new Consumer(queue, maxSize);
            new Thread(consumer).start();
        }

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
