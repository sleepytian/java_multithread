package com.tian.demo01;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

/**
 * 多线程同时操作同一个对象
 * 比如: 买火车票的案例
 * *
 * 发现问题: 多线程操作同一个对象的时候, 出现数据紊乱的情况.
 */
public class TestThread3 implements Runnable {

    private int tickNum = 10;

    @Override
    public void run() {

        while (true) {

            if (this.tickNum == 1) {
                break;
            }

            this.tickNum -= 1;

            // 模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "拿到了第" + this.tickNum + "张票");

        }
    }

    public static void main(String[] args) {
        TestThread3 thread = new TestThread3();

        new Thread(thread, "小明").start();
        new Thread(thread, "小红").start();
        new Thread(thread, "老黄牛").start();

    }
}
