package JavaStreamApi.Assignment;

import java.time.LocalDate;

class Salary {
    private int id;
    private int salary;
    private LocalDate dateOfCredit;
    public Salary(int id, int salary,LocalDate dateOfCredit) {
        this.id = id;
        this.salary = salary;
        this.dateOfCredit=dateOfCredit;
    }
    public int getId() {
        return id;
    }
    public int getSalary() {
        return salary;
    }
    public LocalDate getDateOfCredit(){
        return dateOfCredit;
    }




}
