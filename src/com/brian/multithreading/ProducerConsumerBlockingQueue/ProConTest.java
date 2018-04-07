package com.brian.multithreading.ProducerConsumerBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProConTest {
    public static void main(String[] args) {
        int pNum = 4;
        int cNum = 3;
        BlockingQueue<Object> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < pNum; i++) {
            new Thread(new Producer(queue), "Producer-" + i).start();
        }

        for (int i = 0; i < cNum; i++) {
            new Thread(new Consumer(queue), "Consumer-" + i).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
