package Oops;

class Demo{
    static int i=10; //only memory save key point
}
class Demo2 extends Demo{
    static int i=12;
}
public class StaticVariable {

    public static void main(String[] args) {
        Demo obj=new Demo();
        System.out.println(obj.i);  //object reference
        obj.i=11;
        System.out.println(Demo.i);  //class name
        Demo obj2=new Demo2();
        Demo2 obj3=new Demo2();
        System.out.println(obj2.i);    //reference variable through call
        obj3.i=13;
        System.out.println(obj3.i);    //reference variable through call

    }
}
