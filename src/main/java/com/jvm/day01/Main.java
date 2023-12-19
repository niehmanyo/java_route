package com.jvm.day01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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

    /**
     * 创建一个类实现 Callable接口
     * 重写 call 有返回值的，我们就可以知道多线程执行的结果
     * 创建 MyCallable 对象。表示多线程要执行的任务
     * 创建 FutureTask 的对象，表示管理多线程运行的结果
     * 创建 Thread 对象，表示线程，并且启动
     * \**/
    //第三种实现多线程
    public static void printThread03() throws ExecutionException, InterruptedException {
         // 创建 MyCallable 对象。表示多线程要执行的任务
        MyCallable mc = new MyCallable();
        // 创建 FutureTask 的对象，表示管理多线程运行的结果
        FutureTask<Integer> futureTask = new FutureTask<>(mc);

        Thread t1 = new Thread(futureTask);
        t1.setName("Thread111");

        t1.start();

        Integer result = futureTask.get();
        System.out.println(result);

    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        printThread03();
    }
}
