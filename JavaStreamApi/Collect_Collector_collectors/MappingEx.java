package JavaStreamApi.Collect_Collector_collectors;

import java.util.List;
import java.util.stream.Collectors;

public class MappingEx {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        // Use mapping to transform each name to its length
        //mapping(Function mapper, Collector downstream)
        List<Integer> nameLengths = names.stream().collect(Collectors.mapping(String::length, Collectors.toList()));
        System.out.println(nameLengths);
    }
}
