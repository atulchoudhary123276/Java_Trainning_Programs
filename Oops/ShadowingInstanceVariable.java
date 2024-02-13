package Oops;
// Java program to demonstrates Shadowing in Java

// Class 1 and 2
// Outer Class
class Shadowing {

    // Instance variable or member variable
    String name = "Outer John";

    // Nested class
    // Inner Class
    class innerShadowing {

        // Instance variable or member variable
        String name = "Inner John";

        // Method of inner class
        // To print the content
        public void print(String name)
        {

            // Print statements

            System.out.println(name);
            // This keyword refers to current instance
            // itself
            System.out.println(this.name);
            System.out.println(Shadowing.this.name);
        }
    }
}

// Class 3
// Main class
public class ShadowingInstanceVariable {

    // Main driver method
    public static void main(String[] args)
    {

        // Accessing an inner class by
        // creating object of Outer class inside main()
        // method
        Shadowing obj = new Shadowing();

        Shadowing.innerShadowing innerObj
                = obj.new innerShadowing();

        // Function Call
        innerObj.print("Parameter John");
        System.out.println();
        System.out.println(obj.name);
        System.out.println(innerObj.name);

    }
}
