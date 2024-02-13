package Oops;

import java.io.IOException;

class MethodOverloading3{
//    private final static void add(int a, int b)  {
//        System.out.println(a+b);
//    }

   void add(int a, short b){
        System.out.println(a+b);
    }
    int  add(float a, int b){
        System.out.println(b);
        return b;
    }
    protected  static int  add(int a, float b,int c){
        System.out.println(b+c);
        return c;
    }
    int  add(int a, float b){
        System.out.println(b);
        return a;
    }



}
public class MethodOverloading2{
    public static void main(String[] args){
        MethodOverloading3 ad=new MethodOverloading3();
//        ad.add(5,6);
        ad.add(5f,5);
        ad.add(5,5f);
        ad.add(5,7.5f,5);
//        ad.add(7.5f,7);

    }
}