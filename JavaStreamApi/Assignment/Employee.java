package JavaStreamApi.Assignment;
import java.util.List;
class Employee {
    private int id;
    private String name;
    private List<Salary> salary;
    private int monthJoined;
    private int year;
    private String company;
    public Employee(int id, String name, List<Salary> salary, int monthJoined, int year, String company) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.monthJoined = monthJoined;
        this.year = year;
        this.company = company;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Salary> getSalaryList() {
        return salary;
    }
    public int getYear() {
        return year;
    }
    public int getMonthJoined() {
        return monthJoined;
    }
    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
