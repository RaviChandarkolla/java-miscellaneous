package comparator;

import java.util.*;

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}

// Comparator to sort Employees by age
class AgeComparator implements Comparator<Employee> {

    int count;

    public AgeComparator(int count) {
        this.count = count;
    }

    public int compare(Employee e1, Employee e2) {
        System.out.println("e1 = "+e1.toString());
        System.out.println("e2 = "+e2.toString());
        if (e1.age > e2.age) {
            this.count = this.count + 1;
            System.out.println("this.count = "+this.count);
        }
        return e1.age - e2.age;  // ascending order by age
    }
}

public class ComparatorExample {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 3),
                new Employee("Bob", 2),
                new Employee("Charlie", 8),
                new Employee("chaplin", 5)
        );

        System.out.println("unSorted by age: " + employees);

        // Sort with custom Comparator
        AgeComparator comparator = new AgeComparator(0);
        Collections.sort(employees, comparator);

        System.out.println("Sorted by age: " + comparator.count);
        System.out.println("Sorted by age: " + employees);
    }
}
