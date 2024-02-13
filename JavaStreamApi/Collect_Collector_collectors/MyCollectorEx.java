package JavaStreamApi.Collect_Collector_collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollectorEx {
    public static void main(String[] args) {
          List<Student> std= Arrays.asList(new Student(new int[]{23, 24, 47},"ramu",25),new Student(new int[]{20, 21, 40},"ramu",25),new Student(new int[]{20, 21, 40},"sumit",26),new Student(new int[]{20, 21, 40},"shamu",27));
          MyCollector m=new MyCollector();
          std.stream().collect(m).forEach(System.out::println);
                                                             //supplier  -acumulator --combiner
        ArrayList<Student> collect = std.stream().collect(() -> new ArrayList<Student>(), (list1, e) -> list1.add(e),(list11,list22)->list11.addAll(list22));


        System.out.println(collect);
    }
}
class MyCollector implements Collector<Student, List<Student>,List<Student>>{
    @Override
    public Supplier<List<Student>> supplier() {
        return ()->new ArrayList<Student>();
    }

    @Override
    public BiConsumer<List<Student>,Student> accumulator() {
        return (list,e)->list.add(e);
    }

    @Override
    public BinaryOperator<List<Student>> combiner() {
        return (list1,list2)->{
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Student>, List<Student>> finisher() {
        return (e)->e ;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}
class Student{
    int[] marks;
    String name;
    int age;

    public Student(int[] marks, String name, int age) {
        this.marks = marks;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "marks=" + Arrays.toString(marks) +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}