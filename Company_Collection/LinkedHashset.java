package Company_Collection;

import java.util.*;
import java.util.Collections;
import java.util.ListIterator;

public class LinkedHashset {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lset=new LinkedHashSet<Integer>();
         lset.add(2);
         lset.add(8);
         lset.add(3);
         lset.add(1);
         lset.add(4);
//        Collections.sort(lset);
        System.out.println(lset);
        List<Integer> list=new ArrayList<>(lset);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(lset);

        Integer[] arr=lset.toArray(new Integer[0]);
        for(Integer i:arr){
            System.out.print(i+" ,");
        }
        System.out.println();
        System.out.println(lset.getClass().getName());

        //iterator
        ListIterator<Integer> it= list.listIterator(2);
        while (it.hasNext()){
            System.out.println(it.next());
        }


    }
}
