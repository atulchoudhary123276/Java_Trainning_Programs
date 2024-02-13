package Company_Collection.assignments.HashMapTask;

import java.time.LocalDate;
import java.util.*;

public class HahMapTask {
    public static void main(String[] args) {
        Address addemp1 = new Address(101, "Newdelhi", "Delhi", "India", "laxmiNagar");
        Address addemp2 = new Address(102, "Bijnor", "UttarPradesh", "India", "chandpur");
        Address addemp3 = new Address(103, "Haridwar", "Uttarakhand", "India", "P-58,jwalapur");
        Address addemp4 = new Address(104, "Haridwar", "Uttarakhand", "India", "P-58,jwalapur");
        Address addemp5 = new Address(105, "Albany", "NewYork", "Usa", "helderberg");

        Map<String, Salary> salMapemp1=new HashMap<>();
        Salary salary101 = new Salary(101, LocalDate.of(2022,4,3), 50000, 10000, 8000, 5000);
        Salary salary201 = new Salary(101, LocalDate.of(2022,6,3), 60000, 12000, 9000, 6000);
        Salary salary601 = new Salary(101, LocalDate.of(2023,3,3), 35000, 10000, 6500, 5500);
              salMapemp1.put("apr-22",salary101);
              salMapemp1.put("jun-22",salary201);
              salMapemp1.put("mar-23",salary601);

        Map<String, Salary> salMapemp2=new HashMap<>();
        Salary salary102 = new Salary(102, LocalDate.of(2022,4,3), 50000, 10000, 8000, 5000);
        Salary salary202 = new Salary(102, LocalDate.of(2022,6,3), 60000, 12000, 9000, 6000);
        Salary salary402 = new Salary(102, LocalDate.of(2023,1,3), 45000, 11000, 8000, 5500);
        Salary salary502 = new Salary(102, LocalDate.of(2023,2,3), 30000, 11000, 7500, 5500);
               salMapemp2.put("apr-22",salary102);
               salMapemp2.put("jun-22",salary202);
               salMapemp2.put("jan-23",salary402);
               salMapemp2.put("feb-23",salary502);

        Map<String, Salary> salMapemp3=new HashMap<>();
        Salary salary103 = new Salary(103, LocalDate.of(2022,4,3), 50000, 10000, 8000, 5000);
        Salary salary203 = new Salary(103, LocalDate.of(2022,6,3), 60000, 12000, 9000, 6000);
        Salary salary403 = new Salary(103, LocalDate.of(2023,1,3), 45000, 11000, 8000, 5500);
        Salary salary603 = new Salary(103, LocalDate.of(2023,3,3), 35000, 10000, 6500, 5500);
        salMapemp3.put("apr-22",salary103);
               salMapemp3.put("jun-22",salary203);
               salMapemp3.put("jan-23",salary403);
               salMapemp3.put("mar-23",salary603);

        Map<String, Salary> salMapemp4=new HashMap<>();
        Salary salary104 = new Salary(104, LocalDate.of(2022,4,3), 50000, 10000, 8000, 5000);
        Salary salary204 = new Salary(104, LocalDate.of(2022,6,3), 60000, 12000, 9000, 6000);
        Salary salary404 = new Salary(104, LocalDate.of(2023,1,3), 45000, 11000, 8000, 5500);
        Salary salary504 = new Salary(104, LocalDate.of(2023,2,3), 30000, 11000, 7500, 5500);
               salMapemp4.put("apr-22",salary104);
               salMapemp4.put("jun-22",salary204);
               salMapemp4.put("jan-23",salary404);
               salMapemp4.put("feb-23",salary504);

        Map<String, Salary> salMapemp5=new HashMap<>();
        Salary salary105 = new Salary(105, LocalDate.of(2022,4,3), 50000, 10000, 8000, 5000);
        Salary salary305 = new Salary(105, LocalDate.of(2022,12,3), 40000, 11000, 8500, 5500);
        Salary salary605= new Salary(105, LocalDate.of(2023,3,3), 35000, 10000, 6500, 5500);
              salMapemp5.put("apr-22",salary105);
              salMapemp5.put("dec-22",salary305);
              salMapemp5.put("mar-23",salary605);

        Emp3 employee1 = new Emp3("101", "Bhanu", LocalDate.of(2000,1,1), salMapemp1, addemp1);
        Emp3 employee2 = new Emp3("102", "Roshni", LocalDate.of(2001,1,1), salMapemp2, addemp2);
        Emp3 employee3 = new Emp3("103", "Namit", LocalDate.of(2002,1,1), salMapemp3, addemp3);
        Emp3 employee4 = new Emp3("104", "Dhruv", LocalDate.of(2001,6,1), salMapemp4, addemp4);
        Emp3 employee5 = new Emp3("105", "Amit", LocalDate.of(2001,5,1), salMapemp5, addemp5);

        List<Emp3> empList =new ArrayList<>();
        empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        empList.add(employee4);
        empList.add(employee5);
        if (empList.isEmpty()){
            throw new IllegalArgumentException("Employee list can not be empty");
        }
        // Perform the specified functions
        SumSalSameCity(empList);
        GrBySalYr(empList);
        AvgSalStateYearly(empList);
        NoEmpSameAdd(empList);
        EmpTaxFromSalYr(empList);
        sortEmpBySalary(empList);//6
        sortEmpByAddress(empList);  //7
        EmpCountSameCountry(empList);   //8
        SumSalInRange(empList, 20000, 100000);  //9
        SumAndCountByState(empList);//10
    }
    // 1: Find sum of salary for employees who live in the same city.
    static void SumSalSameCity(List<Emp3> employees) {
        System.out.println("\n1. Sum of salary for employees who live in the same city:");
        Map<String,Double> sumSalMap=new HashMap<>();
        Map<String,Integer> cityCount=new HashMap<>();
        for (Emp3 e:employees){
            String key=e.getAddRef().getCity().toLowerCase();
            sumSalMap.merge(key,e.getTotalSalary(),Double::sum);
            cityCount.merge(key,1,Integer::sum);
        }
        for (Map.Entry<String,Integer> e:cityCount.entrySet()){
                  if(e.getValue()>1) {
                      System.out.println(e.getKey() + " " + sumSalMap.get(e.getKey()));
                  }
        }
    }
   //  2: Find group of employees who have the same salary yearly.
     static void GrBySalYr(List<Emp3> employees) {
        System.out.println("\n2. Group of employees who have the same salary yearly:");
        Map<String, List<Emp3>> groupedBySalary = new HashMap<>();  //year-empList

        for (Emp3 emp : employees) {
            for (Map.Entry<String, Double> entry : emp.getYearlyMap().entrySet()) {
                double salaryKey = entry.getValue();
                String key= entry.getKey()+ " "+salaryKey;
                groupedBySalary.computeIfAbsent(key, k -> new ArrayList<>()).add(emp);
            }
        }
        for(Map.Entry<String,List<Emp3>> m:groupedBySalary.entrySet()){
            if(m.getValue().size()>1)
                System.out.println("20"+m.getKey()+" : "+m.getValue());
        }
    }
    // Function 3: Find average salary by state and yearly.
     static void AvgSalStateYearly(List<Emp3> employees) {
        System.out.println("\n3. Average salary by state and yearly:");
        Map<String, Double> stateAvgSalaryMap = new HashMap<>();   //state-salary
        Map<String, Integer> stateEmployeeCountMap = new HashMap<>();    //state-count

        for (Emp3 employee : employees) {
            for (Map.Entry<String,Double> e:employee.getYearlyMap().entrySet()){
                   String key=employee.getAddRef().getState().toLowerCase()+" 20"+e.getKey();
                   Double sal=e.getValue();
                stateAvgSalaryMap.put(key,stateAvgSalaryMap.getOrDefault(key,0.0)+sal);
                stateEmployeeCountMap.put(key,stateEmployeeCountMap.getOrDefault(key,0)+1);
//                stateEmployeeCountMap.merge(key, 1, Integer::sum);
            }
        }
        for (Map.Entry<String, Double> entry : stateAvgSalaryMap.entrySet()) {
            System.out.println(entry.getKey() + ": " +entry.getValue()/stateEmployeeCountMap.get(entry.getKey()));
        }
    }

