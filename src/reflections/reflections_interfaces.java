package reflections;

import java.util.Arrays;

public class reflections_interfaces {
    public static void main(String[] args) throws ClassNotFoundException {
        // Getting interfaces using reflection
        Class<?> extractClass = Class.forName("reflections.Employee");
        System.out.println("\n\n\n------------- Interfaces -------------");
        System.out.println("Interfaces: "+ Arrays.toString(extractClass.getInterfaces()));
    }
}
