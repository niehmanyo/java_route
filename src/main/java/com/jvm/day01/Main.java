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
     * **/
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

    /**
     * <b>@author: russell.nie </b>
     *
     * <p>
     * String getName() ： 返回线程名称
     * void setName(String name) 设置线程名称
     * static Thread currentThread() 获取当前线程对象
     * static void sleep(long time) 让线程休眠指定时间，单位为毫秒
     *  如果没有给 Thread 线程设置名字，会有默认名字
     *  例如 ：Thread-0
     *  </p>
     *
     * <p>
     *  static Thread currentThread() 获取当前线程对象
     *  细节：
     *      当 JVM 虚拟机启动时，会自动的启动多条线程
     *      其中有一条线程 就叫做 main 线程
     *      作用就是去调用 main 方法，并执行里面的代码
     *      再回钱，我们写的所有代码就是执行在 main 线程中
     *</p>
     *
     * <p>
     *     static void sleep(long time) 让线程休眠 指定的时间，单位为毫秒 ms
     *     细节：
     *          1. 哪条线程执行到这个方法，那么哪条线程就会停留多长时间。
     * </p>
     *
     * **/

    public static void printMethods(){

        // 1.创建线程对象
        MyThread t1 = new MyThread("坦克");

        // 2. 开启线程
        t1.start();


        //
        System.out.println(t1.getName());

        // 打印这个方法的线程
        System.out.println(Thread.currentThread().getName());


    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        printThread03();
        printMethods();

        // 执行 main 方法的线程
        System.out.println(Thread.currentThread().getName());

    }
}
