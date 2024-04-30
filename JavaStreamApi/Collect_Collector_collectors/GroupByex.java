package JavaStreamApi.Collect_Collector_collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupByex {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Tom Jones", 45, 12000.00,"MARKETING"),
                new Employee("Harry Major", 26, 20000.00,"LEGAL"),
                new Employee("Ethan Hardy", 65, 30000.00, "LEGAL"),
                new Employee("Nancy Smith", 22, 15000.00, "MARKETING"),
                new Employee("Catherine Jones", 21, 18000.00,"HR"),
                new Employee("James Elliot", 58, 24000.00, "OPERATIONS"),
                new Employee("Frank Anthony", 55, 32000.00, "MARKETING"),
                new Employee("Michael Reeves", 40, 45000.00, "OPERATIONS"));

        Map<String,List<Employee>> employeeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees grouped by department");
        employeeMap.forEach((String key, List<Employee> empList) -> System.out.println(key +" -> "+empList));

        Map<String,Long> employeeMap1=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(employeeMap1);

        TreeMap<String, Long> treeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);

    }
}
class Employee {
    private String name;
    private Integer age;
    private Double salary;
    private String department;

    public Employee(String name, Integer age, Double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String toString(){
        return "Employee Name:"+this.name;
    }

}
//enum Department {
//    OPERATIONS,HR, LEGAL, MARKETING
//}
