package records;

import java.util.Map;

// Java records, introduced as a preview in Java 14 and standardized in Java 16, were created to eliminate boilerplate
// code for simple data carrier classes (POJOs/DTOs) by automatically generating essential methods while promoting immutability and value semantics
public class RecordsExample {
    public static void main(String[] args) {
        EmpRecord empRecord1 = new EmpRecord(10, "Pankaj", 10000, null);
        EmpRecord empRecord2 = new EmpRecord(10, "Pankaj", 10000, null);

        // toString()
        System.out.println(empRecord1);

        // accessing fields
        System.out.println("Name: " + empRecord1.name());
        System.out.println("ID: " + empRecord1.id());

        // equals()
        System.out.println(empRecord1.equals(empRecord2));

        // hashCode()
        System.out.println(empRecord1 == empRecord2);
    }
}

record EmpRecord(int id, String name, long salary, Map<String, String> addresses) {
    public EmpRecord {
        if (id < 0)
            throw new IllegalArgumentException("employee id can't be negative");

        if (salary < 0)
            throw new IllegalArgumentException("employee salary can't be negative");
    }

    public int getAddressCount() {
        if (this.addresses != null)
            return this.addresses().size();
        else
            return 0;
    }
}

/*
*
* A Record class is final, so we can’t extend it.
* All the fields specified in the record declaration are final.
* The record fields are “shallow” immutable and depend on the type. For example, we can change the addresses field by accessing it and then making updates to it.
*
* */
