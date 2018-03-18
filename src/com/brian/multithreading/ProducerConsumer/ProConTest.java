package com.brian.multithreading.ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProConTest {
    public static void main(String[] args) {
        int producerNum = 4;
        int consumerNum = 3;

        BlockingQueue<Object> queue = new LinkedBlockingDeque<>();

        for (int i = 0; i < producerNum; i++) {
            new Thread(new Producer(queue)).start();
        }

        for (int i = 0; i < consumerNum; i++) {
            new Thread(new Consumer(queue)).start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread ends!");
        }

        System.exit(0);
    }
}
