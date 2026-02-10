package threads.scheduler;

import java.util.concurrent.PriorityBlockingQueue;

class PriorityTask implements Runnable, Comparable<PriorityTask> {
    private final int priority;
    private final Runnable task;

    public PriorityTask(int priority, Runnable task) {
        this.priority = priority;
        this.task = task;
    }

    @Override
    public int compareTo(PriorityTask other) {
        return Integer.compare(other.priority, this.priority); // higher first
    }

    @Override
    public void run() {
        task.run();
    }
}

class PriorityScheduler {

    private final PriorityBlockingQueue<PriorityTask> queue = new PriorityBlockingQueue<>();
    private final Thread worker;

    public PriorityScheduler() {
        worker = new Thread(() -> {
            while (true) {
                try {
                    PriorityTask task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        worker.start();
    }

    public void submit(int priority, Runnable task) {
        queue.offer(new PriorityTask(priority, task));
    }
}

public class PrioritySchedulerMain {
    public static void main(String[] args) {
        SimpleScheduler scheduler = new SimpleScheduler();

        scheduler.submit(() -> System.out.println("Task 1"));
        scheduler.submit(() -> System.out.println("Task 2"));
    }
}