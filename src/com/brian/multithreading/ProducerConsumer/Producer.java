package com.brian.multithreading.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    protected BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object good = getGood();
                queue.put(good);
                System.out.println("Producer put good, current size = " + queue.size());
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    Object getGood() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        return new Object();
    }
}
