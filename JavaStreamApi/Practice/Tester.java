package JavaStreamApi.Practice;
import java.util.*;
import java.util.stream.Collectors;

public class Tester {
    static int count=0;
    public static void main(String[] args) {
        EmployeeFactory empRaw=new EmployeeFactory();
        List<Employee> allEmployee = empRaw.getAllEmployee();

        //Q1. List all distinct project in non-ascending order
        System.out.println("Q1.List all distinct project in non-ascending order:");
        System.out.println(allEmployee.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .sorted(Comparator.comparing(Project::getName).reversed())
                .collect(Collectors.toList()));

        //Q2. Print full name of any employee whose firstName starts with ‘A’
        System.out.println("\nQ2. Print full name of any employee whose firstName starts with ‘A’:");
        Optional<Employee> a = allEmployee.stream()
                .filter(e -> e.getFirstName().startsWith("A"))
                .findAny();
        a.ifPresent(System.out::println);

        //Q3. List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
        System.out.println("\nQ3.List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters");
        List<Employee> list2023Emp = allEmployee.stream()
                .filter(e -> e.getId().substring(0, 4).equals("2023"))
                .collect(Collectors.toList());
        System.out.println(list2023Emp);

        //Q4.Sort employees based on firstName, for same firstName sort by salary
        System.out.println("\nQ4.Sort employees based on firstName, for same firstName sort by salary:");
        allEmployee.stream()
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary))
                .forEach(System.out::println);

        //Employess with their salary
        List<Integer> salList = allEmployee.stream().map(e -> e.getSalary()).collect(Collectors.toList());
        System.out.println("Salary of employees: "+salList);

        //Q5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
        System.out.println("\nQ5. Print names of all employee with 3rd highest salary." +
                " (generalise it for nth highest salary).\n");
        int n=3;
        allEmployee.stream()
                .collect(Collectors
                        .groupingBy(e -> e.getSalary(), ()->new TreeMap<>(Collections.reverseOrder()),
                                Collectors.toList())).forEach((k,v)->{
                    if(++count==n){
                        System.out.println(k+" : "+v);
//                                        System.exit(0);
                    }
                });
//        int n=3;
//        allEmployee.stream()
//                .map(e->e.getSalary())
//                        .distinct()
//                                .sorted(Comparator.reverseOrder())
//                                        .skip(n-1)
//                                                .findFirst().ifPresent(System.out::println);

        //Q6. Min salary
        System.out.println("\nQ6.Minimum Salary:");
        Integer minSalary = allEmployee.stream()
                .map(e -> e.getSalary())
                .min(Integer::compareTo).orElse(0);
        System.out.println(minSalary);

        //2nd Approach
        allEmployee.stream()
                .map(Employee::getSalary)
                .min(Comparator.comparing(s->s))
                .ifPresent(System.out::println);

        //Q7. Print list of all employee with min salary
        System.out.println("\nQ7.List of all employee with min salary:");
        allEmployee.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.toList()))
                .entrySet().stream()
                .min((e1, e2) -> Double.compare(e1.getKey(), e2.getKey()))
                .ifPresent(entry -> entry.getValue().forEach(System.out::println));

        //2nd Approach
        System.out.println("\nQ7.List of all employee with min salary:");
        allEmployee.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.toList()))
                .entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getKey))
