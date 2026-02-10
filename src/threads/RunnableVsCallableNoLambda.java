package threads;

import java.util.concurrent.*;

public class RunnableVsCallableNoLambda {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        /* ---------------- Runnable ---------------- */

        Runnable runnableTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable running on thread: "
                        + Thread.currentThread().getName());
            }
        };

        Future<?> runnableFuture = executor.submit(runnableTask);

        // Runnable does NOT return a result
        System.out.println("Runnable result: " + runnableFuture.get()); // null


        /* ---------------- Callable ---------------- */

        Callable<Integer> callableTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Callable running on thread: "
                        + Thread.currentThread().getName());
                Thread.sleep(1000);
                return 42;
            }
        };

        Future<Integer> callableFuture = executor.submit(callableTask);

        System.out.println("Callable result: " + callableFuture.get());


        /* ---------------- Callable with Exception ---------------- */

        Callable<Integer> failingTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                throw new Exception("Something went wrong");
            }
        };

        Future<Integer> failedFuture = executor.submit(failingTask);

        try {
            failedFuture.get();
        } catch (ExecutionException e) {
            System.out.println("Exception from Callable: "
                    + e.getCause().getMessage());
        }

        executor.shutdown();
    }
}
