package com.tian.demo01;

import java.awt.*;

/**
 * 实现龟兔赛跑案例
 */
public class Race_Thread implements Runnable {

    // 静态变量保存胜利者, 确保只会有一个胜利者
    private static String winner;

    // 跑道长度
    private final static int RACE_LENGTH = 50;
    // 兔子休息的位置
    private final static int REST_POINT = 40;

    @Override
    public void run() {
        for (int i = 0; i <= RACE_LENGTH; i++) {

            // simulate the rest of rabbit.
            if (Thread.currentThread().getName().equals("rabbit")) {
                if (i == REST_POINT ) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("We are sorry but there is an Exception when rabbit is resting.");
                    }
                }
            }

            // judge if there is a winner to stop running.
            // if not, judge if set this thread as the winner.
            if (winnerExists(i)) {
                break;
            }

            // print the process of this thread.
            System.out.println(Thread.currentThread().getName() + " has run " + i + " steps");
        }
    }

    private boolean winnerExists(int steps) {
        // winner exists --> stop the race.
        if (winner != null) {
            return true;
        }
        // winner does not exist, juage id this thread is winner.
        if (steps == RACE_LENGTH) {

            // set winner as this thread.
            winner = Thread.currentThread().getName();

            // print the winner
            System.out.println("game over! the winner is: " + Thread.currentThread().getName() + " !!!");

            return true;
        }

        return false;
    }


    // 主函数
    public static void main(String[] args) {
        // create race_thread instance.
        Race_Thread race_thread = new Race_Thread();

        // thread of tortoise.
        new Thread(race_thread,"tortoise").start();
        // thread of rabbit.
        new Thread(race_thread,"rabbit").start();

    }


}
