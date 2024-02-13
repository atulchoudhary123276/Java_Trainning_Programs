package Oops;

class x{
    static class Y {
        static String z ="black" ; //heap
    }
    static C Y=new C();
}
class C{
    String z="white";  //pool
}

public class Static {
    public static void main(String[] args) {
        System.out.println(x.Y.z);
    }
}
