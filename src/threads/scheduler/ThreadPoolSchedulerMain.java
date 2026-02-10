package threads.scheduler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPoolScheduler {

    private final ExecutorService executor;
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public ThreadPoolScheduler(int workers) {
        executor = Executors.newFixedThreadPool(workers);

        new Thread(() -> {
            while (true) {
                try {
                    Runnable task = queue.take();
                    executor.execute(task);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }).start();
    }

    public void submit(Runnable task) {
        queue.offer(task);
    }
}
