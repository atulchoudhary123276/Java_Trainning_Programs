package JavaStreamApi.StreamMethod;

import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharacterStream {
    public static void main(String[] args) {
        String s="java programing";
        IntStream i=s.chars();

        Character[] c1={'a','b','c'};
        char[] c=s.toCharArray();
//        Arrays.stream(c1).forEach(System.out::println);  //run
//        Arrays.stream(c).map;
        i.mapToObj(m->(char)m).collect(Collectors.toMap(Function.identity(), e1->String.valueOf(e1),
                (old,new1)->old+new1)).forEach((k,v)->{
                    if (v.length()>1){
                        System.out.println(v.charAt(0));
//                        System.exit(0);
                    }
        });
        //2nd approach
        String input = "Feel the need";
        Set<Integer> seen = new HashSet<>();
        OptionalInt first = input.chars()
                .filter(i1 -> !seen.add(i1))
                .findFirst();
        if (first.isPresent()) {
            System.out.println((char) first.getAsInt());
        }
    }
}
