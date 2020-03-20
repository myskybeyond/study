package xyz.lijiantao.study.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jiantao Li
 * @date 2020/3/18 11:52
 */
@Slf4j
public class CountDownLatchExample {

    public final static int THREAD_COUNT = 550;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {

            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.debug("wait for all thread finish doing thing");
        threadPool.shutdown();
        log.debug("finished...");


    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        log.debug("threadNum: {} working",threadNum);
        Thread.sleep(1000);
    }
}
