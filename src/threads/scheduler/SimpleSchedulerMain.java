package threads.scheduler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class SimpleScheduler {

    private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private final Thread worker;

    public SimpleScheduler() {
        worker = new Thread(() -> {
            while (true) {
                try {
                    Runnable task = taskQueue.take(); // blocks if empty
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        worker.start();
    }

    public void submit(Runnable task) {
        taskQueue.offer(task);
    }
}

public class SimpleSchedulerMain {
    public static void main(String[] args) {
        SimpleScheduler scheduler = new SimpleScheduler();

        scheduler.submit(() -> System.out.println("Task 1"));
        scheduler.submit(() -> System.out.println("Task 2"));
    }
}