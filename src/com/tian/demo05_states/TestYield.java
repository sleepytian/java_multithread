package com.tian.demo05_states;

/**
 * 线程礼让 测试
 * -
 * 在 run() 函数中, 因为设置了 yield() 函数, 所以创建 a 线程后, a 会礼让 b 线程
 * 但是礼让不一定成功, 所以多执行几次, 执行结果显示的顺序是不一定相同的.
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();

    }
}


// 线程类
class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 开始执行");
        Thread.yield();
        System.out.println("线程 " + Thread.currentThread().getName() + " 结束执行");
    }
}

