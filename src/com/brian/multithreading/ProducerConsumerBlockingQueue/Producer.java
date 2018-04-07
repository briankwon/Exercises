package com.brian.multithreading.ProducerConsumerBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        try {
            while (true) {
                Object obj = getGood();
                System.out.println(Thread.currentThread().getName() + " puts good, current size of queue is " + queue.size());
                queue.put(obj);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Object getGood() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Object();
    }
}