package Oops.NestedClasses.InnerClasses;

abstract class ab{
    int a=10;
   abstract void m1();
}

public class AnonymousExtendClass {
    public static void main(String[] args) {
        int h=10;
        ab t=new ab() {
            final static int i=10;
            int k=10;

            @Override
            void m1() {
                System.out.println(i+k+h);
                System.out.println();
                System.out.println("hello this is m1 of abstract class");
            }
            public void m2(){
                System.out.println("m2 of anoynomus classs");
            }

        };
//        h++;       effectively final
        System.out.println(h);
        try {
            t.getClass().getMethod("m2").invoke(t);
        }
        catch (Exception e){
            System.out.println(e);
        }

        t.m1();


    }
}
