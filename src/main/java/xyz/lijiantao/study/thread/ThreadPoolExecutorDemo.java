package xyz.lijiantao.study.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jiantao Li
 * @date 2020/1/8 16:07
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 50;
    private static final int MAX_POOL_SIZE = 100;
    private static final int QUEUE_CAPACITY = 1024;
    private static final Long KEEP_ALIVE_TIME = 60L;

    private static AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue(QUEUE_CAPACITY), new ThreadPoolExecutor.CallerRunsPolicy());
        ThreadDemo threadDemo = new ThreadDemo();
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        MyCallable myCallable = new MyCallable();
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
//            Runnable worker = new MyRunnable( "" + i);
//            executor.execute(worker);
//            Future<?> future = executor.submit(worker);
//            TimeUnit.SECONDS.sleep(1);
            Future<String> future = executor.submit(myCallable);
            futureList.add(future);
//            executor.execute(threadDemo);
        }
        for (Future<String> future : futureList
        ) {
            try {
                System.out.println(new Date() + "::" + future.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
//            System.out.println("executor is not terminated!!!");
        }
        System.out.println("Finished all threads");
    }
}
