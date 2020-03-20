package xyz.lijiantao.study.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Jiantao Li
 * @date 2020/3/18 11:18
 */
public class SemaphoreExample {

    public static final int threadNum = 550;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        final Semaphore semaphore = new Semaphore(5);
        try {
            for (int i = 0; i < threadNum; i++) {
                final int threadNum = i;
                threadPool.execute(() -> {
                    try {
                        semaphore.acquire();
                        test(threadNum);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }finally {
            if(!threadPool.isShutdown()){
                threadPool.shutdown();
            }
        }

    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum:" + threadNum);
        Thread.sleep(1000);
    }
}
