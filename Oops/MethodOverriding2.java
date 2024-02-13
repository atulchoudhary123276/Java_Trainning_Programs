package Oops;

import java.io.*;
class Superclass {
    static int i=5;
    void method() throws IOException{
        System.out.println("hello");
    }
}

class MethodOverriding extends Superclass {
    // Valid: Declares the same exception
//    i=10;
    @Override
   void method() throws IOException,RuntimeException{
        i=10;
        System.out.println("i="+i);
        int a=5/0;
        System.out.println("hello");
    }

    // Valid: Declares fewer exceptions
//    void method() {
//        System.out.println("hello");
//    }

}
public class MethodOverriding2{
    public static void main(String[] args){
        Superclass obj=new MethodOverriding();
        System.out.println("hello3");
        try{
            obj.method();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
