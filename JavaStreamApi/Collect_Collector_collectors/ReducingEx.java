package JavaStreamApi.Collect_Collector_collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducingEx {
    public static void main(String[] args) {
        //1.reducing(Binarypeartor op)
        Stream<Integer> s = Stream.of(5, 10, 20, 50);
        Integer i = s.collect(Collectors.reducing((integer, integer2) -> integer2 - integer)).orElse(-1);
        System.out.println(i);

        //2.reducing(identity,BinaryOperator)
        Stream<Integer> s1 = Stream.of(5, 10, 20, 50);
        Integer i1 = s1.collect(Collectors.reducing(3, (integer, integer2) -> integer2 + integer));
        System.out.println(i1);

        //3.reducing (identity,Bifunction,BinaryOpeartor)
        //--function -mapper: A function that transforms each element of the stream from type T to type U. It is of type Function<? super T, ? extends U>.
        Stream<Integer> s2 = Stream.of(5, 10, 20, 50).parallel();
        String str = s2.collect(Collectors.reducing("  ", x -> Integer.toString(x), (s11, s22) -> s11 + s22));
        System.out.println(str);
    }
}
