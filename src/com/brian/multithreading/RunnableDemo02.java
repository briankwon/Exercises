package com.brian.multithreading;

class MyThread2 implements Runnable {
    private int ticket=100000;
    private String name;
    public MyThread2(String name){
        this.name=name;
    }
    public void run(){
        for(int i=1;i<=1000000;i++){
            if(ticket>0){
                System.out.println("线程"+name+"卖票"+(ticket--));
            }
        }
    }
}
public class RunnableDemo02 {
    public static void main(String args[]){
        MyThread2 A = new MyThread2("A");  //实例化线程要执行的任务
        Thread Ta = new Thread(A);    //实例两个线程对象，实际传递的是一个任务
        Thread Tb = new Thread(A);    //因为两个线程执行的是一个任务，所以资源是共享的
        Ta.start();
        Tb.start();
    }
}
