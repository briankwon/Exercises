package com.brian.multithreading.MultiProducerConsumerWaitNotify;

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
        synchronized (queue) {
            while (true) {
                try {
                    while (queue.size() == maxSize) {
                        System.out.println(Thread.currentThread().getName() + " Queue is full, wait.");
                        queue.wait();
                    }

                    int good = new Random().nextInt(100);
                    queue.add(good);
                    System.out.println(Thread.currentThread().getName() + " Producer puts good " + good + " to queue! current size is " + queue.size());
                    queue.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
