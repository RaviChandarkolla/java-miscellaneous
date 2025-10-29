package reflections;

import java.lang.reflect.Field;

public class reflections_private_fields {
    public static void main (String[] args) throws NoSuchFieldException, IllegalAccessException {
        // Access private fields from another class in java using Reflection Api
        System.out.println("\n\n\n------------- Access private fields from another class in java using Reflection Api -------------");

        Employee employee = new Employee("ABC Inc.");

        Class<?> employeeClass1 = employee.getClass();
        Field companyField = employeeClass1.getDeclaredField("company");

        companyField.setAccessible(true);

        String companyValue = (String) companyField.get(employee);
        System.out.println("Company: " + companyValue);

        companyField.set(employee, "XYZ Corp.");
        System.out.println("Updated Company: " + employee.getCompany());

        companyField.setAccessible(false);
    }
}
