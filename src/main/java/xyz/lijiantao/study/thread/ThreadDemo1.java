package xyz.lijiantao.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jiantao Li
 * @date 2020/4/25 22:35
 */
public class ThreadDemo1 implements Runnable{
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        count.incrementAndGet();
        System.out.println("count: " + count);
    }
}
