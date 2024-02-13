package JavaStreamApi.Collect_Collector_collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningByEx {
         public static void main(String[] args)
        {
            //1.partitioningBy(predicate)
            Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            // method to split the stream of elements into
            // 2 parts, greater than 3 and less than 3.
            Map<Boolean, List<Integer>> map = s.collect(Collectors.partitioningBy(num -> num > 3));
            System.out.println("Elements in stream " + "partitioned by " + "less than equal to 3: \n" + map);

            //2.partitioningBy(predicate,Collector downstream)
            Stream<Integer> s1= Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

            // Using Collectors.counting() method to count the number of elements in the 2 partitions
            Map<Boolean, Long> map1 = s1.collect(Collectors.partitioningBy(num -> (num > 3), Collectors.counting()));
            System.out.println("Elements in stream " + "partitioned by " + "less than equal to 3: \n" + map1);
        }
    }

