package com.tian.demo06_synchronized;

/**
 * 死锁
 * 多个线程互相持有对方需要的资源, 导致僵持状态
 * *
 * now we simulate a problem when two girls need a makeup-tool witch is in the other's hand.
 *
 */
public class TestLock {
    public static void main(String[] args) {
        MakeUp girl1 = new MakeUp(1,"Alex");
        MakeUp girl2 = new MakeUp(0,"Ash");

        girl1.start();
        girl2.start();
    }
}

class MakeUp extends Thread {

    // the resources (lipstick and mirror) are only one, so we use static variables
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();

    // choice
    int choice;
    // human name who use the tools
    String girlName;

    // constructor
    MakeUp(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    /*
     存在死锁问题的函数
     */
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipStick) {
                System.out.println(this.girlName + " gtes the lock of lipstick");
                Thread.sleep(1000);

                // try to get mirror after 1 sec
                synchronized (mirror) {
                    System.out.println(this.girlName + "gets the lock of mirror.");
                }
            }
        } else {
            // try to get mirror after 1 sec
            synchronized (mirror) {
                System.out.println(this.girlName + "gets the lock of mirror.");
                Thread.sleep(2000);

                synchronized (lipStick) {
                    System.out.println(this.girlName + " gtes the lock of lipstick");
                }
            }
        }
    }

    /**
     * 可以解决死锁问题的函数
     * 解决方案就是, 不要让某一个线程同时抱有两把锁, 这样就可以实现对资源的周转.
     * @throws InterruptedException 抛出异常
     */
    private void realMakeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipStick) {
                System.out.println(this.girlName + " gtes the lock of lipstick");
                Thread.sleep(1000);
            }
            // try to get mirror after 1 sec
            synchronized (mirror) {
                System.out.println(this.girlName + "gets the lock of mirror.");
            }
        } else {
            // try to get mirror after 1 sec
            synchronized (mirror) {
                System.out.println(this.girlName + "gets the lock of mirror.");
                Thread.sleep(2000);
            }
            synchronized (lipStick) {
                System.out.println(this.girlName + " gtes the lock of lipstick");
            }
        }
    }

    @Override
    public void run() {
        try {
            realMakeup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * 口红类
 */
class LipStick {

}

/**
 * class for mirror
 */
class Mirror {

}