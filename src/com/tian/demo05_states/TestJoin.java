package com.tian.demo05_states;

/**
 * 线程强制执行, join() 函数
 * *
 * 不建议使用.
 */
public class TestJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 300; i++) {
            System.out.println("线程执行" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        /*
         * 主线程执行到 200 次的时候, 让 副线程 join 并且抢占 cpu 资源.
         * */
        for (int i = 0; i < 800; i++) {
            if (i == 200) thread.join();
            System.out.println("main 函数计数器: " + i);
        }
    }

}