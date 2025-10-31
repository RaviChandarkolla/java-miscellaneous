package threads.synchronization;

class Reentrant1 {
    public synchronized void outerMethod() {
        System.out.println("In outer method");
        innerMethod();  // Calling inner method
    }

    public synchronized void innerMethod() {
        System.out.println("In inner method");
    }

    public static void main(String[] args) {
        Reentrant1 example = new Reentrant1();
        example.outerMethod();
    }
}