//                .map(Map.Entry::getValue)
                .ifPresent(entry -> entry.getValue().forEach(System.out::println)); // Handling the case where there might be no employees


        //Q8. List of people working on more than 2 projects
        System.out.println("\nQ8.List of people working on more than 2 projects:");
        List<Employee> list = allEmployee.stream()
                .filter(e -> e.getProjects().size() > 2)
                .collect(Collectors.toList());
        System.out.println(list);

        //Q9. Count of total laptops assigned to the employees
        System.out.println("\nQ9.Count of total laptops assigned to the employees: ");
        int sum = allEmployee.stream()
                .mapToInt(Employee::getTotalLaptopsAssigned)
                .sum();
        System.out.println(sum);
        //--2nd approach
        int sum1 = allEmployee.stream()
                .map(Employee::getTotalLaptopsAssigned)
                .reduce(0,(r1,r2)->r1+r2);
        System.out.println(sum1);

        //Q10. Count of all projects with Robert Downey Jr as PM
        System.out.println("\nQ10.Count of all projects with Robert Downey Jr as PM: ");
        long countPM = allEmployee.stream()
                .flatMap(e -> e.getProjects().stream())
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .distinct()
                .count();
        System.out.println(countPM);

        //Q11. List of all projects with Robert Downey Jr as PM
        System.out.println("\nQ11.List of all projects with Robert Downey Jr as PM:");
        List<Project> listOfSamePM = allEmployee.stream()
                .flatMap(e -> e.getProjects().stream())
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .collect(Collectors.toList());
        System.out.println(listOfSamePM);

        //Q12. List of all people working with Robert Downey Jr
        System.out.println("\nQ12.List of all people working with Robert Downey Jr:");

        List<Employee> listOfEmpWorkWithRobert = allEmployee.stream()
                .filter(e -> e.getProjects().stream().anyMatch(project -> project.getProjectManager().equals("Robert Downey Jr")))
                .collect(Collectors.toList());
        System.out.println(listOfEmpWorkWithRobert);

        System.out.println("\n12. 2nd Approach:");
        allEmployee.stream()
                .flatMap(e -> e.getProjects().stream()
                        .map(p -> new AbstractMap.SimpleEntry<>(
                        p.getProjectManager().equals("Robert Downey Jr"), e)))
                .filter(entry -> entry.getKey()) // Filter to get only entries where project manager is Robert Downey Jr
                .collect(Collectors.groupingBy(entry -> entry.getKey(),
                        Collectors.mapping(entry -> entry.getValue(), Collectors.toList())))
                .forEach((k, v) -> System.out.println("Robert Downey Jr: " + v));

        System.out.println("\n12(ii).List of all people with Project Manager:");
        allEmployee.stream()
                .flatMap(e->e.getProjects().stream().map(p->new AbstractMap.SimpleEntry<>(p
                        .getProjectManager(),e)))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey,Collectors.mapping(entry->entry.getValue(),Collectors.toList())))
                .forEach((k,v)-> System.out.println(k+" : "+v));


        //13. Create a map based on this data, the key should be the year of joining,
        // and value should be list of all the employees who joined the particular year.
        System.out.println("\nQ13.Create a map based on this data, they key should be the year of joining " +
                "and value should be list of all the employees who joined the particular year");
        allEmployee.stream()
                .collect(Collectors
                        .groupingBy(e->e.getId().substring(0,4),TreeMap::new,Collectors.toList())).forEach((k,v)->{
                    System.out.println(k+" : "+v);
                });

        //14. Create a map based on this data, the key should be year of joining
        // and value should be the count of people joined in that particular year
        System.out.println("\nQ14.Create a map based on this data, the key should be year of joining" +
                "and value should be the count of people joined in that particular year");
        allEmployee.stream()
                .collect(Collectors.groupingBy(e -> e.getId().substring(0, 4),TreeMap::new, Collectors.counting()))
                .forEach((k,v)->{
                    System.out.println(k+" "+v);
                });

        //15.Group employees by their team name
        System.out.println("\n15.Group employees by their team name:");
        allEmployee.stream()
                .flatMap(emp->emp.getProjects().stream().map(project -> new AbstractMap.SimpleEntry<>(project.getTeam(),emp)))
                .collect(Collectors.groupingBy(entry->entry.getKey(),
                        Collectors.mapping(entry->entry.getValue(),
                                Collectors.toList())))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //16.Create a map whose key is the project name and the value is the length of the project name
        System.out.println("\n16.Create a map whose key is the project name and the value is the length of the project name");
        allEmployee.stream()
                .flatMap(e->e.getProjects().stream())
                .collect(Collectors
                        .toMap(p->p.getName(),
                                p->p.getName().length(),
                                (oldValue,newValue)->oldValue))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //17. Suppose you have a list of employees, how would you group employees by the first letter of their last names
        System.out.println("\n17. Suppose you have a list of employees, how would you group employees by the first letter of their last names");
        allEmployee.stream()
                .collect(Collectors.groupingBy(e->e.getLastName().charAt(0)))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //18.In a list of projects, how would you find the project with the shortest name
        System.out.println("\n18.In a list of projects, how would you find the project with the shortest name:");
        allEmployee.stream()
                .flatMap(e->e.getProjects().stream())
                .map(Project::getName)
                .min(Comparator.comparing(String::length))
                .ifPresent(System.out::println);

        //19.Group employees by their total number of laptops assigned
        System.out.println("\n19.Group employees by their total number of laptops assigned:");
        allEmployee.stream()
                .collect(Collectors.groupingBy(Employee::getTotalLaptopsAssigned))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //20.Create a map where the key is the project manager's name and the value
        // is the total number of characters in all project names managed by that manager
        System.out.println("\n20.create a map where the key is the project manager's name and the value is " +
                "the total number of characters in all project names managed by that manager");
        allEmployee.stream()
                .flatMap(e->e.getProjects().stream())
                .collect(Collectors.toMap(Project::getProjectManager,
                        p->p.getName().length(),
                        Integer::sum))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //21.Group employees by their salary ranges
        System.out.println("\n21.Group employees by their salary ranges:");
        allEmployee.stream()
                .collect(Collectors.groupingBy(employee -> {
                    int salary = employee.getSalary();
                    if (salary < 1000000) {
                        return "Low";
                    } else if (salary < 1800000) {
                        return "Medium";
                    } else {
                        return "High";
                    }
                },Collectors.toList()))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //22.Create a map where the key is the project name and the value is the number of vowels in the project name
        System.out.println("\n22.Create a map where the key is the project name and the value " +
                "is the number of vowels in the project name");
        allEmployee.stream()
                .flatMap(e->e.getProjects().stream())
                .collect(Collectors.toMap(Project::getName,
                        p->p.getName().chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count(),
                        (oldValue,newValue)->oldValue))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //23.Group employees by the combination of their first and last names
        System.out.println("\n23.Group employees by the combination of their first and last names:");
        allEmployee.stream()
                .collect(Collectors.groupingBy(e->e.getFirstName()+" "+e.getLastName()))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //24.Find the project with the longest name
        System.out.println("\n24.Find the project with the longest name");
        allEmployee.stream()
                .flatMap(e->e.getProjects().stream())
                .max(Comparator.comparing(p->p.getName().length()))
                .ifPresent(System.out::println);

        //25.Create a map where the key is the employee ID and the value
        // is the sum of the lengths of the employee's first and last names
        System.out.println("\n25.Create a map where the key is the employee ID and the value " +
                "is the sum of the lengths of the employee's first and last names");
        allEmployee.stream()
                .collect(Collectors.toMap(e->e.getId(),
                        e->e.getFirstName().length()+e.getLastName().length()))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //26.Group projects by the number of words in their names
        System.out.println("\n26.Group projects by the number of words in their names:");
        allEmployee.stream()
                .flatMap(e->e.getProjects().stream())
                .collect(Collectors.groupingBy(p->p.getName().split("\\s+").length,
                        Collectors.toList())).forEach((k,v)-> System.out.println(k+" : "+v));

        //27.Find the employee with the highest salary
        System.out.println("\n27.Find the employee with the highest salary");
        allEmployee.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        //28.Create a map where the key is the first word of the project name and
        // the value is a list of projects with the same first word
        System.out.println("\n28.Create a map where the key is the first word of the project name and" +
                " the value is a list of projects with the same first word:");
        allEmployee.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .collect(Collectors.groupingBy(p->p.getName().split("\\s")[0]))
                .forEach((k,v)-> System.out.println(k+" : "+v));

        //29.Group employees by the number of vowels in their first names
        System.out.println("\n29.Group employees by the number of vowels in their first names:");
        allEmployee.stream()
                .collect(Collectors.groupingBy(e->e.getFirstName().chars().filter(ch->"aeiouAEIOU".indexOf(ch)!=-1).count()))
                .forEach((k,v)-> System.out.println(k+" "+v));

    }

}