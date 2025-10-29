package reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflections_private_methods {
    public static void main (String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Invoking private method (sayHi) of the class from another class using reflection
        System.out.println("\n\n\n------------- Invoking private method (sayHi) of the class from another class using reflection -------------");
        Employee employee = new Employee("ABC Inc.");

        Class<?> employeeClass = employee.getClass();
        Method sayHiMethod = employeeClass.getDeclaredMethod("sayHi", String.class);

        sayHiMethod.setAccessible(true);

        sayHiMethod.invoke(employee, "Hello from Reflection!");

        sayHiMethod.setAccessible(false);
    }
}
