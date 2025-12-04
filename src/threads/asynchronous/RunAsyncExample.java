package threads.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*

Task 1 (CompletableFuture.runAsync())
Uses ForkJoinPool.commonPool() (daemon threads by default)

Daemon threads don't prevent JVM shutdown

Main thread submits → continues → JVM would exit → but waits due to Task 2

Task 2

CachedThreadPool creates NON-DAEMON threads

shutdown() → waits for running tasks to complete before allowing JVM exit

Main thread blocks here until Task 2 finishes (2 seconds)

if this takes more time to complete than Task1 then task1 will be printed

* */
public class RunAsyncExample {
    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from Task 1::" + Thread.currentThread().getName());

        };
        CompletableFuture<Void> taskCompletableFuture1 = CompletableFuture.runAsync(runnable1);
        System.out.println("Hello from Main::" + Thread.currentThread().getName());
//        taskCompletableFuture1.join();

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from Task 2::" + Thread.currentThread().getName());
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<Void> taskCompletableFuture2 = CompletableFuture.runAsync(runnable2, executorService);
//        taskCompletableFuture2.join();
        executorService.shutdown();
    }
}
