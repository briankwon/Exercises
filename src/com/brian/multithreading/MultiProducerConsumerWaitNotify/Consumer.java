package com.brian.multithreading.MultiProducerConsumerWaitNotify;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Integer> queue;
    private int maxSize;

    Consumer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (true) {
                try {
                    while (queue.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + " Queue is empty, wait.");
                        queue.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " Consumer gets good " + queue.poll() + " from queue! current size is " + queue.size());
                queue.notifyAll();
            }
        }
    }
}
