package com.brian.multithreading.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue<Object> queue;
    Consumer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = queue.take();
                System.out.println("Consumer takes good, current size is " + queue.size());
                take(obj);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void take(Object obj) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Consumer is consuming " + obj.toString());
    }
}
