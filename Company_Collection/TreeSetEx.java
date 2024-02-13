package Company_Collection;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        SortedSet<String> tr=new TreeSet<>();
         tr.add("a");
         tr.add("d");
         tr.add("c");
         tr.add("f");
         tr.add("e");
         tr.add("b");
        System.out.println(tr);  //sorting base DNSO
        tr.add("E");
        System.out.println(tr);

        TreeSet<Integer> trr=new TreeSet<>(new Comparator<Integer>() {   //descending order comparator object
            @Override
            public int compare(Integer t1, Integer t2) {
                if(t1<t2) return -1;

                return 1;
            }
        });
        trr.add(2);
        trr.add(4);
        trr.add(9);
        trr.add(7);
        trr.add(6);
        System.out.println("trr"+trr);

        //methods
//        System.out.println((trr.);
        System.out.println(trr.first());
        System.out.println(trr.last());
        System.out.println(trr.headSet(4));
        System.out.println(trr.tailSet(4));
        System.out.println(trr.subSet(2,7));

        System.out.println(trr.comparator().getClass().getName());
        System.out.println(trr.pollFirst());
        System.out.println(trr.pollLast());
        System.out.println(trr.descendingSet());
        System.out.println(trr.descendingIterator());
        System.out.println(trr.floor(10));
        System.out.println(trr.ceiling(5));
        System.out.println(trr.lower(5));
        System.out.println(trr.higher(5));

    }

}
