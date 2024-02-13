package FunctionalPrograming.MethodReference;
// If a lambda expression just create an object
     //(args) -> new ClassName(args)
// Shorthand if a lambda expression just create an object
            //ClassName::new
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student{
    String name;
    Student(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class ConstructorRef {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("ram","shyam","kishna");
//        List<Student> studentList = names.stream().map(x -> new Student(x)).collect(Collectors.toList());
        List<Student> studentList = names.stream().map(Student::new).collect(Collectors.toList());
        System.out.println(studentList);
    }
}
