package com.tian.demo05_states;

/**
 * 使用 Thread.state() 检查 线程当前状态
 */
public class TestState{

    public static void main(String[] args) {

        // 创建线程
        Thread thread = new Thread( () -> {
            System.out.println(" 线程开始 ");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(" run() --> sleep() 函数出现异常. ");
            }

            System.out.println(" 线程结束 ");
        } );

        // 开始检测
        Thread.State state = thread.getState();
        System.out.println(state);

        // 启动线程
        thread.start();
        state = thread.getState();
        System.out.println(state);

        // 持续检测线程状态
        while (state != Thread.State.TERMINATED) {


            // 更新 state 状态
            state = thread.getState();
            System.out.println(state);
        }




    }


}
