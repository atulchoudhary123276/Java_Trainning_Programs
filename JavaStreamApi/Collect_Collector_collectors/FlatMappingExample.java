package JavaStreamApi.Collect_Collector_collectors;
//jdk 9
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMappingExample {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("John", "New York"),
                new Person("Alice", "San Francisco"),
                new Person("Bob", "New York"),
                new Person("Charlie", "San Francisco")
        );

        // Group persons by city and collect their names into a list
        Map<String, List<String>> personsByCity = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getCity,
                        Collectors.flatMapping(
                                person -> person.getAliases().stream(), // Function to get a stream of aliases
                                Collectors.toList()
                        )
                ));

        // Print the result
        personsByCity.forEach((city, aliases) ->
                System.out.println(city + ": " + aliases));
    }
}

class Person {
    private String name;
    private String city;
    private List<String> aliases;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
        // Assuming you have a method to retrieve aliases for a person
        this.aliases = List.of(name.toUpperCase(), name.toLowerCase());
    }

    public String getCity() {
        return city;
    }

    public List<String> getAliases() {
        return aliases;
    }
}