    //4: Find number of employees who have the same address.
     static void NoEmpSameAdd(List<Emp3> employees) {
        System.out.println("\n4. Number of employees who have the same address:");
        Map<String, Integer> addressCountMap = new HashMap<>();   //address-empcount
        for (Emp3 employee : employees) {
            Integer i=addressCountMap.getOrDefault(employee.getAddRef().getAddress().toLowerCase(),0);
                 addressCountMap.put(employee.getAddRef().getAddress().toLowerCase(),i+1);
        }
        for (Map.Entry<String, Integer> entry : addressCountMap.entrySet()) {
            if(entry.getValue()>1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    // 5: Find the employees TDS/TAX from salary yearly.
     static void EmpTaxFromSalYr(List<Emp3> employees) {
        System.out.println("\n5. Employees TDS/TAX from salary yearly:");
        for (Emp3 employee : employees) {
            System.out.println("For (id="+employee.getId()+" name="+employee.getName()+"):");
            for (Map.Entry<String,Double> e:employee.getYearlyMap().entrySet()){
                String k= e.getKey();
                Double tax=(e.getValue()*0.3);  //after tds
                System.out.println("Tax/tds in 20"+k+" is = "+tax);
            }
        }
    }
    // 6: Sort employees by salary.
     static void sortEmpBySalary(List<Emp3> employees) {

        System.out.println("\n6. Sort employees by salary:");
         System.out.println("Ascending order");
         Collections.sort(employees,new CustomComprator(1));  //1 ascending order sorting
         for (Emp3 e : employees) {
             System.out.println(e.getId()+" "+e.getName() + ": " + e.getTotalSalary());
         }
         Collections.sort(employees,new CustomComprator(2));  //2 for descending order
         System.out.println("\nDescending order");
        for (Emp3 e : employees) {

            System.out.println(e.getId()+" "+e.getName() + ": " + e.getTotalSalary());
        }
    }

    //7.sorting by address
    static void sortEmpByAddress(List<Emp3> emp){
        Collections.sort(emp, new CustomComprator(3));
        System.out.println("\n7. Sorting according by address");
        for (Emp3 e:emp){
            System.out.println(e.getId()+" "+e.getName()+" :"+e.getAddRef());
        }

    }
    // 8: Find how many employees live in the same country.
     static void EmpCountSameCountry(List<Emp3> employees) {
        System.out.println("\n8. Number of employees living in the same country:");
        Map<String, Integer> countryEmployeeCountMap = new HashMap<>();    //country-empcount
        for (Emp3 employee : employees) {
            String country = employee.getAddRef().getCountry().toLowerCase();
            Integer i=countryEmployeeCountMap.getOrDefault(country,0);
            countryEmployeeCountMap.put(country,i+1);
        }

        for (Map.Entry<String, Integer> entry : countryEmployeeCountMap.entrySet()) {
            if (entry.getValue()>1){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    // 9: Find the sum of salary for employees in the given range.
     static void SumSalInRange(List<Emp3> employees, double minRange, double maxRange) {
        System.out.println("\n9. Sum of salary for employees in the range: " + minRange + " to " + maxRange);
        Map<String,ArrayList<Emp3>> countMap = new HashMap<>();   //year-emplist
        for (Emp3 employee : employees) {
                  for (Map.Entry<String,Double> e:employee.getYearlyMap().entrySet()){
                      Double sal=e.getValue();
                      if (sal >= minRange && sal <= maxRange) {
                            countMap.computeIfAbsent(e.getKey().toLowerCase(),i-> new ArrayList<>()).add(employee);
                      }
                  }
        }
        for (Map.Entry<String,ArrayList<Emp3 >> e:countMap.entrySet()){
            System.out.println("In 20"+e.getKey()+" sum of Salary in range="+e.getValue());
        }
    }
    // 10: Find the sum of salary and employee count by state.
     static void SumAndCountByState(List<Emp3> employees) {
        System.out.println("\n10. Sum of salary and employee count by state:");
        Map<String, Double> stateSumSalaryMap = new HashMap<>();  //state-salarytotal
        Map<String, Integer> stateEmployeeCountMap = new HashMap<>();  //state-empcount

        for (Emp3 employee : employees) {
            String state = employee.getAddRef().getState().toLowerCase();
            Double totalSalary = employee.getTotalSalary();
            Double sal=stateSumSalaryMap.getOrDefault(state,0.0);
            stateSumSalaryMap.put(state,sal+totalSalary);

            Integer i=stateEmployeeCountMap.getOrDefault(state,0);
            stateEmployeeCountMap.put(state,i+1);
        }

        for (Map.Entry<String, Double> entry : stateSumSalaryMap.entrySet()) {
            System.out.println(entry.getKey() + ": Sum of salary - " + entry.getValue() +
                    ", Employee count - " + stateEmployeeCountMap.get(entry.getKey()));
        }
    }
}
