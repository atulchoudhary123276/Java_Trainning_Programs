package JavaStreamApi.OptionalClass;
import java.util.Optional;
import java.util.OptionalInt;

public class CreatingOptionals {

    public static void main(String[] args) {
        // to create an empty Optional
        Optional<Person> optionalPerson1 = Optional.empty();
        System.out.println(optionalPerson1);

        // to create an Optional from non-null value
        // this will throw an NPE if the null value provided
        Person person = new Person("Rahul", 15);
        Optional<Person> optionalPerson2 = Optional.of(person);
        System.out.println(optionalPerson2);

        // to create an Optional from a possibly null value
        Optional<Person> optionalPerson3 = Optional.ofNullable(null);
        Optional<Person> optionalPerson4 = Optional.ofNullable(person);
        System.out.println(optionalPerson3);
        System.out.println(optionalPerson4);
    }
}
class Person {
    private String name;
    private Optional<Integer> age;

    public Person(String name, int age) {
        this.name = name;
        this.age = Optional.of(age);
    }

    public String getName() {
        return name;
    }
    public Optional<Integer> getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
