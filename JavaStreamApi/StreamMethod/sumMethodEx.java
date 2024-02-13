package JavaStreamApi.StreamMethod;

import java.util.Arrays;
import java.util.List;

public class sumMethodEx {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int sum = list.stream().mapToInt(i->i).sum();

        System.out.println(sum);  // prints 15
    }
}
