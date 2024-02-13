package Company_Collection;
import Company.assignments.*;
public class ProtectedEx extends ProtectedExample  {
    ProtectedEx(){
        System.out.println("this is 2 ");

    }
    public static void main(String[] args) {
        ProtectedEx a=new ProtectedEx();
        Abs n=new Abs();


    }
}
class Abs{
    Abs(){
        System.out.println("external cons");
    }

}
