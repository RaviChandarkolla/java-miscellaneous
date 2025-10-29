package reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class reflections_class_instances {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Creating class instance using Reflection Api
        System.out.println("\n\n\n------------- Creating class instance using reflection Reflection Api -------------");

        Class<?> employeeClass3 = Class.forName("reflections.Employee");

        Constructor<?> employeeConstructor = employeeClass3.getDeclaredConstructor();

        Object employeeInstance = employeeConstructor.newInstance();

        Employee employee3 = (Employee) employeeInstance;

        employee3.setCompany("IT Conquest");
        employee3.getCompany();
        System.out.println(employee3.getCompany());
    }
}
