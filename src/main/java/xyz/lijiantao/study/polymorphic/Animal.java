package xyz.lijiantao.study.polymorphic;

/**
 * @author Jiantao Li
 * @date 2020/1/10 16:28
 */
public class Animal {
    int num  = 10;
    static int age = 20;

    public void eat(){
        System.out.println("动物吃饭");
    }

    public static void sleep(){
        System.out.println("动物睡觉");
    }

    public void run(){
        System.out.println("动物奔跑");
    }
}
