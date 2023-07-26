package xyz.lijiantao.study.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Date 2023/7/26 10:16
 * @Created by LIJIANTAO
 */
public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        // 创建ThreadPoolExecutor线程池
        int corePoolSize = 3;           // 核心线程数，表示线程池中保持活动状态的线程数量
        int maxPoolSize = 5;            // 最大线程数，表示线程池允许创建的最大线程数量
        long keepAliveTime = 10;        // 线程空闲时间，超过该时间未执行任务的线程将被回收
        TimeUnit timeUnit = TimeUnit.SECONDS;  // 空闲时间单位
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize, maxPoolSize, keepAliveTime, timeUnit,
                new LinkedBlockingQueue<>()   // 任务队列，使用无界队列LinkedBlockingQueue
        );

        // 提交任务给线程池
        for (int i = 0; i < 10; i++) {
            Runnable task = new MyTask(i);
            threadPoolExecutor.submit(task);
        }

        // 关闭线程池
        threadPoolExecutor.shutdown();
    }

    static class MyTask implements Runnable {
        private int taskId;

        public MyTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            // 在此处执行具体的任务逻辑
        }
    }
}
