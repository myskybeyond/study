package xyz.lijiantao.study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Jiantao Li
 * @date 2020/4/27 9:38
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return Thread.currentThread().getName();
    }
}
