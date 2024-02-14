package JavaStreamApi.Practice;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Tester {
    static int count=1;

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
        //5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
        System.out.println("        //5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).\n");
        allEmployee.stream()
                .collect(Collectors.groupingBy(Employee::getSalary
                        , () -> new TreeMap<>(Collections.reverseOrder())
                        , Collectors.toList()
                ))
                .forEach((k,v)->{
            if(count++==3){
                System.out.println(k +" "+ v);
//                System.exit(0);
            }
        });

        //6. Print min salary.
        Integer min = allEmployee.stream().map(Employee::getSalary).min(Integer::compareTo)
                .orElse(-1);
        System.out.println(min);


        //7. Print list of all employee with min salary.
        System.out.println("//7. Print list of all employee with min salary.\n");
        allEmployee.stream()
                        .filter(employee -> employee.getSalary()==min)
                                .forEach(System.out::println);

        System.out.println("8. List of people working on more than 2 projects.\n");
        allEmployee.stream()
                .filter(employee -> employee.getProjects().size()>2)
                .forEach((r)-> System.out.println(r.getProjects()+r.getFirstName()));

       //9. Count of total laptops assigned to the employees.
        System.out.println("9. Count of total laptops assigned to the employees.\n");

        int sum = allEmployee.stream()
                .map(Employee::getTotalLaptopsAssigned)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
        //--2nd approach
        int sum1 = allEmployee.stream()
                .map(Employee::getTotalLaptopsAssigned)
                        .reduce(0,(r1,r2)->r1+r2);
        System.out.println(sum1);

        //10. Count of all projects with Robert Downey Jr as PM.
//        11. List of all projects with Robert Downey Jr as PM.
        System.out.println("10. Count of all projects with Robert Downey Jr as PM.");
        List<Project> robertDowneyJr = allEmployee.stream()
                .flatMap(e -> e.getProjects().stream())
                .filter(p -> p.getProjectManager().equals("Robert Downey Jr"))
                .collect(Collectors.toList());
        System.out.println(robertDowneyJr.size());
        System.out.println("11. List of all projects with Robert Downey Jr as PM." );
        System.out.println(robertDowneyJr);


        //12. List of all people working with Robert Downey Jr.
        System.out.println("12. List of all people working with Robert Downey Jr.");
        List<Employee> list=new ArrayList<>();
                  allEmployee.stream()
                .collect(Collectors.groupingBy(e -> e,
                                Collectors.flatMapping(employee -> employee.getProjects().stream(),
                                        Collectors.mapping(Project::getProjectManager,
                                                Collectors.mapping(p -> p.equals("Robert Downey Jr"),
                                                Collectors.toList()))
                                )
                        )
                )
                .forEach((k,v)->{
                    v.stream().filter(p->p==true)
                            .forEach(s -> list.add(k));
                });
        System.out.println(list);


    }
}
