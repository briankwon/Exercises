package com.brian.multithreading.ProducerConsumerWaitNotify;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Integer> queue;
    private int maxSize;

    Consumer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, wait.");
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Get " + queue.poll() + " from queue, current size is " + queue.size());
                queue.notifyAll();
            }
        }
    }
}
