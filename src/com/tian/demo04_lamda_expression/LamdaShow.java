package com.tian.demo04_lamda_expression;

/**
 * 最终效果演示 以及 多层级简化方式
 * *
 * 总结:
 * 1. lamda 表达式只能在只有一行代码的情况下简化成为一行, 如果有多行代码, 建议用标准方式
 * 2. 使用前提, 必须是函数式接口 (只有一个函数的接口)
 * 3. 多个参数也可以去掉参数类型, 要去掉就所有参数都去掉, 并且这种情况下必须加括号
 *
 */
public class LamdaShow {

    public static void main(String[] args) {
        // 这是标准的 lamda 表达式的用法
        MiInterface miInterface = (int a) -> {
            System.out.println("这是 lamda 表达式, 参数是: " + a);
        };
        miInterface.miFunc(1);

        // 简化1: 去掉参数类型
        miInterface = (a) -> {
            System.out.println("这是去掉参数类型的简化, 参数是: " + a);
        };
        miInterface.miFunc(2);

        // 简化2: 简化括号
        miInterface = a -> {
            System.out.println("这是去掉括号以后的简化, 参数是: " + a);
        };
        miInterface.miFunc(3);

        // 简化3: 去掉花括号
        miInterface = a -> System.out.println("这是去掉花括号以后的简化, 参数是: " + a);
        miInterface.miFunc(4);



    }
}

/**
 * 这是一个 interface.
 */
interface MiInterface {
    void miFunc(int a);
}