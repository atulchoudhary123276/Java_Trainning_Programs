package JavaStreamApi.Collect_Collector_collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupingByMultipleFieldsExample {
    public static void main(String[] args) {
            List<Employee1> employeesList = new ArrayList<>();
            employeesList.add(new Employee1(101, "Glady", "Manager", "Male", 25_00_000));
            employeesList.add(new Employee1(102, "Vlad", "Software Engineer", "Female", 15_00_000));
            employeesList.add(new Employee1(103, "Shine", "Lead Engineer", "Female", 20_00_000));
            employeesList.add(new Employee1(104, "Nike", "Manager", "Female", 25_00_000));
            employeesList.add(new Employee1(105, "Slagan", "Software Engineer", "Male", 15_00_000));
            employeesList.add(new Employee1(106, "Murekan", "Software Engineer", "Male", 15_00_000));
            employeesList.add(new Employee1(107, "Gagy", "Software Engineer", "Male", 15_00_000));

            // Grouping by designation and Gender two properties and need to get the count.
            Map<String, Map<String, Long>> multipleFieldsMap = employeesList.stream()
                    .collect(Collectors.groupingBy(Employee1::getDesignation, Collectors.groupingBy(Employee1::getGender, TreeMap::new, Collectors.counting())));

            // printing the count based on the designation and gender.
            System.out.println("Group by on multiple properties" + multipleFieldsMap);

            //grouping based on
        Map<Long, Map<String, Long>> collect = employeesList.stream().collect(Collectors.groupingBy(Employee1::getSalary, Collectors.groupingBy(Employee1::getGender, Collectors.counting())));
        System.out.println(collect);
    }
    }

class Employee1 {
    private int id;
    private String name;
    private String designation;
    private String gender;
    private long salary;
    public Employee1(int id, String name, String designation, String gender, long salary) {
        super();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.gender = gender;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", gender=" + gender
                + ", salary=" + salary + "]";
    }
}
