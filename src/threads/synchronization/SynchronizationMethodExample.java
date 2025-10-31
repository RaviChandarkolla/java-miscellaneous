package threads.synchronization;

// A synchronized method ensures that only one thread can execute it at a time on the same object instance
class Counter{

    // Shared variable
    private int c = 0;

    // Synchronized method to increment counter
    public synchronized void inc(){
        c++;

    }

    // Synchronized method to get counter value
    public synchronized int get(){
        return c;

    }
}

public class SynchronizationMethodExample{

    public static void main(String[] args){

        // Shared resource
        Counter cnt = new Counter();

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
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + cnt.get());
    }
}