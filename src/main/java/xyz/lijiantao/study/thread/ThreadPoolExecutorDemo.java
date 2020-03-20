package xyz.lijiantao.study.thread;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Jiantao Li
 * @date 2020/1/8 16:07
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,MAX_POOL_SIZE,KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue(QUEUE_CAPACITY),new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable( "" + i);
            executor.execute(worker);
//            Future<?> future = executor.submit(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()){
//            System.out.println("executor is not terminated!!!");
        }
        System.out.println("Finished all threads");
    }
}
