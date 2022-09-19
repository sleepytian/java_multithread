package com.tian.demo04_lamda_expression;

/**
 * 推导 lamda 表达式
 */
public class TestLamdaExpr {

    // 3. 静态内部类
    static class MyClass2 implements MyInterface {
        @Override
        public void myMethod() {
            System.out.println("This is myMethod.");
        }
    }

    public static void main(String[] args) {
        // 正常调用类函数
        MyInterface myInterface = new myClass();
        myInterface.myMethod();

        // 调用静态内部类
        myInterface = new MyClass2();
        myInterface.myMethod();

        // 4. 局部内部类
        class myClass3 implements MyInterface {
            @Override
            public void myMethod() {
                System.out.println("This is myMethod.");
            }
        }
        // 调用局部内部类
        myInterface = new myClass3();
        myInterface.myMethod();

        // 5. 匿名内部类
        myInterface = new MyInterface(){
            @Override
            public void myMethod() {
                System.out.println("利用接口直接创建匿名内部类");
            }
        };
        myInterface.myMethod();

        // 6. lamda 简化 --> 适用于只包含一个函数的接口
        // 可以理解成, 可以携程 lamda 表达式的内部类都可以用 5. 的方式定义.
        myInterface = () -> {
            System.out.println("lamda 表达式实现内部类");
        };
        myInterface.myMethod();

    }
}

/**
 * 1. 定义一个函数接口
 */
interface MyInterface {
    void myMethod ();
}

/**
 * 2. 定义一个类实现接口
 */
class myClass implements MyInterface {

    @Override
    public void myMethod() {
        System.out.println("This is myMethod.");
    }
}
