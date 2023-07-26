package xyz.lijiantao.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Runnable task = new MyTask(i);
            Thread thread1 = new MyTask1();
            executorService.submit(task);
            executorService.execute(thread1);
            executorService.submit(thread1);
        }

        executorService.shutdown();;
    }

    static class MyTask implements Runnable{

        private int taskId;

        public MyTask(int taskId){
            this.taskId = taskId;
        }

        public void run() {
            System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
        }
    }


    static class MyTask1 extends Thread{
        @Override
        public void run() {
            System.out.println("Task1 is running on thread");
        }
    }
}
