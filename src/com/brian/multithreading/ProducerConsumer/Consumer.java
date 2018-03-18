package com.brian.multithreading.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    protected BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object good = queue.take();
                System.out.println("Consumer takes good, current size = " + queue.size());
                take(good);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    void take(Object object) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println("Consuming object " + object.toString());
    }
}
