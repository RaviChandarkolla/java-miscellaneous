package virtualthreads;

import java.util.concurrent.ThreadFactory;

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
