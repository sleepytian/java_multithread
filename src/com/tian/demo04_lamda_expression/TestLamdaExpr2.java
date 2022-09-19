package com.tian.demo04_lamda_expression;

/**
 * 带参数的 lamda 表达式
 *
 */
public class TestLamdaExpr2 {

    static class MyClazz2 implements MyInter{

        @Override
        public void myFunc(int a) {
            System.out.println("静态内部类, 参数是: " + a);
        }
    }

    public static void main(String[] args) {
        MyInter myInter = new MyClazz();
        myInter.myFunc(1);

        // 2. 调用静态内部类
        myInter = new MyClazz2();
        myInter.myFunc(2);

        // 3. 调用局部内部类
        class MyClazz3 implements MyInter{

            @Override
            public void myFunc(int a) {
                System.out.println("局部内部类, 参数是: " + a);
            }
        }
        myInter = new MyClazz3();
        myInter.myFunc(3);

        // 4. 匿名内部类
        myInter = new MyInter() {
            @Override
            public void myFunc(int a) {
                System.out.println("匿名内部类, 参数是: " + a);
            }
        };
        myInter.myFunc(4);

        // 5. lamda 表达式
        myInter = (a) -> {
            System.out.println("lamda 表达式, 参数是: " + a);
        };
        myInter.myFunc(6);

    }
}

/**
 * interface
 */
interface MyInter {
    void myFunc (int a);
}

class MyClazz implements MyInter{

    @Override
    public void myFunc(int a) {
        System.out.println("带参数的函数, 参数是: " + a);
    }
}