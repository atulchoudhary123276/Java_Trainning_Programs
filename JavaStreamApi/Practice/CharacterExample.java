package JavaStreamApi.Practice;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterExample {
    public static void main(String[] args) {
        String str="this_is_the_company";

        str.chars()
                .mapToObj(i -> i)
                .filter(integer -> !String.valueOf((char) integer.intValue()).equals("_"))
//                .filter(i -> i != '_')
                .collect(Collectors.groupingBy(i -> i
                        ,TreeMap::new
                                ,Collectors.counting()
                        ))
                .forEach((k,v)-> System.out.println((char)k.intValue()+" "+v));


    }
}
