package xyz.lijiantao.study.thread;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Jiantao Li
 * @date 2020/3/17 14:49
 */
@Slf4j
public class TheadLocalExample {

    private final static ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                log.debug("Thread name={} formatter = {}", Thread.currentThread().getName(), formatter.get().toPattern());
                try {
                    Thread.sleep(new Random().nextInt(1000));
                    formatter.set(new SimpleDateFormat());
                    log.debug("Thread name={} formatter = {}", Thread.currentThread().getName(), formatter.get().toPattern());
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    formatter.remove();
                }
            }, "" + i).start();
        }
    }
}
