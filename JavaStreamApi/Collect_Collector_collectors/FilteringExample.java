package JavaStreamApi.Collect_Collector_collectors;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilteringExample {
    public static void main(String[] args) {
        List<Person1> persons = List.of(
                new Person1("John", "New York", 25),
                new Person1("Alice", "San Francisco", 30),
                new Person1("Bob", "New York", 22),
                new Person1("Charlie", "San Francisco", 35)
        );

        // Group persons by city, filtering those older than 25, and collect their names into a list
        Map<String, List<String>> personsByCity = persons.stream()
                .collect(Collectors.groupingBy(
                        Person1::getCity,
                        Collectors.filtering(
                                person -> person.getAge() > 25, // Predicate to filter persons older than 25
                                Collectors.mapping(Person1::getName, Collectors.toList())
                        )
                ));

        // Print the result
        personsByCity.forEach((city, names) ->
                System.out.println(city + ": " + names));
    }
}

class Person1 {
    private String name;
    private String city;
    private int age;

    public Person1(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
