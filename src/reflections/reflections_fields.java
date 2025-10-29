package reflections;

import java.lang.reflect.Field;
import java.util.Arrays;

public class reflections_fields {
    public static void main(String[] args) throws ClassNotFoundException {
        // Getting fields of the class
        Class<?> extractClass = Class.forName("reflections.Employee");
        System.out.println("\n\n\n------------- Class Fields -------------");
        Field[] classFields = extractClass.getDeclaredFields();
        System.out.println("Class Fields : " + Arrays.toString(classFields));

// Getting fields of the class and super class fields
        System.out.println("\n\n\n------------- All Fields -------------");
        Field[] allFields = extractClass.getFields();
        System.out.println("All Fields : " + Arrays.toString(allFields));
    }
}
