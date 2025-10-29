package reflections;

import java.lang.reflect.Modifier;

public class reflections_class_modifier {
    public static void main (String[] args) throws ClassNotFoundException {
        // Getting class modifier using reflection
        Class<?> extractClass = Class.forName("reflections.Employee");
        System.out.println("\n\n\n------------- Class modifier -------------");
        System.out.println("Class Modifier: "+ Modifier.toString(extractClass.getModifiers()));
    }
}
