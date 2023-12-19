package com.jvm;

public class Main {


    // 第一种创建多线程方式
    public static void printThread1(){
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        myThread.setName("线程 1");
        myThread1.setName("线程 2");
        myThread1.start();
        myThread.start();
    }





    // 第二种创建多线程方式
    public static void printThread2(){
        MyRunnable myRunnable1 = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();
        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread1.start();
        thread2.start();
    }
    public static void main(String[] args) {
        printThread2();
    }
}
