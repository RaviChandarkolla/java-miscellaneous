package reflections;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class reflections_annotations {
    public static void main (String[] args) throws ClassNotFoundException {
        // Getting annotations of the class and super class fields
        System.out.println("\n\n\n------------- All Anotation -------------");
        Class<?> extractClass = Class.forName("reflections.Employee");
        Annotation[] allAnnotations = extractClass.getAnnotations();
        System.out.println("All Fields : "+ Arrays.toString(allAnnotations));
    }
}
