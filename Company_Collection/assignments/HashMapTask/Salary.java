package Company_Collection.assignments.HashMapTask;
import java.time.LocalDate;

public class Salary {
        private  int id;
        private LocalDate saldate;
        private  double basicSal;
        private  double hra;
        private  double da;
        private  double epf;
        public Salary(int id, LocalDate date, double basic, double hra, double da, double epf) {
            if (date == null) {
                throw new IllegalArgumentException("Date cannot be null");
            }
            this.id = id;
            this.saldate = date;
            this.basicSal = basic;
            this.hra = hra;
            this.da = da;
            this.epf = epf;
        }
        public double getSimpleSalary() {
            return basicSal + hra +da- epf;
        }

    }
