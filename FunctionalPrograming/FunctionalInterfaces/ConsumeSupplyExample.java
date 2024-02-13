package FunctionalPrograming.FunctionalInterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumeSupplyExample {
    public static void main(String[] args) {
        Consumer<String> c= System.out::println;
        c.accept("hello");

        Supplier<Integer> n=()->2;
        System.out.println(n.get());

        BiConsumer<String,String> bc=(s1,s2)-> System.out.println(s1+"   "+s2);
        bc.accept("hello","World");

        //Bi-supplier did not exits bcz supplier can not return two values at a time
    }
}
