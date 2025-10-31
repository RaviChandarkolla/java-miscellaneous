package threads.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Instead of synchronizing an entire method, Java allows synchronization on specific blocks of code.
// This improves performance by locking only the necessary section.
class LockCounter {

    // Shared variable
    private int c = 0;

    private final Lock lock = new ReentrantLock();

    // Synchronized block to increment counter
    public void inc() {
        lock.lock();
        try {
            c++;
        } finally {
            lock.unlock();
        }
    }

    // Synchronized method to get counter value
    public int get() {
        return c;

    }
}

public class LockSynchronizationExample {

    public static void main(String[] args) {

        // Shared resource
        LockCounter cnt = new LockCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                cnt.inc();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                cnt.inc();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + cnt.get());
    }
}
