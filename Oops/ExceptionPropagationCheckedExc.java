package Oops;
import java.io.IOException;
public class ExceptionPropagationCheckedExc {
    void m() throws IOException {
        throw new IOException("io error");         //checked exception occured
    }
    // exception propagated to p()
    void n() throws IOException {
        m();
    }
    void p(){
        try {
            //exception handled
            n();
        }
        catch (Exception e){
            System.out.println("exception handled");
        }
    }
    public static void main(String[] args) {
        ExceptionPropagationCheckedExc c=new ExceptionPropagationCheckedExc();
        c.p();
    }
}
