package threads.asynchronous;

import java.util.concurrent.*;

/*
Future in Java (java.util.concurrent.Future<V>) represents the result of an asynchronous computation that may not be
available yet. It's returned immediately by methods like ExecutorService.submit() and provides methods to check
completion, retrieve results, or cancel tasks.

Core Purpose
Submit a task → Get Future handle → Later retrieve result when ready
 */
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

        Future<String> f4 = executorService.submit(new MyCallable("Task 4"));
        String s4 = f4.get();
        System.out.println(s4);
        executorService.shutdown();
    }

    private static Callable<String> getCallable(String taskName) {
        return () -> "Task:::" + taskName + " => Thread:::" + Thread.currentThread().getName();
    }
}

class MyCallable implements Callable<String> {
    private String taskName;

    public MyCallable(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String call() {
        System.out.println("Thread " + Thread.currentThread().getName() + " started.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " ended.");
        return "Task:::" + this.taskName + " => Thread:::" + Thread.currentThread().getName();
    }
}
