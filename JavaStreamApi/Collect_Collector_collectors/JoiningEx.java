package JavaStreamApi.Collect_Collector_collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningEx {
    public static void main(String[] args) {
        //1.joining()  -concatenates the input elements into a String, in encounter order
        List<Character> ch = Arrays.asList('G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G', 'e', 'e', 'k', 's');
        // Converting character list into string using joining() method of Collectors class
        String chString = ch.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(chString);

        char[] c = { 'G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G', 'e', 'e', 'k', 's' };
        String collectStr = Stream.of(c).map(chr -> new String(chr)).collect(Collectors.joining());
        System.out.println(collectStr);

        List<String> str = Arrays.asList("Geeks", "for", "Hum");
        System.out.println(str.stream().collect(Collectors.joining()));

        //2.joining(CharSequence delimiter)
        System.out.println(str.stream().collect(Collectors.joining(",")));

        //3.joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
        System.out.println(str.stream().collect(Collectors.joining(",","pre","suf")));

    }
}
