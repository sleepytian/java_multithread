package com.tian.demo01;

// Method 2 to implement multi-thread.
// implement the Runnable interface.
public class TestThread2 implements Runnable{

    @Override
    public void run() {
        // method body of run().
        for (int i = 0;i < 10; i++) {
            System.out.println("thread with Runnable: " + i);
        }
    }

    public static void main(String[] args) {

        // create the instance implemented Runnable interface.
        TestThread2 testThread2 = new TestThread2();
        // create thread instance and start thread with this thread --> proxy
        new Thread(testThread2).start();

        for (int i = 0;i < 10; i++) {
            System.out.println("main:" + i);
        }

    }
}
