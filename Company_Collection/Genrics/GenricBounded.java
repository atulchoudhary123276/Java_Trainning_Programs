package Company_Collection.Genrics;
interface A{
    default void dPrint(){
        System.out.println("dprint");
    }
    void print();
}
class B implements A{
    @Override
    public void print() {
        System.out.println("print");
    }
    void PrintNew(){
        System.out.println("new print");
    }
}
class Bound<T extends B & A> {
      T obj;
      Bound(T obj){
          this.obj=obj;
      }
    void call(){
          obj.dPrint();
          obj.print();
          obj.PrintNew();

        System.out.println("hello ....");
    }
}

public class GenricBounded {
    public static void main(String[] args) {
               Bound<B> obj=new Bound<B>(new B());
               obj.call();


    }
}
