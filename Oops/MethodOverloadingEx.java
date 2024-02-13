import java.io.IOException;
public class MethodOverloadingEx {
    double method(int i) throws IOException {
        return i/0;
    }
    boolean method(boolean b) throws RuntimeException  {
        return !b;
    }
    static double method(int x, double y) throws IOException {
        return x + y ;
    }
    static double method(double x, double y) {
        return x + y - 3;
    }
    public static void main(String[] args) {
        MethodOverloadingEx mn = new MethodOverloadingEx();
        try {

            System.out.println(method(10.0, 20));
            System.out.println(method(10.0, 20.0));
            System.out.println(mn.method(10));
        }
        catch (Exception ex) {
            System.out.println("exception occoure: "+ ex);
        }
    }
}