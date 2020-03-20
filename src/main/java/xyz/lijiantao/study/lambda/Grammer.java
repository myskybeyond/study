package xyz.lijiantao.study.lambda;

import java.util.List;

/**
 * @author Jiantao Li
 * @date 2020/3/13 15:12
 */
public class Grammer {

    /**
     * 普通写法
     */
    public void runSomething() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am running!");
            }
        };
        new Thread(runnable).start();
    }

    /**
     * 使用lambda表达式
     */
    public void runSomethingLambda() {
        new Thread(() -> {
            System.out.println("I am running lambda!");
        }).start();
    }


    /**
     * 普通写法
     */
    public void iterator(List<String> list) {
        list.forEach(str -> System.out.println(str));
    }

    /**
     * lambda迭代输出
     */
    public void iteratorLambda(List<String> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("s".compareTo("s1"));
    }
}
