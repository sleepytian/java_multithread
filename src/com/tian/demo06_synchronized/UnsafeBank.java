package com.tian.demo06_synchronized;


/**
 * 模拟多线程不安全案例
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account("共享账户", 100);

        Drawing you = new Drawing(account, 50, "you");
        Drawing girlfriend = new Drawing(account, 70, "girlfriend");

        you.start();
        girlfriend.start();

    }
}

class Account {

    // 用户名和余额
    String username;
    int balance;

    // 构造函数
    public Account(String username, int balance) {
        this.username = username;
        this.balance = balance;
    }
}

/**
 *
 */
class Drawing extends Thread {
    // 绑定账户
    Account account;
    // 取走了多少钱
    int drawingMoney;
    // 现在手里有多少钱
    int nowMoney;

    public Drawing (Account account, int drawingMoney, String name) {
        super(name);

        this.account = account;
        this.drawingMoney = drawingMoney;
        this.nowMoney = account.balance;
    }

    @Override
    public void run() {
        // 判断有没有钱
        if (account.balance - drawingMoney <= 0) {
            System.out.println(Thread.currentThread().getName() + " 钱不够了, 不能取钱");
            return;
        }



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 可以取钱, 那么就修改余额
        account.balance -= drawingMoney;
        // 手里的前 = 手里的前 + 取到的钱
        nowMoney += drawingMoney;

        System.out.println("结婚基金是 " + nowMoney);


        // 这里的 this.getName() 等价于 Thread.currentThread().getName();
        System.out.println(this.getName() + "手里的钱是" + nowMoney);
    }


}




