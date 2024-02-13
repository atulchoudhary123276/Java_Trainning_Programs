package FunctionalPrograming.FunctionalInterfaces;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.UnaryOperator;
@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
    boolean equals(Object obj);
    default <W> TriFunction<T, U, V, W> andThen(Function<? super R, ? extends W> after) {
        Objects.requireNonNull(after);
        return (t, u, v) -> after.apply(apply(t, u, v));
    }
}
public class TriFunctionCustom {
    public static void main(String[] args) {
        TriFunction<Integer, Double, String, String> concatenate = (i, d, s) ->{
            if (s==null||s.isEmpty())
                throw new IllegalArgumentException("Invalid String Input");

            return "result: " + i + " " + d + " " + s+i;
        };
        System.out.println(concatenate.apply(52, 8.1, "Anshuman"));

        UnaryOperator<String> newFun=(res)->"SUBSTRING: "+res.substring(0,15).toUpperCase();
        TriFunction<Integer, Double, String, String> upperCaseRes = concatenate.andThen(newFun);

        // Using the composed TriFunction
        System.out.println(upperCaseRes.apply(52, 8.1, "Anshuman"));


    }
}
