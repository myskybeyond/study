package xyz.lijiantao.study.thread;

/**
 * 多线程测试demo
 * 多线程同时修改同一属性值
 * @author Jiantao Li
 * @date 2020/4/25 22:09
 */
public class ThreadDemo implements Runnable{

    private volatile int count = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        synchronized (this){
            count++;
            System.out.println("count: " + count);
        }
    }
}
