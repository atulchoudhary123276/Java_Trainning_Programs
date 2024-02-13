package JavaStreamApi.Assignment;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tester {
    public static void main(String[] args) {
        Salary emp1Sal1=new Salary(1523,20000,LocalDate.of(2023,4,1)); //apr
        Salary emp1Sal2=new Salary(1623,25000,LocalDate.of(2023,5,1));
        Salary emp1Sal3=new Salary(1723,30000,LocalDate.of(2023,6,1));
        Salary emp1Sal4=new Salary(1823,35000,LocalDate.of(2023,7,1));
        Salary emp1Sal5=new Salary(1923,25000,LocalDate.of(2023,8,1));
        Salary emp1Sal6=new Salary(11023,37000,LocalDate.of(2023,9,1));
        Salary emp1Sal7=new Salary(11123,31000,LocalDate.of(2023,10,1));
        Salary emp1Sal8=new Salary(11223,32000,LocalDate.of(2023,11,1));
        Salary emp1Sal9=new Salary(1124,31500,LocalDate.of(2023,12,1));
        Salary emp1Sal10=new Salary(1224,35300,LocalDate.of(2024,1,1));
        List<Salary> emp1AllSal=new ArrayList<>();
        emp1AllSal.add(emp1Sal1);emp1AllSal.add(emp1Sal2);emp1AllSal.add(emp1Sal3);emp1AllSal.add(emp1Sal4);emp1AllSal.add(emp1Sal5);emp1AllSal.add(emp1Sal6);emp1AllSal.add(emp1Sal7);emp1AllSal.add(emp1Sal8);emp1AllSal.add(emp1Sal9);emp1AllSal.add(emp1Sal10);

        Employee emp1=new Employee(101,"Sumit Basla",emp1AllSal,4,2023,"Technosoft Pvt");


        Salary emp2Sal1=new Salary(2723,21000,LocalDate.of(2023,6,1));  //jun
        Salary emp2Sal2=new Salary(2823,23000,LocalDate.of(2023,7,1));
        Salary emp2Sal3=new Salary(2923,31000,LocalDate.of(2023,8,1));
        Salary emp2Sal4=new Salary(21023,34000,LocalDate.of(2023,9,1));
        Salary emp2Sal5=new Salary(21123,29000,LocalDate.of(2023,10,1));
        Salary emp2Sal6=new Salary(21223,35000,LocalDate.of(2023,11,1));
        Salary emp2Sal7=new Salary(2124,27000,LocalDate.of(2023,12,1));
        Salary emp2Sal8=new Salary(2224,29000,LocalDate.of(2024,1,1));
        List<Salary> emp2AllSal=new ArrayList<>();
        emp2AllSal.add(emp2Sal1);emp2AllSal.add(emp2Sal2);emp2AllSal.add(emp2Sal3);emp2AllSal.add(emp2Sal4);emp2AllSal.add(emp2Sal5);emp2AllSal.add(emp2Sal6);emp2AllSal.add(emp2Sal7);emp2AllSal.add(emp2Sal8);

        Employee emp2=new Employee(102,"Rahul Dalal",emp2AllSal,6,2023,"Technosoft Pvt");

        Salary emp3Sal1=new Salary(3823,25500,LocalDate.of(2023,7,1));  //july
        Salary emp3Sal2=new Salary(3923,24000,LocalDate.of(2023,8,1));
        Salary emp3Sal3=new Salary(31023,33000,LocalDate.of(2023,9,1));
        Salary emp3Sal4=new Salary(31123,30500,LocalDate.of(2023,10,1));
        Salary emp3Sal5=new Salary(31223,26800,LocalDate.of(2023,11,1));
        Salary emp3Sal6=new Salary(3124,36300,LocalDate.of(2023,12,1));
        Salary emp3Sal7=new Salary(3224,31500,LocalDate.of(2024,1,1));
        List<Salary> emp3AllSal=new ArrayList<>();
        emp3AllSal.add(emp3Sal1);emp3AllSal.add(emp3Sal2);emp3AllSal.add(emp3Sal3);emp3AllSal.add(emp3Sal4);emp3AllSal.add(emp3Sal5);emp3AllSal.add(emp3Sal6);emp3AllSal.add(emp3Sal7);

        Employee emp3=new Employee(103,"Amit Sharma",emp3AllSal,7,2023,"RaclGear Tech Pvt");

        List<Employee> allEmp= Arrays.asList(emp1,emp2,emp3);

        //1. In the last 6 months calculate the total sum of salaries given by each company.   --nov 11
          System.out.println("1. In the last 6 months calculate the total sum of salaries given by each company.");
        LocalDate currentDate=LocalDate.now();
        allEmp.stream()
                .collect(Collectors.groupingBy(Employee::getCompany,
                        Collectors.flatMapping(emp -> emp.getSalaryList().stream(),
                                Collectors.filtering(sal ->
                                   sal.getDateOfCredit().isAfter(currentDate.minusMonths(7)),
                                Collectors.summingInt(Salary::getSalary)))))
                .forEach((k, v) -> System.out.println(k + " " + v));


//        Q2. Each month top salary of the employees.
        System.out.println("\nQ2.Each month top salary of the employees.");
        String[] m={"01jan","02feb","03mar","04apr","05may","06june","07july","08aug","09sep","10oct","11nov","12dec"};
        Map<String, Integer> topSalByMonth = allEmp.stream()
                .flatMap(employee -> employee.getSalaryList().stream())
                .collect(Collectors.toMap((sal) -> m[sal.getDateOfCredit().getMonthValue() - 1]+ " "+sal.getDateOfCredit().getYear(),
                Salary::getSalary,
                BinaryOperator.maxBy(Integer::compare),
                TreeMap::new));
        System.out.println(topSalByMonth);


        //Q3. Calculate the month-wise percentage growth of salaries for each employee
        System.out.print("\nQ3. Calculate the month-wise percentage growth of salaries for each employee\n");
        Map<String, Map<Integer, String>> percentageGrowthByEmployee = allEmp.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> calculatePercentageGrowth(emp.getSalaryList()),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        System.out.println(percentageGrowthByEmployee);

        //Q4 Make a list of all the employees in this format.        [id1_emp1_sumOfSalariesOfEmp_CompanyName1,id2_emp2_sumOfSalariesOfEmp_CompanyName2]
        System.out.println("\nQ4. Make a list of all the employees in this format.");
        System.out.print("[");
         allEmp.forEach(employee ->{
            System.out.print(employee.getId()+" "+employee.getName()+" "+sumOfSalary(employee.getSalaryList())+" "+employee.getCompany());
            if (!employee.equals(allEmp.get(allEmp.size() - 1))) {
                System.out.print(", ");
            }
         });
                System.out.print("]");

        //Q5.Now make two lists which contains the employees of only that company.
        System.out.println("\n\nQ5.Now make two lists which contains the employees of only that company.");
        allEmp.stream().collect(Collectors.toMap(Employee::getCompany,
                (k) -> k.getId() + "_" + k.getName() + "_" + sumOfSalary(k.getSalaryList()) + "_" + k.getCompany(),
                (old,new1)->old+","+new1
                )).forEach((k,v)->{
            System.out.print("[");
                    System.out.println(v+"]");});


        //Q6. Now make a company wise map which shows the max salary given by the company each month.
        System.out.println("\nQ6. Now make a company wise map which shows the max salary given by the company each month.");
        allEmp.stream()
                .collect(Collectors.groupingBy(Employee::getCompany,
                        Collectors.flatMapping(emp -> emp.getSalaryList().stream(),
                        Collectors.toMap((sal) -> m[sal.getDateOfCredit().getMonthValue() - 1]+ " "+sal.getDateOfCredit().getYear(),
                        Salary::getSalary,
                        BinaryOperator.maxBy(Integer::compare),
                        TreeMap::new))))
                .forEach((k, v) -> System.out.println(k + " " + v));
    }
    private static Map<Integer, String> calculatePercentageGrowth(List<Salary> salaries) {
        Map<Integer, String> growthMap = new LinkedHashMap<>();
        growthMap.put(salaries.get(0).getDateOfCredit().getMonthValue(), "100%");
        for (int i = 1; i < salaries.size(); i++) {
            Salary prevSalary = salaries.get(i - 1);
            Salary currSalary = salaries.get(i);
            double growth = ((double) (currSalary.getSalary() - prevSalary.getSalary()) / prevSalary.getSalary()) * 100;
            growthMap.put(currSalary.getDateOfCredit().getMonthValue(), String.format("%.2f",growth)+"%");
        }
        return growthMap;
    }
    private static Integer sumOfSalary(List<Salary> list){
        return list.stream().collect(Collectors.summingInt(Salary::getSalary));
    }
}
