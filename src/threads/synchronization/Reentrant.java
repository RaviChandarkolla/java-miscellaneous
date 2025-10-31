package threads.synchronization;

import java.util.concurrent.locks.ReentrantLock;

/*
1. Reentrancy: A thread that currently holds the lock can re-enter any block of code synchronized on that lock.
2. Lock Counter: A reentrant lock maintains a counter to keep track of how many times the lock has been acquired by the holding thread. Each acquisition increments the counter, and each release decrements it.
3. Thread Ownership: Only the thread that currently holds the lock can release it, ensuring that locks are released appropriately and preventing other threads from erroneously releasing locks.
*/

public class Reentrant {
    private final ReentrantLock lock = new ReentrantLock();

    public void methodA() {
        lock.lock();
        try {
            System.out.println("Inside Method A");
            methodB(); // The same thread can acquire the lock again
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            System.out.println("Inside Method B");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Reentrant example = new Reentrant();
        example.methodA();
    }
}
