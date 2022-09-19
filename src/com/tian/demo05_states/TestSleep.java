package com.tian.demo05_states;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用 sleep() 函数模拟倒计时
 */
public class TestSleep {
    // 模拟一个倒计时功能
    public static void tenMinDown () throws InterruptedException {
        int leftTime = 10;

        while(true) {
            System.out.println(leftTime--);
            Thread.sleep(1000);

            if (leftTime <= 0) break;
        }
    }

    // 更新和打印当前系统时间
    public static void printCurrentTime () {
        // 获取当前时间
        Date currentTime = new Date(System.currentTimeMillis());

        while (true) {
            try {
                // 打印时间
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(currentTime));
                // 线程休眠
                Thread.sleep(1000);
                // 更新时间
                currentTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("下面是一个模拟倒计时的函数: ");
        try {
            tenMinDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("===== 分割线 =====");
        System.out.println("下面要做的是一个每秒更新并且打印当前系统时间的函数:");

        printCurrentTime();
    }
}
