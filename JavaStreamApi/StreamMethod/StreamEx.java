package JavaStreamApi.StreamMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamEx {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("anmol");list.add("anshu");list.add("harsh");list.add("sumit");

         System.out.println(list.stream().map(String::toUpperCase).count());

//----filter
         Stream<String> streamOf= Stream.of("ramu","rahul","rani");
         streamOf.filter((x)->x.length()>4).forEach(System.out::println);

//--------Stream.of
         //create stream from array objects
         Stream<String> sDouble=Stream.of("12.22","10", "6.548", "9.12", "11", "15");

        System.out.println("mapToDouble ...... ");
         sDouble.mapToDouble((num)->Double.parseDouble(num)).forEach(System.out::println);

         //flat map method  -one to many mapping
        List<Integer> list1 =Arrays.asList(1,2);
        List<Integer> list2 =Arrays.asList(3,4);
        List<Integer> list3 =Arrays.asList(5,6);
        
        List<List<Integer>> mainList=Arrays.asList(list1,list2,list3);
        System.out.println(mainList);    //[[1, 2], [3, 4], [5, 6]]

        List<Integer> collect = mainList.stream().flatMap((li) -> li.stream().filter(x1->x1%2==0).map(x->x+5)).collect(Collectors.toList());
        System.out.println(collect);


    }
}

