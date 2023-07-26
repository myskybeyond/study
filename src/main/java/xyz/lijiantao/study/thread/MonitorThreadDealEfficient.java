package xyz.lijiantao.study.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description 模拟多线程处理任务
 * @Date 2023/7/26 10:44
 * @Created by LIJIANTAO
 */
public class MonitorThreadDealEfficient {

    public static void main(String[] args) throws InterruptedException {

        // 创建ThreadPoolExecutor线程池
        int corePoolSize = 30;           // 核心线程数，表示线程池中保持活动状态的线程数量
        int maxPoolSize = 50;            // 最大线程数，表示线程池允许创建的最大线程数量
        long keepAliveTime = 5;        // 线程空闲时间，超过该时间未执行任务的线程将被回收
        TimeUnit timeUnit = TimeUnit.SECONDS;  // 空闲时间单位
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize, maxPoolSize, keepAliveTime, timeUnit,
                new LinkedBlockingQueue<>()   // 任务队列，使用无界队列LinkedBlockingQueue
        );

        final CountDownLatch latch = new CountDownLatch(corePoolSize);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 10; i++) {
            Task task = new Task(i,"multiThread");
            threadPoolExecutor.submit(task);
        }
        // 等待所有线程执行完成
        while (true){
            // 判断是否还有正在执行的任务
            if (threadPoolExecutor.getActiveCount() > 0) {
//                System.out.println("There are still active tasks.");
            } else {
                System.out.println("No active tasks.");
                long end = System.currentTimeMillis();
                System.out.println("multiThread 执行花费时间: " + (end - start) / 1000 + "s");
                // 关闭线程池
                threadPoolExecutor.shutdown();
                break;
            }
        }
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 10; i++) {
            Task task1 = new Task(i);
            task1.run();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("single thread 执行花费时间: " + (end1 - start1) / 1000 + "s");
    }


    static class Task implements Runnable{
        private int executeNum;
        private CountDownLatch latch;

        private String executeType = "single thread";

        public Task(int executeNum,CountDownLatch latch){
            this.executeNum = executeNum;
            this.latch = latch;
        }

        public Task(int executeNum){
            this.executeNum = executeNum;
        }

        public Task(int executeNum,String executeType){
            this.executeNum = executeNum;
            this.executeType = executeType;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
//                System.out.println(executeType +" Task executed times: " + (executeNum + 1) + " is running on thread " + Thread.currentThread().getName());
            }
        }
    }
}
