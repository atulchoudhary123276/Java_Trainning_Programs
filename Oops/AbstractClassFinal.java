package Oops;

abstract class Sian                 //ABSTRACT CLASS
{
    public final void m1(){      // FINAL METHOD
        System.out.println("final method");
    }
    public  static void show()        //static method
    {
        System.out.println("static abstract class method");
    }
    public void display()
    {
        System.out.println("Overriding");
    }
    public abstract void success();
}
class AbstractClassFinal extends Sian               //INHERTING ABSTRACT CLASS
{

    public  static void show()        // static METHOD
    {
        System.out.println("Static child");
    }
    public void display()
    {
        System.out.println("Overridden");
    }
    public void success()               //OVERRIDING THE ABSTRACT METHOD
    {
        System.out.println("Success overriding");
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        AbstractClassFinal id = new AbstractClassFinal();       //OBJECT OF SUBCLASS
        id.m1();  //CALLING FINAL METHOD
        id.show();
        id.display();                   //OVERRIDDEN METHODS
        id.success();
        Sian obj=new AbstractClassFinal();
        obj.show();  //static method
    }
}