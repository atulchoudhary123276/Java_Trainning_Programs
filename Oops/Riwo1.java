package Oops;

public class Riwo1 {
    static
    {
//        System.out.println(i);
        System.out.println("block1 static");
    }
    static int i=10 ;
    public static void main(String[] args)
    {
        System.out.println("main block");
    }

    static {
        System.out.println(i);
        System.out.println("static last");
    }
}
