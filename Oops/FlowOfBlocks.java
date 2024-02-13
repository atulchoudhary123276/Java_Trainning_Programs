package Oops;

//flow of blocks in program in between class and blocks
class MyClass {

     int value;
     static String name;

    // Constructor with one parameter
    public MyClass(int value) {
        this(31,20);
        this.value = value;
        System.out.println("Parameterized constructor called");
    }

    // Default constructor, which calls the parameterized constructor
    public MyClass() {
        this(42); // Calls the constructor with one parameter

        System.out.println("Default constructor called");
    }
    public MyClass(int value,int value1) {
         // Calls the constructor with one parameter
        System.out.println("P2 constructor called");
    }
    static {
        System.out.println("real class static");
        name="atul";

    }
    {
        name="atul_instant";
    }


}
class FlowOfBlocks {
    static {
        System.out.println("static start");
    }
    public static void main(String[] args) {
        System.out.println("i am main");
        MyClass obj1 = new MyClass();      // Calls the default constructor
        System.out.println("i am main2");
        System.out.println(obj1.value);   // Prints the value set in the constructors

        MyClass obj2 = new MyClass(10);   // Calls the parameterized constructor
        System.out.println(obj2.value);   // Prints the value set in the constructors
    }
    static {
        System.out.println("static last");
    }
}
