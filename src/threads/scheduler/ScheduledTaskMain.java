package threads.scheduler;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class ScheduledTask implements Runnable, Delayed {
    private final long executeAt;
    private final Runnable task;

    public ScheduledTask(long delayMillis, Runnable task) {
        this.executeAt = System.currentTimeMillis() + delayMillis;
        this.task = task;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeAt - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.executeAt, ((ScheduledTask) o).executeAt);
    }

    @Override
    public void run() {
        task.run();
    }
}

class DelayedScheduler {

    private final DelayQueue<ScheduledTask> queue = new DelayQueue<>();
    private final Thread worker;

    public DelayedScheduler() {
        worker = new Thread(() -> {
            while (true) {
                try {
                    ScheduledTask task = queue.take(); // waits until delay expires
                    task.run();
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        worker.start();
    }

    public void schedule(Runnable task, long delayMillis) {
        queue.offer(new ScheduledTask(delayMillis, task));
    }
}

public class ScheduledTaskMain {
    public static void main(String[] args) {
        SimpleScheduler scheduler = new SimpleScheduler();

        scheduler.submit(() -> System.out.println("Task 1"));
        scheduler.submit(() -> System.out.println("Task 2"));
    }
}
