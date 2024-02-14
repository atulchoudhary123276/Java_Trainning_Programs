package JavaStreamApi.Practice;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
    EmployeeFactory empRaw=new EmployeeFactory();
        List<Employee> allEmployee = empRaw.getAllEmployee();
//        System.out.println(allEmployee.stream().flatMap(employee -> employee.getProjects().stream())
//                        .distinct()
//                .collect(Collectors.toList()));

        allEmployee.stream()
                .filter(e->e.getFirstName().startsWith("A"))
                .forEach(System.out::println);

        allEmployee.stream()
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary))
                .forEach(System.out::println);
    }
}
