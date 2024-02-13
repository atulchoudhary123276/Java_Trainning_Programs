package Company_Collection.assignments;

import java.util.*;

class Employee1 implements Comparable<Employee1>{
    private double salary;
    private int id;
    private int month;
    private int year;
    private String name;
    private String cmpName;

    public Employee1(int id, double salary, int month, int year, String name, String cmpName) {
        this.id = id;
        this.salary = salary;
        this.month = month;
        this.year=year;
        this.name = name;
        this.cmpName = cmpName;
    }

    public int getId() {
        return id;
    }

    public double getSalary(){
        return salary;
    }

    public String getCmpName() {
        return cmpName;
    }

    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    // Default sorting by name
    @Override
    public int compareTo(Employee1 other) {
        return this.name.compareTo(other.getName());
    }
    //sorting by ascending order of salary
    public static Comparator<Employee1> SalaryAscending=new Comparator<Employee1>() {
        @Override
        public int compare(Employee1 t1, Employee1 t2) {

            return Double.compare(t1.getSalary(),t2.getSalary());
        }
    };

    //sorting by descending order of salary
    public  static Comparator<Employee1> SalaryDescending=new Comparator<Employee1>() {
        @Override
        public int compare(Employee1 t1, Employee1 t2) {

            return Double.compare(t2.getSalary(),t1.getSalary());
        }
    };
}

public class LinkedlistTask {
    public static void main(String[] args) {
        List<Employee1> emp = new LinkedList<>();
        emp.add(new Employee1(120, 30000, 01, 2023,"Amit Gupta", "Technosoft Pvt"));
        emp.add(new Employee1(121, 20000, 02, 2023,"Karan Tiwari", "Racl GearTech"));
        emp.add(new Employee1(122, 40000, 06, 2023,"Prashant Sharma", "RedTape pvt"));
        emp.add(new Employee1(123, 25000, 07, 2023,"Sumit Jain", "RedDoorz tech"));
        emp.add(new Employee1(124, 50000, 03, 2023,"Rani G", "Technosoft Pvt"));


        // Sum of Salary
        double sumOfSalary = 0;
        for (Employee1 employee : emp) {
            sumOfSalary += employee.getSalary();
        }
        System.out.println("Sum of Salary: " + sumOfSalary);

        //companies list
        LinkedList<String> cmpList=new LinkedList<>();
        for(Employee1 e:emp){
            if(!cmpList.contains(e.getCmpName()))
                cmpList.add(e.getCmpName());
        }
        // Average Salary in a year
         double totalSalaryForYear=0;
        int employeeCountForYear=0;
        int y=2023;
        for (Employee1 e:emp){
            if (e.getYear()==y){
                totalSalaryForYear+=e.getSalary();
                employeeCountForYear++;
            }
        }
        if (employeeCountForYear>0){
            System.out.println("Average Salary of Employees yearly: " + totalSalaryForYear/employeeCountForYear);
        }
        else {
            System.out.println("Average Salary of Employees of %d yearly: " + totalSalaryForYear/employeeCountForYear);

        }

        // Sum of Salary by Companies
        System.out.println("\nSum of Salary by Companies:");
        for(String c:cmpList){
            double sal=0;
            for(Employee1 e:emp){
                if(c.equals(e.getCmpName()))
                    sal+=e.getSalary();
            }
            System.out.println(c+": "+ sal);
        }

        // June Month Credited Salaried Employee
        System.out.println("\nJune Month Credited Salaried New Employee:- ");
        for (Employee1 employee : emp) {
            if (employee.getMonth()==6&&employee.getYear()==2023) {
                System.out.println( employee.getId()+" - "+employee.getName()+" : "+employee.getSalary());
            }
        }

        // Sorting by Name (Default)
        Collections.sort(emp);
        System.out.println("\nSorting by Name (Default): ");
        for (Employee1 e:emp){
            System.out.println(e.getName());
        }

        // Sorting by Salary (Ascending)
        Collections.sort(emp, Employee1.SalaryAscending);
        System.out.println("\nSorting by Salary (Ascending Order): ");
        for (Employee1 e:emp){
            System.out.println(e.getName()+" : "+e.getSalary());
        }
        // Sorting by Salary (Descending)
        Collections.sort(emp, Employee1.SalaryDescending);
        System.out.println("\nSorting by Salary (Descending Order): ");
        for (Employee1 e:emp){
            System.out.println(e.getName()+" : "+e.getSalary());
        }
    }
}
