package Oops;

public class StackOverflowAndOutOfMemoryExample {

    public static void main(String[] args) {
        // Uncomment one of the following lines to observe the respective error

        // Uncomment this line for StackOverflowError
//        try {


//            recursiveMethod(1);
//        }
//        catch (Error e){
//            System.out.println("erroe in rec  "+e);
//        }

        // Uncomment this line for OutOfMemoryError
//        try {
            createOutOfMemory();
//        }
//        catch(Error e){
//            System.out.println("array error  "+e);
//        }
    }

    // Method causing StackOverflowError
    private static void recursiveMethod(int i) {
        System.out.println("Iteration: " + i);
        recursiveMethod(i + 1);
    }

    // Method causing OutOfMemoryError
    private static void createOutOfMemory() {
        long[] array = new long[Integer.MAX_VALUE];  //to try to create an array that is too large, resulting in an OutOfMemoryError.
    }
}
