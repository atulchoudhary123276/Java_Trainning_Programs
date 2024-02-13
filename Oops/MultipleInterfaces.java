package Oops;

interface A1{  //method have public access level in interface
   final public static int a1=10;  // all variable are final,static and public in interface
     default String sayHello(){
        System.out.println("A say hello");
        return "a!";
    }
    static void print(){  //utility method only not inherit

         System.out.println("hello static");
    }
   public abstract int square(int a);   // we can't use final ,abstract both at a time //all methods are public,abstract
//   private int b1=11;       // not allowed
}
interface B1{
    default String sayHello(){
        System.out.println("B say hello");
       return "b1";

    }
    private String privateHello(){             //private method
        System.out.println("private hello of B");
        return "PV";
    }
    static void print(){
        System.out.println("hello static");
    }

}
public class MultipleInterfaces implements A1,B1{
    public int square(int a){
        return a*a;
    }
    @Override
    public String sayHello(){
        //A1.super.sayHello();
        //B1.super.sayHello();

        System.out.println("overriden child");
        return "gotit";
    }
    public static void main(String[] args) {
        MultipleInterfaces obj=new MultipleInterfaces();
        //System.out.println(obj.sayHello());
        A1.print();  //static methos call by interface

        obj.sayHello();
        System.out.println(obj.square(8));

        A1 a=new MultipleInterfaces();
        B1 b=new MultipleInterfaces();
         a.sayHello();
         b.sayHello();
         print();  // static method call

        System.out.println(a1);  //static variable


    }
   static void print(){    //static method in implement class
       System.out.println("static method in implement class");
   }
}
