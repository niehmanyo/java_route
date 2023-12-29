package com.java.jvm.day01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {


    // 第一种创建多线程方式
    public static void printThread1() {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        myThread.setName("线程 1");
        myThread1.setName("线程 2");
        myThread1.start();
        myThread.start();
    }

    // 第二种创建多线程方式
    public static void printThread2() {
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
     **/
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
     * <p>
     * String getName() ： 返回线程名称
     * void setName(String name) 设置线程名称
     * static Thread currentThread() 获取当前线程对象
     * static void sleep(long time) 让线程休眠指定时间，单位为毫秒
     * 如果没有给 Thread 线程设置名字，会有默认名字
     * 例如 ：Thread-0
     * </p>
     *
     * <p>
     * static Thread currentThread() 获取当前线程对象
     * 细节：
     * 当 JVM 虚拟机启动时，会自动的启动多条线程
     * 其中有一条线程 就叫做 main 线程
     * 作用就是去调用 main 方法，并执行里面的代码
     * 再回钱，我们写的所有代码就是执行在 main 线程中
     * </p>
     *
     * <p>
     * static void sleep(long time) 让线程休眠 指定的时间，单位为毫秒 ms
     * 细节：
     * 1. 哪条线程执行到这个方法，那么哪条线程就会停留多长时间。
     * </p>
     **/

    public static void printMethods() {

        // 1.创建线程对象
        MyThread t1 = new MyThread("坦克");

        // 2. 开启线程
        t1.start();

        //
        System.out.println(t1.getName());

        // 打印这个方法的线程
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * <p>线程优先级决定线程调度：
     * 1.抢占式调度，随机性，每一个线程抢夺 CPU 使用权，执行哪个线程，占用多少时间也不确定，随机性
     * 靠优先级强占，优先级越高，抢到 cpu 的概率越大。这只是概率问题，不能说优先级最高的先运行完毕。
     * 最高优先级为 10，
     * 最低优先级为 1.</p>
     **/

    public static void showPriority() {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr, "1");
        Thread t2 = new Thread(mr, "2");

        t1.setPriority(1);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(Thread.currentThread().getPriority());
    }

    /**
     * <p>守护线程</p>
     * <p>final void setDaemon(boolean on) 设置为守护线程
     * 细节：
     * 当其他的非守护线程执行完毕之后，守护线程会陆续结束。
     * 总的来说，当女神线程结束了，备胎线程就会结束。备胎是守护女神的，所以备胎的 Daemon 设置为 true</p>
     **/
    public static void showDaemon() {
        DaemonThread dt = new DaemonThread("女神");
        MyThread mt = new MyThread("备胎");
        mt.setDaemon(true);
        dt.start();
        mt.start();
    }

    /**
     * <p>void yield() 出让线程/礼让线程</p>
     * **/

    public static void showYield(){

        MyThread t1 = new MyThread("飞机");
        MyThread t2 = new MyThread("坦克");

        t1.start();
        t2.start();
    }

    /**
     * <p>void join() 插入线程/插队线程</p>
     *
     *  Thread t = new MyThread();
     *  t.start();
     *  t.join(); 表示把 t 这个线程插入当前线程之前，当前线程是 main 线程
     * **/
    public static void showJoin() throws InterruptedException {
        MyThread t1 = new MyThread("土豆");
        t1.start();

        // 如果没用 join 插入线程，土豆线程和 main 线程会交替占用 cpu
        // 使用了之后，土豆先占用 cpu，等执行完再给 main
        t1.join();

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        printThread03();

//        System.out.println(Thread.currentThread().getName());
//        Thread.sleep(2000);
//        printMethods();

//        showPriority();

//        showDaemon();

//        showYield();

        showJoin();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "@" + i);
        }
        // 执行 main 方法的线程


    }
}
