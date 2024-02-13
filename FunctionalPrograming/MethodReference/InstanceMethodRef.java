package FunctionalPrograming.MethodReference;
// If a lambda expression just call a default method of an object
       //(args) -> obj.instanceMethod(args)
// Shorthand if a lambda expression just call a default method of an object
      //obj::instanceMethod

interface Finder1 {
     int find(String s1, String s2);
}
class Myclass{
    public  int doFind(String s1, String s2){
        return s1.length()+s2.length();
    }

}
public class InstanceMethodRef {
    public static void main(String[] args) {
        Myclass c=new Myclass();
        Finder1 f=c::doFind;
        System.out.println(f.find("kkkk","pppp"));

    }
}
