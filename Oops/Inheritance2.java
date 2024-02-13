package Oops;

class Inheritance1 {
    private static final int p=10;
   //init
    {
        System.out.println("parent init");
    }
    static String get(){
        return "hello";
    }
    void one(){
        System.out.println("parent menthod override");
    }
}
class Inheritance2 extends Inheritance1{
    private static  int p=20;
    void one(){
        System.out.println("child method override");
    }

    public static void main(String[] args) {
        Inheritance2 obj=new Inheritance2();
//        Inheritance1 obj=new Inheritance2();
        obj.one();
//        System.out.println(Inheritance1.p);
        System.out.println(Inheritance2.p);

    }
}
