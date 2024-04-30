package Oops;
//Exception Propagation in Unchecked Exceptions
public class ExceptionPropagationUncheckedExc {
    void m()
    {
        int data = 50 / 0; // unchecked exception occurred
        // exception propagated to n()
    }
    void n()
    {
        m();
        // exception propagated to p()
    }
    void p()
    {
        try {
            n(); // exception handled
        }
        catch (Exception e) {
            System.out.println("Exception handled");
        }
    }
    public static void main(String[] args)
    {
        ExceptionPropagationUncheckedExc obj = new ExceptionPropagationUncheckedExc();
        obj.p();
        System.out.println("Normal flow...");
    }
}
