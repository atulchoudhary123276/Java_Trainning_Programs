package JavaStreamApi.Collect_Collector_collectors;
// toMap() method without unique keys

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class ToMapEx {
    public static void main(String[] args)
    {    //1.toMap(Function keymapper,Function ValueMapper)
        // Create a String with no repeated keys
        Stream<String[]> st = Stream.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "G", "Geeks" } });
        Map<String, String> m = st.collect(Collectors.toMap(p -> p[0], p -> p[1]));
        System.out.println("Map:" + m);

        //2.toMap(Function keymapper,Function ValueMapper,BiFunction mergeFunction)
        // Create a String with repeated keys
        Stream<String[]> str = Stream.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "GFG", "geeksforgeeks" } });
        Map<String, String> map = str.collect(Collectors.toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a));
        System.out.println("Map:" + map);

        //3.toMap(Function keymapper,Function ValueMapper,BiFunction mergeFunction,Supplier mapSupplier)
        Stream<String[]> str1 = Stream.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "GFG", "geeksforgeeks" } });
        LinkedHashMap<String, String> map2 = str1.collect(Collectors.toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a, LinkedHashMap::new));  //supplier
        System.out.println("Map:" + map2);
    }
}
