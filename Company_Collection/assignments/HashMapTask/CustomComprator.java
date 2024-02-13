package Company_Collection.assignments.HashMapTask;

import java.util.Comparator;

public class CustomComprator implements Comparator<Emp3> {   //for sorting according by choise get from user for Salary and addrss
    private Integer choise;
    CustomComprator(){
        throw new IllegalArgumentException("please mention some choise");
    }
    CustomComprator(Integer i){

        this.choise=i;
    }
    @Override
    public int compare(Emp3 e1, Emp3 e2) {
        switch (choise) {
            case 1://ascending order
                return Double.compare(e1.getTotalSalary(), e2.getTotalSalary());
            case 2:  //descending order
                return Double.compare(e2.getTotalSalary(), e1.getTotalSalary());
            case 3:  //address sorting
                return e1.getAddRef().getAddress().toLowerCase().compareTo(e2.getAddRef().getAddress().toLowerCase());
            default:
                throw new IllegalArgumentException("please enter right choise in between 1- 3");

        }
    }
    }

