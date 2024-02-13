package JavaStreamApi.StreamMethod;

import java.util.*;
import java.util.Spliterator;

public class TryAdvanceTrySplitEx {         //parallelStream
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            num.add(i);
        }
        Spliterator<Integer> spliterator1 = num.spliterator();
//        spliterator1.forEachRemaining((n)-> System.out.println("n="+n));

        // Recursively split the Spliterator
        processSpliterator(spliterator1);

    }
    private static void processSpliterator(Spliterator<Integer> spliterator) {
        if (spliterator.estimateSize() <= 1) {
            // If the estimate size is 1 or less, we cannot split further
            System.out.println("Processing element: " + spliterator.tryAdvance(System.out::println));
        }
        else {
            // Try to split the Spliterator into two parts
            Spliterator<Integer> splitSpliterator = spliterator.trySplit();

            // Recursively process both parts
            processSpliterator(spliterator);
            processSpliterator(splitSpliterator);

        }
    }

}

