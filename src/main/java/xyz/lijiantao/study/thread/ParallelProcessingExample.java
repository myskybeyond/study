package xyz.lijiantao.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description java多线程并行处理示例代码
 * @Date 2023/7/26 14:26
 * @Created by LIJIANTAO
 */
public class ParallelProcessingExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numThreads = 4; // 假设有4个线程并行处理任务
        int numTasks = 10; // 假设有10个任务

        // 创建线程池，用于并行处理任务
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // 创建任务列表和结果列表
        List<Callable<String>> tasks = new ArrayList<>();
        List<Future<String>> results;

        // 创建任务并添加到任务列表
        for (int i = 0; i < numTasks; i++) {
            final int taskId = i;
            tasks.add(() -> {
                // 模拟处理任务的耗时
                Thread.sleep(1000);
                return "Task " + taskId + " is completed by " + Thread.currentThread().getName();
            });
        }

        // 并行处理任务并获取结果
        results = executor.invokeAll(tasks);

        // 关闭线程池
        executor.shutdown();

        // 打印任务执行结果
        for (int i = 0; i < numTasks; i++) {
            Future<String> result = results.get(i);
            System.out.println(result.get());
        }
    }
}
