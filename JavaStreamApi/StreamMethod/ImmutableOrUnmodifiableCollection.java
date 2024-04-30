package JavaStreamApi.StreamMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableOrUnmodifiableCollection {
    public static void main(String[] args) {
        //1.Arrays.asList   --partial immutable collection  (did not make copy only wrap the Array into list)
          Integer [] arr={1,4,3,6};
        List<Integer> arraysList= Arrays.asList(arr);      //partial immutable  collection only
//        arraysList.add(7);     //unsupportedoperationException
//        arraysList.remove(3);   ////unsupportedoperationException
        arraysList.set(1,11);
        arr[1]=100;  //changes exist on arraysList also bcz it did not make a new copy
        System.out.println(arraysList);

    //2. List.of  --immutable collection
      List<Integer> ofList=List.of(1,3,4,5);              //immutable collection return    //null not accepted
        //no operation perform
        System.out.println(ofList);

    //3.simple list  -mutable
        List<Integer> list=new ArrayList<>();
        list.add(6);list.add(7);list.add(8);
        System.out.println(list);

//4.Unmodifiable Collection   --immutable collection
        List<Integer> unList= Collections.unmodifiableList(list);
        //  unList.add(9);                   //unsupportedoperationException  because it is unmodifiable list ,use only for
                                                                     //unmodifiable view purpose
        System.out.println(unList);
        list.add(9);
//        list.add(null);       --it is not accepted by immutable collection
        System.out.println(unList);   //change exits

//5.CopyOf --immutableCollection (unmodifiable)
        List<Integer> immutableList=List.copyOf(list);      //immutable collection return    //null not accepted
//        immutableList.add(10);
        System.out.println(immutableList);
    }
}
