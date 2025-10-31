package threads.asynchronous;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> f1 = executorService.submit(getCallable("Task 1"));
        Future<String> f2 = executorService.submit(getCallable("Task 2"));
        Future<String> f3 = executorService.submit(getCallable("Task 3"));
        String s1 = f1.get();
        System.out.println(s1);
        String s2 = f2.get();
        System.out.println(s2);
        String s3 = f3.get();
        System.out.println(s3);
        executorService.shutdown();
    }
    private static Callable<String> getCallable(String taskName) {
        return () -> "Task:::" + taskName + " => Thread:::" + Thread.currentThread().getName();
    }
}
