package JavaStreamApi.OptionalClass;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class OptionalFlatMapExample {
    public static void main(String[] args) {
        // Example 1: flatMap with a non-empty Optional
        Optional<List<String>> source = Optional.of(Arrays.asList("atul","raman","sumit"));
        Optional<String> result1 = source.flatMap(s -> s.stream().findFirst() );

        System.out.println(result1.orElse("Default Value----")); // Output: Hello World

        // Example 2: flatMap with an empty Optional
        Optional<String> emptySource = Optional.empty();
        Optional<String> result2 = emptySource.flatMap(s -> Optional.of(s + " World"));

        System.out.println(result2.orElse("Default Value")); // Output: Default Value
    }
}
