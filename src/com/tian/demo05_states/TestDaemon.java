package com.tian.demo05_states;

/**
 * 守护线程测试
 * 案例: 上帝守护你
 */
public class TestDaemon {
    public static void main(String[] args) {

        // 上帝, 将会成为一个守护线程
        God god = new God();
        // 你是被保护的对象
        You you = new You();

        // 将上帝设置成保护线程 --> thread 代理上帝
        Thread thread_god = new Thread(god);
        // 这个值默认是 false 表示用户线程, 正常的线程都是用户线程
        thread_god.setDaemon(true);

        // 上帝出生了
        thread_god.start();

        // 创建线程代理你
        // 用户线程启动
        new Thread(new You()).start();

    }
}

class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("===== goodbye, world =====");
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while(true) {
            System.out.println("永生的上帝保护你");
        }
    }
}
