package com.tian.demo06_synchronized;

/**
 * 不安全的买票案例
 * *
 * 线程不安全, 有负数
 */
public class UnsafeTicket {

    public static void main(String[] args) {

        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"一号嘉宾").start();
        new Thread(buyTicket,"二号嘉宾").start();
        new Thread(buyTicket,"三号嘉宾").start();

    }

}

class BuyTicket implements Runnable{

    // 票
    private int ticketNum = 10;

    boolean flag = true;

    // 买票的函数
    private void buy() {
        // 判断是不是邮票
        if (ticketNum <= 0) {
            // 终止 run() 函数
            flag = false;
            return;
        }
        // 提高延时性
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 买票
        System.out.println( Thread.currentThread().getName() + " 买到了票: " + ticketNum--);
    }


    @Override
    public void run() {
        // 买票
        while (flag) {
            buy();
        }

    }
}
