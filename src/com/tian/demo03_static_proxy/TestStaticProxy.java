package com.tian.demo03_static_proxy;

/**
 * 静态代理
 * *
 * 静态代理模式总结:
 * 1. 真实对象和目标代理对象都要实现同一个接口
 * 2. 代理对象要代理真实角色
 * *
 * 好处:
 * 代理对象可以做很多真实对象不能做的事情, 真实对象可以做自己的事情
 * *
 *
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        // 创建 weddingCompany
        WeddingCompany weddingCompany = new WeddingCompany(new Person());
        // 代理对象为原对象执行 happyMarry() 方法
        weddingCompany.HappyMerry();

        System.out.println("==========================================");

        /*
        对比 静态代理 和 Thread 类实现 Runnable 接口:

        实际上 Thread 实现 Runnable 接口和 静态代理是同一个思路 (Thread 底层就是一个静态代理的模式)
         */
        new WeddingCompany(new Person()).HappyMerry();
        new Thread( ()-> System.out.println("this is a sentence") ).start();

    }
}

// 结婚接口
interface Marry {
    void HappyMerry();
}

// 实际结婚角色
class Person implements Marry {

    @Override
    public void HappyMerry() {
        System.out.println("happy marry");
    }
}

// 代理角色
class WeddingCompany implements Marry {

    // 代理谁 --> 真实目标角色
    private Marry target;

    public WeddingCompany (Marry target) {this.target = target;}


    @Override
    public void HappyMerry() {
        before();
        this.target.HappyMerry();   // 真实对象结婚方法
        after();
    }

    private void before() {
        System.out.println("结婚之前 --> 布置");
    }

    private void after() {
        System.out.println("结婚之后 --> 后置");
    }

}