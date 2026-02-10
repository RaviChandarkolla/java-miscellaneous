package threads;

import java.util.concurrent.*;

public class RunnableVsCallableDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        /* ---------------- Runnable Example ---------------- */

        Runnable runnableTask = () -> {
            System.out.println("Runnable running on thread: " +
                    Thread.currentThread().getName());
        };

        Future<?> runnableFuture = executor.submit(runnableTask);

        System.out.println("Runnable result: " + runnableFuture.get());
        // Output will be null


        /* ---------------- Callable Example ---------------- */

        Callable<Integer> callableTask = () -> {
            System.out.println("Callable running on thread: " +
                    Thread.currentThread().getName());
            Thread.sleep(1000);
            return 42;
        };

        Future<Integer> callableFuture = executor.submit(callableTask);

        System.out.println("Callable result: " + callableFuture.get());


        /* ---------------- Exception Handling ---------------- */

        Callable<Integer> failingTask = () -> {
            throw new Exception("Something went wrong");
        };

        Future<Integer> failedFuture = executor.submit(failingTask);

        try {
            failedFuture.get();
        } catch (ExecutionException e) {
            System.out.println("Exception from Callable: " +
                    e.getCause().getMessage());
        }

        executor.shutdown();
    }
}