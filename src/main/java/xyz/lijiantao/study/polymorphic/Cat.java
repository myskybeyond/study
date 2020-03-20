package xyz.lijiantao.study.polymorphic;

/**
 * @author Jiantao Li
 * @date 2020/1/10 16:29
 */
public class Cat extends Animal {

    int num = 80;
    static int age = 90;
    String name = "tomcat";

    @Override
    public void eat() {
        System.out.println("猫吃饭");
    }

    public static void sleep() {
        System.out.println("猫睡觉");
    }

    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}
