package reflections;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class reflections_constructors {
    public static void main(String[] args) throws ClassNotFoundException {
        // Getting constructors of the class
        Class<?> extractClass = Class.forName("reflections.Employee");
        System.out.println("\n\n\n------------- Class Constructors -------------");
        Constructor<?>[] constructors = extractClass.getConstructors();
        System.out.println("Constructors : " + Arrays.toString(constructors));
    }
}
