package com.brian.multithreading.ProducerConsumerBlockingQueue;

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
                System.out.println(Thread.currentThread().getName() + " takes good, current size is " + queue.size());
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

        System.out.println(Thread.currentThread().getName() + " is consuming " + obj.toString());
    }
}
