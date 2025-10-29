package reflections;

/**
 * Employee
 */
public class Employee extends Person implements Permanent {
    private String company;


    public Employee() {
    }

    public Employee(String company) {
        this.company = company;
    }

    // Getter method
    public String getCompany() {
        return company;
    }

    // Setter method
    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "company='" + company + '\'' +
                '}';
    }

    private void sayHi(String message) {
        System.out.println(message);
    }

    @Override
    public void getBonus() {
        System.out.println("Method 'getBonus'");
    }
}