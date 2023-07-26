package xyz.lijiantao.study.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Date 2023/7/26 11:14
 * @Created by LIJIANTAO
 */
public class MultiThreadExecutionTime {

    public static void main(String[] args) throws InterruptedException {
        final int numThreads = 5;
        final CountDownLatch latch = new CountDownLatch(numThreads);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                // 模拟线程执行耗时任务
                try {
                    Thread.sleep(2000); // 假设任务执行2秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
            thread.start();
        }

        // 等待所有线程执行完成
        latch.await();

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Multi-thread execution time: " + elapsedTime + " milliseconds");
    }
}
