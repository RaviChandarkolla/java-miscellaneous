package reflections;

public class reflections_superclass {
    public static void main (String[] args) throws ClassNotFoundException {
        // Getting super class using reflection
        Class<?> extractClass = Class.forName("reflections.Employee");
        System.out.println("\n\n\n------------- Super Class Name -------------");
        System.out.println("Super Class Name: "+ extractClass.getSuperclass());
    }
}
