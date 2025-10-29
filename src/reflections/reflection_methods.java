package reflections;

import java.lang.reflect.Method;
import java.util.Arrays;

public class reflection_methods {
    public static void main (String[] args) throws ClassNotFoundException {
        // Getting methods of the class
        Class<?> extractClass = Class.forName("reflections.Employee");
        System.out.println("\n\n\n------------- Class Methods -------------");
        Method[] classMethods = extractClass.getDeclaredMethods();
        System.out.println("Class Methods : "+ Arrays.toString(classMethods));

// Getting methods of the class and super class methods
        System.out.println("\n\n\n------------- All Methods -------------");
        Method[] allMethods = extractClass.getMethods();
        System.out.println("All Methods : "+ Arrays.toString(allMethods));
    }
}
