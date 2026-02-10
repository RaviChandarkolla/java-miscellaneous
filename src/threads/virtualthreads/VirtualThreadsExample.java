package threads.virtualthreads;

import java.util.concurrent.ThreadFactory;

/*

Virtual threads are lightweight threads managed by the JVM, not the operating system.

Virtual threads are to platform threads what objects are to memory allocation — cheap, abundant, and JVM-managed.

| Feature                 | Platform Thread | Virtual Thread |
| ----------------------- | --------------- | -------------- |
| Backed by OS            | ✅               | ❌              |
| Creation cost           | High            | Very low       |
| Blocking cost           | Expensive       | Cheap          |
| Max count               | Thousands       | Millions       |
| Managed by              | OS              | JVM            |
| Use with `synchronized` | Risky           | Mostly safe    |


Virtual Thread
     ↓
JVM Scheduler
     ↓
Carrier (OS) Thread


*/
public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable printThread = () -> System.out.println(Thread.currentThread());

        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        ThreadFactory kernelThreadFactory = Thread.ofPlatform().factory();

        Thread virtualThread = virtualThreadFactory.newThread(printThread);
        Thread kernelThread = kernelThreadFactory.newThread(printThread);

        virtualThread.start();
        kernelThread.start();


        virtualThread.join();   // Main waits for virtual thread
        kernelThread.join();

        System.out.println("All threads completed");
    }
}
