package designpatterns.creational.singleton;


public class ThreadSafeSingletonDoubleLocking {

    private static ThreadSafeSingletonDoubleLocking instance;

    private ThreadSafeSingletonDoubleLocking() {
    }

    public static ThreadSafeSingletonDoubleLocking getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonDoubleLocking.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonDoubleLocking();
                }
            }
        }
        return instance;
    }
}

