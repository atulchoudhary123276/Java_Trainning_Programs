package Company_Collection.Genrics;
// Java program to demonstrate Unbounded wildcard and wildcard capturing-helper method
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenricWildcard {
    public static  void addlist(List<?> li)
    {//   ?
        System.out.println(li.get(1));
//        li.add(3);
        addlistHelper(li,4);
    }
    public static <T> void addlistHelper(List<T> li, Integer i){    //wildcard capturing //helper mathod
        T n= li.get(0);
        li.add(n);
        System.out.println(li);

    }

    public static void main(String[] args)
    {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        addlist(list1);
        // Double list
        List<Double> list2 = Arrays.asList(1.1, 2.2, 3.3);

    }

}
