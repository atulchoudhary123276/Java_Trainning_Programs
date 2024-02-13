package FunctionalPrograming.MethodReference;
// If a lambda expression just call a static method of a class
               //(args) -> Class.staticMethod(args)

// Shorthand if a lambda expression just call a static method of a class
             //Class::staticMethod
 interface Finder {
     int find(String s1, String s2);
}
interface Printer{
     String print(String s1,String s2);
}
public class StaticMethodRef {
    public static int doFind(String s1, String s2){
        return s1.lastIndexOf(s2);
    }
    public static String doPrint(String s1,String s2){
        return s1+" "+s2;
    }

    public static void main(String[] args) {

        Finder f=StaticMethodRef::doFind;
        System.out.println(f.find("atlulchoudhary","l"));

        Printer f2=StaticMethodRef::doPrint;
        System.out.println(f2.print("atul","choudhary"));

    }
}
