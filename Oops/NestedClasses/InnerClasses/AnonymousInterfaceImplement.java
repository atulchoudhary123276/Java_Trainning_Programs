package Oops.NestedClasses.InnerClasses;
// Java program to demonstrate Need for
// Anonymous Inner class for implementing interface

// Interface
interface Age {

    // Defining variables and methods
    int x = 21;
    void getAge();
}

// Class 1
// Helper class implementing methods of Age Interface
//class MyClass implements Age {           ------this class now Anonymous Class here which help to interface implementations
//
//    // Overriding getAge() method
//    @Override public void getAge()
//    {
//        // Print statement
//        System.out.print("Age is " + x);
//    }
//}

// Class 2
// Main class
// AnonymousDemo
public class AnonymousInterfaceImplement {
    // Main driver method
    public static void main(String[] args)
    {
        // Class 1 is implementation class of Age interface
//        MyClass obj = new MyClass();
        //-------that's is AnonymousClassExtend of Myclass and also create object of myclass
           Age obj=new Age() {
               @Override
               public void getAge() {
                   System.out.println("Age is "+ x);
               }
               public void m2(){
                   System.out.println("hello extra method ");
               }
           };
        // calling getage() method implemented at Class1
        // inside main() method
        obj.getAge();
        try {
            obj.getClass().getMethod("m2").invoke(obj);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
