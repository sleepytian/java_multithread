package com.tian.demo05_states;

/**
 * 测试停止线程
 * ----------
 * 1. 建议线程正常停止 --> 不利用次数, 不建议死循环
 * 2. 建议使用标志位
 * 3. 不要使用 stop(), destroy() 等 jdk 不建议的方法.
 */
public class TestStopThread implements Runnable{

    // 1. 设置一个标志位
    private boolean flag = true;

    // 创建一个停止线程的方法 (转换 flag 的值)
    public void myStop () {
        this.flag = false;
    }


    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("线程输出: " + i++);
        }
    }

    public static void main(String[] args) {

    }
}
