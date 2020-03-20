package xyz.lijiantao.study.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jiantao Li
 * @date 2020/3/17 15:52
 */
public class Demo {

    private AtomicInteger count = new AtomicInteger();

    public void increment(){
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }
}
