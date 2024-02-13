package FunctionalPrograming.FunctionalInterfaces;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionExample {
    public static void main(String[] args) {
        //Function is a functional interface
        Function<String, Integer> f1 = (s) -> s.length();
        System.out.println(f1.apply("Hello World"));

        Function<Integer, Integer> f2 = (n) -> n * n;
        System.out.println(f2.apply(4));
        //andThen()
        System.out.println("and then :"+f1.andThen(f2).apply("rajput"));
        //compose
        System.out.println("compose method:"+f2.compose(f1).apply("hwwwwwww"));
        //identity
        Function<String,String> f3=Function.identity();
        System.out.println(f3.apply("hello my name"));
        //UnaryOperator function interface is a special case of Function ,child of Function ,use for same input or return
        UnaryOperator<Integer> u = (n) -> n * n;
        System.out.println(u.apply(4));


        BiFunction<String,String,Integer> ff=(s1,s2) -> s1.compareTo(s2);
        System.out.println("bifunction :"+ff.apply("hello","Hello"));

        //it is chid of Bifunction interface which work only on same input and return
        BinaryOperator<String> fff=(s1,s2)->s1.toLowerCase()+s2.toLowerCase();
        System.out.println(fff.apply("hello","    ->myword"));

    }
}
