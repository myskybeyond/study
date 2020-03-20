package xyz.lijiantao.study.lock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Jiantao Li
 * @date 2020/3/17 10:55
 */
@Slf4j
public class Demo {

    private int threadCorePoolSize = Runtime.getRuntime().availableProcessors();
    private int maxThreadPoolSize = Runtime.getRuntime().availableProcessors() * 2;
    private int threadBlockingQueueSize = 1024;

    private ExecutorService workService = new ThreadPoolExecutor(threadCorePoolSize, maxThreadPoolSize, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(threadBlockingQueueSize), new ThreadFactoryBuilder().setDaemon(true).setNameFormat("demo-%d").build());

    synchronized void lock() {
        log.debug("max poolSize:{}", maxThreadPoolSize);
        System.out.println(System.currentTimeMillis() + ": execute ....");
    }

    @Test
    public void start() {
        workService.submit(() -> {
            while (true) {
                log.debug(Thread.currentThread().getName());
                Singleton singleton = Singleton.getInstance();
                log.debug(singleton.toString());
                ClassA a = new ClassA();
                log.debug(a.toString());
            }
        });
    }

    public void destory() {
        if (!workService.isShutdown()) {
            workService.shutdown();
        }
    }

}
