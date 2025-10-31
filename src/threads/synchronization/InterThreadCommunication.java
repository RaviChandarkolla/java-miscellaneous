package threads.synchronization;
/*
*
* wait()
Called on an object by a thread that owns the object's monitor (inside a synchronized block/method).

Causes the calling thread to release the object's lock and enter the waiting state until:

Another thread calls notify() or notifyAll() on the same object.

Or a specified timeout expires (if using timed wait).

After being notified, the thread competes to reacquire the object's lock before resuming execution.

notify()
Called on an object by a thread that owns the object's monitor.

Wakes up one random thread waiting on that object.

The awakened thread will only continue after re-acquiring the object's lock.

notifyAll()
Called on an object by a thread that owns the object's monitor.

Wakes up all threads waiting on that object.

The awakened threads will compete for the lock, and only one will proceed at a time.
* */

class SharedResource {
    // interchange this to understand the wait and notify
    private boolean ready = false;

    synchronized void produce() {
        try {
            while (ready) {
                wait();
            }
            System.out.println("Producing...");
            ready = true;
            Thread.sleep(5000);
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void consume() {
        try {
            while (!ready) {
                wait();
            }
            System.out.println("Consuming...");
            ready = false;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(resource::produce);
        Thread consumer = new Thread(resource::consume);


        consumer.start();
        producer.start();
    }
}
