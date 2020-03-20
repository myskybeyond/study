package xyz.lijiantao.study.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jiantao Li
 * @date 2020/3/18 12:12
 */
@Slf4j
public class CountDownLatchExample2 {

    public final static int THREAD_NUM = 550;
    final static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        log.debug("wait for run single...");
        for (int i = 0; i < THREAD_NUM; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        ready();
        threadPool.shutdown();
    }

    public static void test(int threadNum) throws InterruptedException {
//        countDownLatch.await();
        Thread.sleep(1000);
        log.debug("threadNum:{} begin doing thing", threadNum);
        Thread.sleep(1000);
    }

    public static void ready(){
        log.debug("ready go...");
//        countDownLatch.countDown();
    }
}
