package Oops;

//parent class
class DemoStatic
{
    public static void method1()
    {
        System.out.println("Method-1 of the Demo class is executed.");
    }
    public void method2()
    {
        System.out.println("Method-2 of the Demo class is executed.");
    }
}
//child class
class Sample extends DemoStatic
{
    public static void method1()
    {
        System.out.println("Method-1 of the Sample class is executed.");
    }
    public void method2()
    {
        System.out.println("Method-2 of the Sample class is executed.");
    }

}
class Sample2 extends Sample{
    public static void method1(){
        System.out.println("third class stati method1");
    }
}
public class StaticHiding {
    public static void main(String args[])
    {
        DemoStatic d1 = new DemoStatic();
//d2 is reference variable of class Demo that points to object of class Sample
        DemoStatic d2 = new Sample2();
        d2=new Sample();
//method calling with reference (method hiding)
        d1.method1();
        d2.method1();
        //hiding in this call
//method calling with object (method overriding)
//        d1.method2();
//        d2.method2();
        DemoStatic d3=new Sample2();
        d3.method1();
        Sample s=new Sample2();
        s=new Sample();
        s.method1();
    }
}