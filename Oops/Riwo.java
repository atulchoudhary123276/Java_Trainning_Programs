package Oops;

public class Riwo {
    static
    {
//        System.out.println(i);    //compile time error forward expression
        print();                  //indirect read
        System.out.println("block1");
    }
    static void print(){
        System.out.println(i);
    }
    static int i = 10;

    public static void main(String[] args)
    {
        System.out.println("y="+y);
        System.out.println("main block");
    }
    static int y=15;
    static {
        System.out.println(i);
    }

}
