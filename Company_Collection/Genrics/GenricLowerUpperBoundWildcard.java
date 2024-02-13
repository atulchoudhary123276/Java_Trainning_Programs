package Company_Collection.Genrics;

import java.util.ArrayList;
import java.util.List;

class LowerBound{
     static void addOnList(List<? super Integer> li){  //write(add) only
           li.add(5);
           li.add(6);
           li.add(7);
           Object n=li.get(3);       //access only by Object reference
         System.out.println(n);
         System.out.println(li.get(0));              //read also
     }

}
class UpperBound{
    static void display(List<? extends Number> li){   //read only
        for (Number n:li){
            System.out.print(n+", ");
        }
        System.out.println();
//        li.add(3);                     //compile time error

    }

}


public class GenricLowerUpperBoundWildcard {
    public static void main(String[] args) {
        List<Number> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3.5);
          UpperBound.display(list);
           LowerBound.addOnList(list);
           UpperBound.display(list);
    }
}
