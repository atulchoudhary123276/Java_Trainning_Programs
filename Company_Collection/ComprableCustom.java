package Company_Collection;

import java.util.*;

// Employee.java
class Employee implements Comparable<Employee> {
    String firstName;
    String lastName;

    // Constructor sets firstName and lastName
    public Employee(String first, String last)
    {
        this.firstName = first;
        this.lastName = last;
    }

    // User-friendly output when printed.
    public String toString()
    {
        return "( " + lastName + ", " + firstName + " )";
    }

    // Implement the Comparable interface
    @Override public int compareTo(Employee value)
    {
        if (this.lastName.compareTo(value.lastName) != 0) {
            // If lastNames are different, compare lastName
            return this.lastName.compareTo(value.lastName);
        } else {
            // If lastNames are the same, compare firstName
            return this.firstName.compareTo(value.firstName);
        }
    }
}
public class ComprableCustom {
    public static void main(String[] args)
    {
        // Set up array with a few Employee classes
        Employee a[] = new Employee[5];
        a[0] = new Employee("Kirk","Douglas");
        a[1] = new Employee("Mel","Brooks");
        a[2] = new Employee("Jane","Fonda");
        a[3] = new Employee("Henry","Fonda");
        a[4] = new Employee("Michael","Douglas");

        // The .sort() method uses the Comparable interface.
        Arrays.sort(a);

        // Print out the sorted Employees
        for (int i=0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println(Arrays.toString(a));
    }
}
