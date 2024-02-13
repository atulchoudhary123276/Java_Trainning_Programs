package FunctionalPrograming.MethodReference;
// If a lambda expression just call an instance method of a  ObjectType
        //(obj, args) -> obj.instanceMethod(args)
// Shorthand if a lambda expression just call an instance method of a ObjectType
        //ObjectType::instanceMethod
interface Finder2 {
    public int find(String s1, String s2);
}
class Myclass1{
    public  int doFind(String s1, String s2){
        return s1.indexOf(s2);
    }

}
public class ParameterMethodRef {
    public static void main(String[] args) {
        Myclass1 c=new Myclass1();
        Finder2 f=c::doFind;
        System.out.println(f.find("kkkppk","p"));

    }
}
