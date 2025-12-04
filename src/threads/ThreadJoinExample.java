package threads;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " started.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " ended.");
    }
}

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(), "T1");
        Thread t2 = new Thread(new MyRunnable(), "T2");

        t1.start();
        try {
            t1.join();  // Main thread waits for t1 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();  // Starts only after t1 is finished
//        try {
//            t2.join();  // Main thread waits for t2 to finish
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Main thread ends.");
    }
}

