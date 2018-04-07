package com.brian.multithreading.ProducerConsumerWaitNotify;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
    private Queue<Integer> queue;
    private int maxSize;

    Producer(Queue queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, wait.");
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                int good = new Random().nextInt(999);
                queue.add(good);
                queue.notifyAll();
                System.out.println("Producer add " + good + " to queue!");
            }
        }
    }
}
