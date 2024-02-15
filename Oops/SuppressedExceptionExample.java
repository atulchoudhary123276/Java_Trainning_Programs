package Oops;
class SwingException extends Exception {}
class CloseException extends Exception {}

class Door implements AutoCloseable {
    public void swing() throws Exception {
        System.out.println("The door is becoming unhinged!");
        throw new SwingException(); /* Primary exception */
    }
    public void close() throws Exception {
        System.out.println("The door is now closed.");
        throw new CloseException(); /* Suppressed exception */
    }

}
public class SuppressedExceptionExample {

    public static void main(String[] args) throws Exception {

        try ( Door door = new Door() ) {
            door.swing(); /* Throws the SwingException */
        }
        catch (Exception e) {
            System.out.println("Primary Exception:  " + e.getClass());
            if (e.getSuppressed().length>0) {
                System.out.print("Suppressed Exception: " + e.getSuppressed()[0]);
            }
        }
    }
}
