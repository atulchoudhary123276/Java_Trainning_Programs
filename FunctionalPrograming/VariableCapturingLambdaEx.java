package FunctionalPrograming;
interface MyFunction {
    int func(int n);
}
class Demo{
    static String str="Myname";
    int i;
}
public class VariableCapturingLambdaEx {
    public static void main(String[] args) {
        Demo d=new Demo();
        int number = 10;
        MyFunction myLambda = (n) -> {
            int value = number + n;         //local variable capturing only use not change effectively final
            Demo.str="MyNewName";           //static variable capturing
            d.i=6;                           //instance variable capturing
            return value;
        };
        System.out.println(myLambda.func(6));

    }
}
