package Company_Collection.assignments.HashMapTask;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Emp3 {
        private  String id;
        private  String name;
        private LocalDate dob;
        private Map<String, Salary> salaryMap;
        private Address address;
        private Map<String,Double> yearlMap;
        public Emp3(String id, String name, LocalDate dob, Map<String,Salary> salaryMap, Address address) {
            if (id==null || id.isEmpty() ||name == null|| name.isEmpty() || salaryMap==null|| address == null ) {
                throw new IllegalArgumentException("Name,salaryMap, and address cannot be null or empty");
            }
            this.id = id;
            this.name = name;
            this.dob = dob;
            this.salaryMap = salaryMap;
            this.address = address;
            this.yearlMap=initYearlyMap();   //inti when emp instance create
        }
        public String getId() {
            return id;
        }
        public double getTotalSalary() {
            double sum = 0;
            for (Salary e1:salaryMap.values()) {
                sum =sum+e1.getSimpleSalary();
            }
            return sum;

        }
        public Address getAddRef(){
            return address;
        }
        public Map<String ,Double> initYearlyMap(){
            Map<String,Double> m=new HashMap<>();     //year,salarytotalyearly
            for (Map.Entry<String,Salary> e:salaryMap.entrySet()){
                String k=extractYear(e.getKey());
                Double sal=e.getValue().getSimpleSalary();
                Double d=m.getOrDefault(k,0.0);
                m.put(k,sal+d);
            }
            return m;
        }
        public Map<String,Double> getYearlyMap(){
            return yearlMap;
        }

        public String getName(){
            return name;
        }
        @Override
        public String toString() {
            return "id=" +id+" "+
                    "name='" + name + '\'';
        }
        public String extractYear(String monthYear) {
            String[] parts = monthYear.split("-");
            return parts[1];
        }
}
