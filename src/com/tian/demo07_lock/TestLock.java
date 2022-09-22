package com.tian.demo07_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 锁使用演示
 * 该代码仍然使用 买票 的代码
 * 该代码中展示的是 juc 包下的 ReentrantLock 类(可复用锁) 做演示
 */
public class TestLock {

    public static void main(String[] args) {
        BuyTicket b = new BuyTicket();

        new Thread(b).start();
        new Thread(b).start();

    }
}

/*
用于实现 Lock 锁的多线程类
 */
class BuyTicket implements Runnable {

    // 假设总票数
    int tickNums = 10;

    // ReentrantLock 表示可复用锁, 是 Lock 的一个子类
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (this.tickNums <= 0) break;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(tickNums--);
            } finally {
                lock.unlock();
            }
        }
    }
}
