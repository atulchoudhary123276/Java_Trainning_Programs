package FunctionalPrograming.FunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        System.out.println(isEven.test(4));
//and
        Predicate<String> p1 = (s) -> s.length() > 5;
        System.out.println(p1.test("Hello World"));
        Predicate<String> p2 = (s) -> s.length() > 10;
        System.out.println(p1.and(p2).test("Hello World"));
//or
         Predicate<String> p3=p1.or(p2);
        System.out.println("or ex:"+p3.test("rajput"));

//isEquals static
        Predicate<String> p4=Predicate.isEqual("hello");
        System.out.println(p4.test("hello"));

        //Bi-Predicate also which work on 2 arguments

    }
}
