package com.tian.demo05_states;

/**
 * 测试线程优先级
 */
public class TestPriority implements Runnable{

    public static void main(String[] args) {

        TestPriority muRunnable = new TestPriority();

        Thread t1 = new Thread(muRunnable);
        Thread t2 = new Thread(muRunnable);
        Thread t3 = new Thread(muRunnable);
        Thread t4 = new Thread(muRunnable);
        Thread t5 = new Thread(muRunnable);

        // 设置线程优先级
        t1.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(Thread.MAX_PRIORITY);

        t2.setPriority(4);
        t3.setPriority(Thread.NORM_PRIORITY);
        t4.setPriority(6);

        // 启动线程和检查线程优先级
        // 同时通过输出顺序可以看到优先级对线程执行顺序的影响
        // 建议多执行几次, 从而说明, 优先级并不能绝对控制线程执行顺序
        System.out.println("main 函数的优先级是: " + Thread.currentThread().getPriority());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    @Override
    public void run() {
        System.out.println("线程 " + Thread.currentThread().getName() +
                " 的优先级是: " + Thread.currentThread().getPriority());
    }
}
