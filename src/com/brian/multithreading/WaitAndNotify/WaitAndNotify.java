package com.brian.multithreading.WaitAndNotify;

import java.io.IOException;

public class WaitAndNotify {
    public static void main(String[] args) throws IOException {
        Person person = new Person();
        new Thread(new Producer("生产者一", person), "P-1").start();
        new Thread(new Producer("生产者一", person), "P-2").start();
        new Thread(new Producer("生产者一", person), "P-3").start();

        new Thread(new Consumer("消费者一", person), "C-1").start();
        new Thread(new Consumer("消费者二", person), "C-2").start();
        new Thread(new Consumer("消费者三", person), "C-3").start();

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}

class Producer implements Runnable {
    private Person person;
    private String producerName;

    public Producer(String producerName, Person person) {
        this.producerName = producerName;
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " producing");
                person.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer implements Runnable {

    private Person person;
    private String consumerName;

    public Consumer(String consumerName, Person person) {
        this.consumerName = consumerName;
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " consuming");
                person.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Person {
    private int foodNum = 0;
    private static Object synObj = new Object();

    private final int MAX_NUM = 5;

    public void produce() throws InterruptedException {
        synchronized (synObj) {
            while (foodNum == MAX_NUM) {
                System.out.println("box is full，size = " + foodNum);
                synObj.wait();
            }
            foodNum++;
            System.out.println("produce success foodNum = " + foodNum);
            synObj.notifyAll();
        }

    }

    public void consume() throws InterruptedException {
        synchronized (synObj) {
            while (foodNum == 0) {
                System.out.println("box is empty,size = " + foodNum);
                synObj.wait();
            }
            foodNum--;
            System.out.println("consume success foodNum = " + foodNum);
            synObj.notifyAll();
        }

    }
}
