package Oops;

public class OverloadingObject {

    public void method(String str){
        System.out.println("String");
    }
    public void method(Object obj){
        System.out.println("Object");
    }
//    public void method(Integer in){
//        System.out.println("integer");
//    }
    public void method(int it){
        System.out.println("integer");
    }
    public void method(Number num){
        System.out.println("number");
    }
    public static void main(String... arg){


        new OverloadingObject().method("A");
//        new OverloadingObject().method(null);
//        new OverloadingObject().method(null);
        new OverloadingObject().method(0);
        new OverloadingObject().method('a');
    }

}