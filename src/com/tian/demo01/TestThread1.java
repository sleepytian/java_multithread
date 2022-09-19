package com.tian.demo01;

// 进程创建方式1: 继承 Thread 类 --> 重写 run() --> 调用 start()
/**
 * NOTICE:
 * Thread start does not necessarily execute immediately.
 * it is scheduled by cpu.
 */
public class TestThread1 extends Thread {
    // override the run() function at the first time !!!
    @Override
    public void run() {
        // function body of run().
        for (int i = 0;i < 10;i++) {
            System.out.println("coding: " + i);
        }
    }

    /**
     * main function()
     * @param args args
     */
    public static void main(String[] args) {
        // main thread, this is the main thread.

        // create a thread object and call start() to start the thread.
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();

        for (int i = 0;i < 10; i++) {
            System.out.println("this is main thread : " + i);
        }

    }


}
